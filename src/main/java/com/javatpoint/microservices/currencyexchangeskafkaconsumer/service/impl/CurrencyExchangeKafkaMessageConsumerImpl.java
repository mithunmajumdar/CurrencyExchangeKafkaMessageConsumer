package com.javatpoint.microservices.currencyexchangeskafkaconsumer.service.impl;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javatpoint.microservices.currencyexchangeskafkaconsumer.service.in.CurrencyExchangeKafkaMessageConsumerInterface;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class CurrencyExchangeKafkaMessageConsumerImpl implements CurrencyExchangeKafkaMessageConsumerInterface{

    String bootstrapServers="127.0.0.1:9092";
    String grp_id="currency-exchange-message-app";
    String topic="currency-exchange-message";

	public void callCreditMessageConsumerImpl(){
		
        Logger logger= LoggerFactory.getLogger(CurrencyExchangeKafkaMessageConsumerImpl.class.getName());
        System.out.println("CurrencyExchangeKafkaMessageConsumerImpl...");
        //Creating consumer properties
        Properties properties=new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        //creating consumer
        KafkaConsumer<String,String> consumer= new KafkaConsumer<>(properties);
        //Subscribing
        consumer.subscribe(Arrays.asList(topic));
        //polling
        while(true){
            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String,String> record: records){
                logger.info("Key: "+ record.key() + ", Value:" +record.value());
                logger.info("Partition:" + record.partition()+",Offset:"+record.offset());
            }
            
           // consumer.close();
        }
        
    }

	@Override
	public void callCreditMessageConsumer() {
        Logger logger= LoggerFactory.getLogger(CurrencyExchangeKafkaMessageConsumerImpl.class.getName());
        System.out.println("CurrencyExchangeKafkaMessageConsumer...");
		/*
		 * String bootstrapServers="127.0.0.1:9092"; String grp_id="credit_message_app";
		 * String topic="credit-message-new1";
		 */
        //Creating consumer properties
        Properties properties=new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        //creating consumer
        KafkaConsumer<String,String> consumer= new KafkaConsumer<>(properties);
        //Subscribing
        consumer.subscribe(Arrays.asList(topic));
        //polling
        while(true){
            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String,String> record: records){
                logger.info("Key: "+ record.key() + ", Value:" +record.value());
                logger.info("Partition:" + record.partition()+",Offset:"+record.offset());
            }
            
           // consumer.close();
        }
		
	}
}