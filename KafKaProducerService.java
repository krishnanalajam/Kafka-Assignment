package com.neosoft.kafkapoc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafKaProducerService {

	private static final Logger logger = LoggerFactory.getLogger(KafKaProducerService.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topicName,String message) {
		ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(topicName, message);
		
		logger.info("topicName : ",topicName);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				logger.info("Sent message: " + message + " with offset: " + result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Unable to send message : " + message, ex);
			}
		});
	}
}