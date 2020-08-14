package com.example.forex_component;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forex_component.model.*;
import com.example.forex_component.service.*;



@RestController
@RequestMapping("/forex")
public class ForexController {
	
	@Autowired
	ConversionsRepository repository;
	@Autowired
	FeignService feign;
	
	@Scheduled(cron="*/30 * * * * 0-6")
	public void getCurrencies()
	{

		
		ExchangeRates res;
		String[] arr={"INR","BRL","RUB","JPY","THB","CHF","CNY","NOK","NZD","ZAR","USD","MXN","ILS","GBP","KRW","MYR"};
		for(String base: arr)
		{
			
			res=feign.getExchanges(base);
		    res.getRates().getAll().forEach((k,v) ->{
		    	ConversionsPK p = new ConversionsPK(base,k);
		    	Conversions c=new Conversions(p,v);
		    	repository.save(c);
		    });
	    }
		System.out.println(new Date());
		
	}
	
	@GetMapping("/{from}/{to}")
	public Double getFactor(@PathVariable("from") String from,@PathVariable("to") String to)
	{
		Conversions c =repository.findByConversionPK(new ConversionsPK(from,to));

		return c.getFactor();
	}


}
