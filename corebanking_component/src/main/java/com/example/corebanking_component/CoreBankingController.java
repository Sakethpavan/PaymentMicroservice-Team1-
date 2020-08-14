package com.example.corebanking_component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corebanking_component.dao.*;
import com.example.corebanking_component.model.*;



@RestController
public class CoreBankingController {

    @Autowired
    BankRepo repo;
    @Autowired
    TransactionRepo tRepo;
    
    @RequestMapping("/getPaymentStatus/{customerId}/{refNo}")
    public String getPaymentStatus(@PathVariable Integer customerId,@PathVariable Long refNo)
    {
        Transaction tr=tRepo.findById(refNo).orElse(null);
        if(tr!=null)
        return tr.toString();
        else{
            return "Invalid CustomerId or Transaction reference number";
        }
    }

    @RequestMapping("/doLocalPayment")
    public LocalPaymentResponse doLocalPayment(@RequestBody LocalPaymentRequest request){

        String paymentStatus="";
        Long trNo=null;
        Corebanking c=repo.findById(request.customerId).orElse(null);
        Corebanking c1=repo.findByAcno(request.targetAccNumber);
        if( request.amount>c.getBalance())
        {
            paymentStatus="Failed due to insufficient funds";
        }
        else{
            c.setBalance(c.getBalance()-request.amount);
            if(c1!=null)
            c1.setBalance(c1.getBalance()+request.amount);
            paymentStatus="Local payment of "+request.amount+" is successfull";

        }
        Transaction t=new Transaction();
        t.setToAccNumber(request.targetAccNumber);
        t.setFromAccNumber(request.sourceAccNumber);
        t.setPaymentStatus(paymentStatus);
        t.setCustomerId(request.customerId);
        Transaction trans=tRepo.save(t);
        trNo=trans.getTransactionId();
        repo.save(c);
        LocalPaymentResponse response=new LocalPaymentResponse(request.customerId,paymentStatus,trNo,request.timestamp);
        return response;

    }

    @RequestMapping("/crossPayment")
    public CrossPaymentResponse doCrossPayment(@RequestBody UPDCrossPayment request){

        String paymentStatus="";
        Long trNo=null;
        Corebanking c=repo.findById(request.customerId).orElse(null);

        Double amount=request.amount*request.rates;
        if(amount>c.getBalance())
        {
            paymentStatus="Failed due to insufficient funds";
        }
        else{

            c.setBalance(c.getBalance()-amount);
            paymentStatus="Transfer of amount "+amount+" " +request.baseCurrency+" was successFull";

        }
        Transaction t=new Transaction(null,request.customerId,paymentStatus,request.sourceAccNumber,request.targetAccNumber,null);

        Transaction trans=tRepo.save(t);
        trNo=trans.getTransactionId();
        repo.save(c);
        CrossPaymentResponse response=new CrossPaymentResponse(request.customerId,paymentStatus,trNo,request.timestamp);
        return response;

    }

    @RequestMapping("/creditCardPayment")
    public CrossPaymentResponse doCreditCardPayment(@RequestBody UPDCrossPayment request){

        String paymentStatus="";
        Long trNo=null;
        Corebanking c=repo.findById(request.customerId).orElse(null);


            if(request.targetCurrency==null)
            {
                if(request.amount>c.getCreditBalance())
                {
                    paymentStatus="Failed due to insufficient funds";
                }
                else {
                    c.setCreditBalance(c.getCreditBalance() - request.amount);
                    paymentStatus = "Local payment of " + request.amount + " is successfull";
                }
            }

            else {
                Double amount = request.amount * request.rates;
                if (amount > c.getCreditBalance()) {
                    paymentStatus = "Failed due to insufficient funds";
                } else {
                    c.setCreditBalance(c.getCreditBalance() - amount);

                    paymentStatus = "Transfer of amount " + amount + " " + request.baseCurrency + " was successFull";

                }
            }

        Transaction t=new Transaction();
        t.setToAccNumber(request.targetAccNumber);
        t.setFromAccNumber(request.sourceAccNumber);
        t.setPaymentStatus(paymentStatus);
        t.setCustomerId(request.customerId);
        Transaction trans=tRepo.save(t);
        trNo=trans.getTransactionId();
        repo.save(c);
        CrossPaymentResponse response=new CrossPaymentResponse(request.customerId,paymentStatus,trNo,request.timestamp);
        return response;

    }

}
