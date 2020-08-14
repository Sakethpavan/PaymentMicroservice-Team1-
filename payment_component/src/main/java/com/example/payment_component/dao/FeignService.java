package com.example.payment_component.dao;

import com.example.payment_component.model.*;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="corebanking")
@RibbonClient(name="corebanking")
public interface FeignService {

    @GetMapping("/getPaymentStatus/{id}/{ref}")
    public String getPaymentStatus(@PathVariable("id") Integer id,@PathVariable("ref") Long ref );

    @PostMapping("/doLocalPayment")
    public LocalPaymentResponse localPayment(@RequestBody  LocalPaymentRequest localPaymentRequest);

    @PostMapping("/crossPayment")
    public CrossPaymentResponse crossPayment(@RequestBody UPDCrossPayment updCrossPayment);

    @RequestMapping("/creditCardPayment")
    public CrossPaymentResponse creditCardPayment(@RequestBody UPDCrossPayment updCrossPayment);

}
