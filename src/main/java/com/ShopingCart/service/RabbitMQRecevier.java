package com.ShopingCart.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.ShopingCart.entity.Item;

@Component
public class RabbitMQRecevier {

	@RabbitListener(queues = "${rabbitmq.queue}")
	public void recievedMessage(Item employee) {
		System.out.println("Recieved Message From RabbitMQ: " + employee);
	}
}