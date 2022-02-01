package com.neosoft.kafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConsumerConfig {
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Value(value = "${topic.group.id}")
	private String groupId;

	@Value(value = "${sms.cousumer1.concurrency}")
	private Integer smsConcurrency1;

	@Value(value = "${sms.cousumer2.concurrency}")
	private Integer smsConcurrency2;

	@Value(value = "${sms.cousumer3.concurrency}")
	private Integer smsConcurrency3;

	@Value(value = "${email.cousumer1.concurrency}")
	private Integer emailConcurrency1;

	@Value(value = "${email.cousumer2.concurrency}")
	private Integer emailConcurrency2;

	@Value(value = "${email.cousumer3.concurrency}")
	private Integer emailConcurrency3;
	
	@Value(value = "${sms.cousumer1.maxpollrecord}")
	private Integer smsMaxPollRecord1;

	@Value(value = "${sms.cousumer2.maxpollrecord}")
	private Integer smsMaxPollRecord2;

	@Value(value = "${sms.cousumer3.maxpollrecord}")
	private Integer smsMaxPollRecord3;

	@Value(value = "${email.cousumer1.maxpollrecord}")
	private Integer emailMaxPollRecord1;

	@Value(value = "${email.cousumer2.maxpollrecord}")
	private Integer emailMaxPollRecord2;

	@Value(value = "${email.cousumer3.maxpollrecord}")
	private Integer emailMaxPollRecord3;

	// 1. Consume string data from Kafka
	@Bean
    public ConsumerFactory<String, String> consumerFactory1() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, smsMaxPollRecord1);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);
    }
	
	@Bean
    public ConsumerFactory<String, String> consumerFactory2() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, smsMaxPollRecord2);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);
    }
	
	@Bean
    public ConsumerFactory<String, String> consumerFactory3() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, smsMaxPollRecord3);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);
    }
	
	@Bean
    public ConsumerFactory<String, String> consumerFactory4() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, emailMaxPollRecord1);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);
    }
	
	@Bean
    public ConsumerFactory<String, String> consumerFactory5() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, emailMaxPollRecord2);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);
    }
	
	@Bean
    public ConsumerFactory<String, String> consumerFactory6() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, emailMaxPollRecord3);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);
    }

	@Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerSmsContainer1Factory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory1());
        factory.setConcurrency(smsConcurrency1);
        return factory;
    }

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerSmsContainer2Factory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory2());
		factory.setConcurrency(smsConcurrency2);
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerSmsContainer3Factory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory3());
		factory.setConcurrency(smsConcurrency3);
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerEmailContainer1Factory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory4());
		factory.setConcurrency(emailConcurrency1);
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerEmailContainer2Factory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory5());
		factory.setConcurrency(emailConcurrency2);
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerEmailContainer3Factory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory6());
		factory.setConcurrency(emailConcurrency3);
		return factory;
	}
}