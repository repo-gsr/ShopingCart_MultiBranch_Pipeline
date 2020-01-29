package com.ShopingCart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ShopingCart.ShopingCartApplication;
import com.ShopingCart.jwt.CookieUtil;
import com.ShopingCart.service.ShopingCartServiceImpl;

@Controller
public class ShopingCartController {
	private Logger logger = Logger.getLogger(ShopingCartApplication.class);

	@Autowired
	public ShopingCartServiceImpl shopingCartServiceImpl;

	@GetMapping(path = "/getProducts")
	public String getProducts(Model model) {
		logger.info("getProducts");
		model.addAttribute("items", shopingCartServiceImpl.getProducts());
		return "products";
	}

	@GetMapping(path = "/getOrderedProducts")
	public String getOrderedProducts(Model model) {
		logger.info("getOrderedProducts");
		model.addAttribute("items", shopingCartServiceImpl.getOrderedProducts());
		return "ordered";
	}

	@GetMapping(path = "/getCartProducts")
	public String getCartProducts(Model model) {
		logger.info("getCartProducts");
		model.addAttribute("items", shopingCartServiceImpl.getCartProducts());
		return "cart";
	}
}
