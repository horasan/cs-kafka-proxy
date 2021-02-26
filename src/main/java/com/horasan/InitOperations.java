package com.horasan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.horasan.entity.ServerStatus;
import com.horasan.kafka.proxy.KafkaMessageSender;

@Component
public class InitOperations {

private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private KafkaMessageSender kafkaSenderExample;
	
	@Value("${io.reflectoring.kafka.topic-1}")
	private String topic1;
	
	@EventListener
	void initiateSendingMessage(ApplicationReadyEvent event) throws InterruptedException {
		/*
		Thread.sleep(5000);
		LOG.info("---------------------------------");
		kafkaSenderExample.sendMessage("R-I'll be recevied by MultipleTopicListener, Listener & ClassLevel KafkaHandler", topic1);
		*/
		
		
		Thread.sleep(5000);
		LOG.info("-------------------------------trying to send to kafka 1");
		kafkaSenderExample.sendCustomMessage(new ServerStatus(java.util.UUID.randomUUID().toString(), "0.0.0.20", "0002", "SHUTTING_DOWN"), topic1);
		LOG.info("-------------------------------sent to kafka 1");
		
		LOG.info("-------------------------------trying to send to kafka 2");
		kafkaSenderExample.sendCustomMessage(new ServerStatus(java.util.UUID.randomUUID().toString(), "0.0.0.21", "0002", "SHUTTING_DOWN"), topic1);
		LOG.info("---------------------------------Sent to kafka 2");
		}
	
}
