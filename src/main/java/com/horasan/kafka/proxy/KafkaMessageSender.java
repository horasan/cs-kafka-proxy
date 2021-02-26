package com.horasan.kafka.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import org.springframework.stereotype.Component;

import com.horasan.entity.ServerStatus;


@Component
public class KafkaMessageSender {
	
	private final Logger LOG = LoggerFactory.getLogger(KafkaMessageSender.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private KafkaTemplate<String, ServerStatus> serverStatusKafkaTemplate;

/*
	@Autowired
	KafkaMessageSender(KafkaTemplate<String, String> kafkaTemplate, RoutingKafkaTemplate routingKafkaTemplate,
			KafkaTemplate<String, User> userKafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
*/
	
	@Autowired
	KafkaMessageSender(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, ServerStatus> serverStatusKafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
		this.serverStatusKafkaTemplate = serverStatusKafkaTemplate;
	}
	
	public void sendMessage(String message, String topicName) {
		LOG.info("Sending : {}", message);
		LOG.info("--------------------------------");

		kafkaTemplate.send(topicName, message);
	}
	
	public void sendCustomMessage(ServerStatus status, String topicName) {
		LOG.info("Sending Json Serializer : {}", status);
		LOG.info("--------------------------------");

		serverStatusKafkaTemplate.send(topicName, status);
	}
}
