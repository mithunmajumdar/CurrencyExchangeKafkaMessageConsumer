package com.javatpoint.microservices.currencyexchangeskafkaconsumer.service.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.microservices.currencyexchangeskafkaconsumer.service.impl.CurrencyExchangeKafkaMessageConsumerImpl;

@RestController
public class CurrencyExchangeKafkaMessageConsumerControllers {

	//private Logger logger=LoggerFactory.getLogger(this.getClass());
	//********Default call***********//
	
	@GetMapping("/currencyexchangemessageconsumer") //where {from} and {to} represents the column   
	//return a bean back  
	public void callCreditMessageConsumerImpl()  
	{  
		CurrencyExchangeKafkaMessageConsumerImpl creditMessageConsumer = new CurrencyExchangeKafkaMessageConsumerImpl();
		//creditMessageConsumer.callCreditMessageConsumerImpl();
		creditMessageConsumer.callCreditMessageConsumer();
	}
	
}
