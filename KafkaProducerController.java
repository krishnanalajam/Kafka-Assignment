package com.neosoft.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.kafkapoc.service.KafKaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

	private final KafKaProducerService producerService;

	// 1. Sms topic's with a string payload
	@Value(value = "${sms.topic1.name}")
	private String smsTopicName1;

	@Value(value = "${sms.topic2.name}")
	private String smsTopicName2;
	
	@Value(value = "${sms.topic3.name}")
	private String smsTopicName3;
	
	@Value(value = "${sms.topic4.name}")
	private String smsTopicName4;

	@Value(value = "${sms.topic5.name}")
	private String smsTopicName5;

	// 2. Email topic's with a string payload
	@Value(value = "${email.topic1.name}")
	private String emailTopicName1;

	@Value(value = "${email.topic2.name}")
	private String emailTopicName2;

	@Value(value = "${email.topic3.name}")
	private String emailTopicName3;

	@Value(value = "${email.topic4.name}")
	private String emailTopicName4;

	@Value(value = "${email.topic5.name}")
	private String emailTopicName5;

	@Autowired
	public KafkaProducerController(KafKaProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("topicType") String topicType,
			@RequestParam("message") String message) {
		if (topicType.equalsIgnoreCase(smsTopicName1)) {
			this.producerService.sendMessage(smsTopicName1, message);
		} else if (topicType.equalsIgnoreCase(smsTopicName2)) {
			this.producerService.sendMessage(smsTopicName2, message);
		} else if (topicType.equalsIgnoreCase(smsTopicName3)) {
			this.producerService.sendMessage(smsTopicName3, message);
		} else if (topicType.equalsIgnoreCase(smsTopicName4)) {
			this.producerService.sendMessage(smsTopicName4, message);
		} else if (topicType.equalsIgnoreCase(smsTopicName5)) {
			this.producerService.sendMessage(smsTopicName5, message);
		}else if (topicType.equalsIgnoreCase(emailTopicName1)) {
			this.producerService.sendMessage(emailTopicName1, message);
		} else if (topicType.equalsIgnoreCase(emailTopicName2)) {
			this.producerService.sendMessage(emailTopicName2, message);
		} else if (topicType.equalsIgnoreCase(emailTopicName3)) {
			this.producerService.sendMessage(emailTopicName3, message);
		} else if (topicType.equalsIgnoreCase(emailTopicName4)) {
			this.producerService.sendMessage(emailTopicName4, message);
		} else if (topicType.equalsIgnoreCase(emailTopicName5)) {
			this.producerService.sendMessage(emailTopicName5, message);
		}
	}
}