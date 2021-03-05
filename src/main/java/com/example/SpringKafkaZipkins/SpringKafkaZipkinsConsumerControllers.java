package com.example.SpringKafkaZipkins;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.credit.message.CreditMessageConsumer;

@RestController
public class SpringKafkaZipkinsConsumerControllers {

	//private Logger logger=LoggerFactory.getLogger(this.getClass());
	//********Default call***********//
	
	@GetMapping("/creditmessageconsumer") //where {from} and {to} represents the column   
	//return a bean back  
	public void callCreditMessageConsumer()  
	{  
		CreditMessageConsumer creditMessageConsumer = new CreditMessageConsumer();
		creditMessageConsumer.callCreditMessageConsumer();
		
	}
	
}
