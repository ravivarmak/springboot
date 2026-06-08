package com.example.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
	private final KafkaTemplate<String, String> kafkaTemplate;
	public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public String sendOrderEvent(String event) {
		kafkaTemplate.send("orders", event);
		return "Order event sent: " + event;
	}
}
