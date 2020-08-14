package com.example.payment_component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.payment_component.dao.*;
import com.example.payment_component.model.*;;


@RestController
public class PaymentController {

    @Autowired
    FeignService feignClient;
    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    FeignServiceForex service1;

    @GetMapping("{a}/{b}")
    public String sak(@PathVariable Integer a ,@PathVariable Long b)
    {
    	return feignClient.getPaymentStatus(a,b);
    }
    
    @RequestMapping("/getPaymentStatus/{id}/{ref}")
    public String getStatus(@PathVariable Integer id,@PathVariable Long ref){
        return feignClient.getPaymentStatus(id,ref);
    }


    @PostMapping("/localPayment")
    public LocalPaymentResponse doLocalPayments(@RequestBody LocalPaymentRequest request)
    {
        return feignClient.localPayment(request);
    }


    @PostMapping("/crossPayment")
    public CrossPaymentResponse doCrossBorderPayments(@RequestBody CrossPaymentRequest request)
    {
        String paymentStatus="Failed";
        Double rates=service1.getForexRates(request.baseCurrency,request.targetCurrency);
        UPDCrossPayment requestCross=new UPDCrossPayment(request.customerId,request.sourceAccNumber,request.targetAccNumber,request.amount,request.baseCurrency,request.targetCurrency,request.timestamp,request.transactionReferenceNumber,request.paymentStatus,rates);
        return feignClient.crossPayment(requestCross);
    }


    @PostMapping("/thirdparty")
    public LocalPaymentResponse doThirdPartyPayments(@RequestBody ThirdPartyRequest request) {
        Customer customer = new Customer();
        LocalPaymentResponse response = null;
        CrossPaymentResponse crossPaymentResponse = null;

        if (request.getCreditcard_no() != null) {
            customer = paymentRepo.findByCreditcardNo(request.getCreditcard_no());
            Double rates=null;
            if(request.getType().equals("cross"))
            rates=service1.getForexRates("INR",request.getTargetCurrency());
            UPDCrossPayment updCrossPayment = new UPDCrossPayment(customer.getcustId(),customer.getaccount(),request.getRequestedBy(),request.getAmount(),"INR",request.getTargetCurrency(),null,null,null,rates);
            crossPaymentResponse=feignClient.creditCardPayment(updCrossPayment);
            response=new LocalPaymentResponse(crossPaymentResponse.customerId,crossPaymentResponse.paymentStatus,crossPaymentResponse.transactionReferenceNumber,crossPaymentResponse.timestamp);
            return response;

        } else if (request.getDebitcard_no() != null) {
            customer = paymentRepo.findByDebitcardNo(request.getDebitcard_no());

        } else {
            customer = paymentRepo.findByUpi(request.getUpiid());
        }

        if (request.getType().equals("local")) {
            LocalPaymentRequest localPaymentRequest = new LocalPaymentRequest(customer.getcustId(),customer.getaccount(),request.getRequestedBy(),request.getAmount(),"INR",null,null,null);
            response=feignClient.localPayment(localPaymentRequest);
            return response;
        } else  {

            Double rates = service1.getForexRates("INR",request.getTargetCurrency());
            UPDCrossPayment updCrossPayment = new UPDCrossPayment(customer.getcustId(),customer.getaccount(),request.getRequestedBy(),request.getAmount(),"INR",request.getTargetCurrency(),null,null,null,rates);
            crossPaymentResponse=feignClient.crossPayment(updCrossPayment);
            response=new LocalPaymentResponse(crossPaymentResponse.customerId,crossPaymentResponse.paymentStatus,crossPaymentResponse.transactionReferenceNumber,crossPaymentResponse.timestamp);
            return response;
        }


    }
	


}
