package com.example.payment_component.dao;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="forex")
@RibbonClient(name="forex")
public interface FeignServiceForex {
    @GetMapping("/forex/{baseCurrency}/{targetCurrency}")
    public Double getForexRates(@PathVariable("baseCurrency") String baseCurrency, @PathVariable("targetCurrency") String targetCurrency);
}
