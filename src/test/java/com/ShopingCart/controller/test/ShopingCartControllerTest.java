package com.ShopingCart.controller.test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ShopingCart.controller.ShopingCartController;
import com.ShopingCart.entity.Item;
import com.ShopingCart.service.ShopingCartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = ShopingCartController.class)
public class ShopingCartControllerTest {

	@Autowired
	private MockMvc mockmvc;

	@InjectMocks
	public ShopingCartController shopingcartcontroller;

	@MockBean
	public ShopingCartServiceImpl shopingCartServiceImpl;

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
		items.add(item);
		items.add(item1);
	}

	@Test
	public void getProductsTest() throws Exception {

		when(shopingCartServiceImpl.getProducts()).thenReturn(items);

		mockmvc.perform(get("/getProducts")).andExpect(view().name("products"))
				.andExpect(forwardedUrl("/WEB-INF/views/products.jsp"))
				.andExpect(model().attribute("items",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("name", is("Phone")),
								hasProperty("brand", is("Apple"))))))

				.andExpect(model().attribute("items", hasItem(allOf(hasProperty("id", is(1)),
						hasProperty("name", is("Phone")), hasProperty("brand", is("Samsung"))))));

		verify(shopingCartServiceImpl, times(1)).getProducts();

	}

	@Test
	public void getOrderedProductsTest() throws Exception {

		when(shopingCartServiceImpl.getOrderedProducts()).thenReturn(items);

		mockmvc.perform(get("/getOrderedProducts")).andExpect(view().name("ordered"))
				.andExpect(forwardedUrl("/WEB-INF/views/ordered.jsp"))
				.andExpect(model().attribute("items",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("name", is("Phone")),
								hasProperty("brand", is("Apple"))))))

				.andExpect(model().attribute("items", hasItem(allOf(hasProperty("id", is(1)),
						hasProperty("name", is("Phone")), hasProperty("brand", is("Samsung"))))));

		verify(shopingCartServiceImpl, times(1)).getOrderedProducts();

	}

	@Test
	public void getCartProductsTest() throws Exception {

		when(shopingCartServiceImpl.getCartProducts()).thenReturn(items);

		mockmvc.perform(get("/getCartProducts")).andExpect(view().name("cart"))
				.andExpect(forwardedUrl("/WEB-INF/views/cart.jsp"))
				.andExpect(model().attribute("items",
						hasItem(allOf(hasProperty("id", is(1)), hasProperty("name", is("Phone")),
								hasProperty("brand", is("Apple"))))))

				.andExpect(model().attribute("items", hasItem(allOf(hasProperty("id", is(1)),
						hasProperty("name", is("Phone")), hasProperty("brand", is("Samsung"))))));

		verify(shopingCartServiceImpl, times(1)).getCartProducts();

	}
}
