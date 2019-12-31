package com.ShopingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ShopingCart.service.ShopingCartServiceImpl;

@Controller
public class ShopingCartController {

	@Autowired
	public ShopingCartServiceImpl shopingCartServiceImpl;

	@GetMapping(path = "/getProducts")
	public String getProducts(Model model) {
		model.addAttribute("items", shopingCartServiceImpl.getProducts());
		return "products";
	}

	@GetMapping(path = "/getOrderedProducts")
	public String getOrderedProducts(Model model) {
		model.addAttribute("items", shopingCartServiceImpl.getOrderedProducts());
		return "ordered";
	}

	@GetMapping(path = "/getCartProducts")
	public String getCartProducts(Model model) {
		model.addAttribute("items", shopingCartServiceImpl.getCartProducts());
		return "cart";
	}
}
