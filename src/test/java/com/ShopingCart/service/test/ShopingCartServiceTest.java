package com.ShopingCart.service.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ShopingCart.entity.Item;
import com.ShopingCart.repository.ShopingCartRepository;
import com.ShopingCart.service.ShopingCartService;
import com.ShopingCart.service.ShopingCartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = ShopingCartService.class)
public class ShopingCartServiceTest {

	@InjectMocks
	public ShopingCartServiceImpl shopingcartserviceimpl;

	@MockBean
	public ShopingCartRepository shopingcartrepository;

	List<Item> items;

	@Before
	public void setUp() throws Exception {

		items = new ArrayList<Item>();
		Item item = new Item();
		item.setId(1);
		item.setName("Phone");
		item.setBrand("Apple");
		item.setColor("black");
		item.setPrice(45000L);

		Item item1 = new Item();
		item1.setId(1);
		item1.setName("Phone");
		item1.setBrand("Samsung");
		item1.setColor("black");
		item1.setPrice(35000L);
	}

	/*@Test
	public void getProducts() {
		when(shopingcartrepository.getProducts()).thenReturn(items);
		List<Item> actualitems = new ArrayList<>();
		actualitems = shopingcartserviceimpl.getProducts();
		assertEquals("Samsung", actualitems.get(1).getBrand());
		assertEquals("Apple", actualitems.get(0).getBrand());
	}*/

	
	@Test
	public void testA() {
		System.out.println("Hello");
	}
}
