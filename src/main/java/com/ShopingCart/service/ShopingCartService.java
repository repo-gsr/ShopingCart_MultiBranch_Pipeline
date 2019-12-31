package com.ShopingCart.service;

import java.util.List;

import com.ShopingCart.entity.Item;

public interface ShopingCartService {
	public List<Item> getProducts();

	public List<Item> getOrderedProducts();

	public List<Item> getCartProducts();
}
