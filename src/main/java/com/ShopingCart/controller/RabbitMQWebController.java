package com.ShopingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ShopingCart.entity.Item;
import com.ShopingCart.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("name") String name, @RequestParam("brand") String brand) {

		Item item = new Item();
		item.setName(name);
		item.setBrand(brand);
		rabbitMQSender.send(item);

		return "Message sent to the RabbitMQ Successfully";
	}

}