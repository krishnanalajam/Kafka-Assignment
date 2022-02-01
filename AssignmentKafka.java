package com.neosoft.kafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
 
@Configuration
public class AssignmentKafka
{
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
 
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
 	
 	//SMS Topic's
    @Bean
    public NewTopic smsTopic1() {
        return TopicBuilder.name(smsTopicName1).partitions(1).replicas(1).build();
    }
    @Bean
    public NewTopic smsTopic2() {
        return TopicBuilder.name(smsTopicName2).partitions(1).replicas(1).build();
    }
    @Bean
    public NewTopic smsTopic3() {
        return TopicBuilder.name(smsTopicName3).partitions(1).replicas(1).build();
    }
    @Bean
    public NewTopic smsTopic4() {
        return TopicBuilder.name(smsTopicName4).partitions(1).replicas(1).build();
    }
    @Bean
    public NewTopic smsTopic5() {
        return TopicBuilder.name(smsTopicName5).partitions(1).replicas(1).build();
    }
    
    //Email Topic's
    @Bean
    public NewTopic emailTopic1() {
        return TopicBuilder.name(emailTopicName1).partitions(1).replicas(1).build();
    }
    @Bean
    public NewTopic emailTopic2() {
        return TopicBuilder.name(emailTopicName2).partitions(1).replicas(1).build();
    }
    @Bean
    public NewTopic emailTopic3() {
        return TopicBuilder.name(emailTopicName3).partitions(1).replicas(1).build();
    }
    @Bean
    public NewTopic emailTopic4() {
        return TopicBuilder.name(emailTopicName4).partitions(1).replicas(1).build();
    }
    @Bean
    public NewTopic emailTopic5() {
        return TopicBuilder.name(emailTopicName5).partitions(1).replicas(1).build();
    }
}