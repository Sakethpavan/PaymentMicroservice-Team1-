package com.example.forex_component.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.forex_component.model.ExchangeRates;


@FeignClient(name="EuropeanExchangeRates",url="https://api.exchangeratesapi.io/")
public interface FeignService {
	
	@GetMapping("/latest?base={base}")
	public ExchangeRates getExchanges(@PathVariable("base") String base);
}
