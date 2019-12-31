package com.ShopingCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShopingCart.entity.Item;
import com.ShopingCart.repository.ShopingCartRepository;

@Service
public class ShopingCartServiceImpl implements ShopingCartService {

	@Autowired
	public ShopingCartRepository shopingcartrepository;

	@Override
	public List<Item> getProducts() {
		return shopingcartrepository.getProducts();
	}

	@Override
	public List<Item> getOrderedProducts() {
		// TODO Auto-generated method stub
		return shopingcartrepository.getOrderedProducts();
	}

	@Override
	public List<Item> getCartProducts() {
		// TODO Auto-generated method stub
		return shopingcartrepository.getCartProducts();
	}

}
