package com.neosoft.kafkapoc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

 
@Service
public class KafKaConsumerService 
{
    private final Logger logger = LoggerFactory.getLogger(KafKaConsumerService.class);
     
    @KafkaListener(topics = "${sms.cousumer1.topics}", groupId = "${topic.group.id}", containerFactory = "kafkaListenerSmsContainer1Factory")
    public void consume1(String message) {
        logger.info(String.format("consume1 Message recieved -> %s", message));
    }
 
    @KafkaListener(topics = "${sms.cousumer2.topics}", groupId = "${topic.group.id}", containerFactory = "kafkaListenerSmsContainer2Factory")
    public void consume2(String message) {
    	logger.info(String.format("consume2 Message recieved -> %s", message));
    }
    
    @KafkaListener(topics = "${sms.cousumer3.topics}", groupId = "${topic.group.id}", containerFactory = "kafkaListenerSmsContainer3Factory")
    public void consume3(String message) {
        logger.info(String.format("consume3 Message recieved -> %s", message));
    }
 
    @KafkaListener(topics = "${email.cousumer1.topics}", groupId = "${topic.group.id}", containerFactory = "kafkaListenerEmailContainer1Factory")
    public void consume4(String message) {
    	logger.info(String.format("consume4 Message recieved -> %s", message));
    }
    
    @KafkaListener(topics = "${email.cousumer2.topics}", groupId = "${topic.group.id}", containerFactory = "kafkaListenerEmailContainer2Factory")
    public void consume5(String message) {
        logger.info(String.format("consume5 Message recieved -> %s", message));
    }
 
    @KafkaListener(topics = "${email.cousumer3.topics}", groupId = "${topic.group.id}", containerFactory = "kafkaListenerEmailContainer3Factory")
    public void consume6(String message) {
    	logger.info(String.format("consume6 Message recieved -> %s", message));
    }
}