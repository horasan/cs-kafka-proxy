package com.horasan.kafka.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.horasan.entity.Customer;
import com.horasan.entity.ServerStatus;



@Component
public class KafkaMessageListener {
	private final Logger LOG = LoggerFactory.getLogger(KafkaMessageListener.class);

	@Autowired
	private RestTemplate restTemplate;
	
	/*
	@KafkaListener(topics = "reflectoring-1")
	void listener(String message) {
		LOG.info("Listener [{}]", message);
	}

	@KafkaListener(topics = { "reflectoring-1", "reflectoring-2" }, groupId = "reflectoring-group-2")
	void commonListenerForMultipleTopics(String message) {
		LOG.info("MultipleTopicListener - [{}]", message);
	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = "reflectoring-3", partitionOffsets = {
			@PartitionOffset(partition = "0", initialOffset = "0") }), groupId = "reflectoring-group-3")
	void listenToParitionWithOffset(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.OFFSET) int offset) {
		LOG.info("ListenToPartitionWithOffset [{}] from partition-{} with offset-{}", message, partition, offset);
	}

	@KafkaListener(topics = "reflectoring-bytes")
	void listenerForRoutingTemplate(String message) {
		LOG.info("RoutingTemplate BytesListener [{}]", message);
	}

	@KafkaListener(topics = "reflectoring-others")
	@SendTo("reflectoring-2")
	String listenAndReply(String message) {
		LOG.info("ListenAndReply [{}]", message);
		return "This is a reply sent to 'reflectoring-2' topic after receiving message at 'reflectoring-others' topic";
	}
*/
	@KafkaListener(topics = "customer-create-requests", groupId = "none", containerFactory = "kafkaJsonListenerContainerFactory")
	void listenerWithMessageConverter(ServerStatus serverStatus) {
		LOG.info("MessageConverterUserListener [{}]", serverStatus);
		//call elasticsearch elasticsearch proxy api
		//this.restTemplate.getForObject("127.0.0.1:9200/_nodes/stats", String.class);
		//ServerStatus ss = new ServerStatus(java.util.UUID.randomUUID().toString(), "160.75.2.20", "1235", "WORKING");
		//ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8102/autocomplete/request", serverStatus, String.class);
		LOG.info("MessageConverterUserListener: Received message: --> [{}]", serverStatus.toString());
		
		Customer c = new Customer(1001, "riza", "horasan", 19810917);
		ResponseEntity<Customer> result = restTemplate.postForEntity("http://localhost:8080/customer/v1/", c, Customer.class);
		
		int a = 0;
		
		
	}
}
