package com.pizza.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.pizza.entity.Order;
import com.pizza.services.impl.ShopServicesImpl;

import junit.framework.TestCase;

public class ShopServiceTest extends TestCase {
	ShopServices service;

	/*
	 * @Before public void setUp() throws Exception { this.service = new
	 * ShopServicesImpl(); orderList = service.readFile("testinput.txt"); }
	 */
	@Test
	public void testcreateOrderList() {
		service = new ShopServicesImpl();
		List<String> orderList = new ArrayList<>(
				Arrays.asList("TestMeat		1506176687", "TestPizza		1477319087"));
		List<Order> actual_order_list = service.createOrderList(orderList);
		List<String> expectedName = new ArrayList<>(Arrays.asList("TestMeat", "TestPizza"));
		int count = 0;
		for (Order o : actual_order_list) {
			assertEquals(expectedName.get(count), o.getName());
			count++;
		}
	}

	public static Order createOrder(String name, String time) {
		Order order = new Order();
		order.setName(name);
		order.setTime(time);
		return order;
	}

	@Test
	public void testsortOrderList() {
		service = new ShopServicesImpl();
		Order o1 = createOrder("TestMeat", "1506176687");
		Order o2 = createOrder("TestPizza", "1477319087");
		List<Order> order_list = new ArrayList<>(Arrays.asList(o1, o2));

		List<Order> actual_sorted_list = service.sortOrderList(order_list);

		List<String> expectedName = new ArrayList<>(Arrays.asList("TestPizza", "TestMeat"));
		int count = 0;
		for (Order o : actual_sorted_list) {
			assertEquals(expectedName.get(count), o.getName());
			count++;
		}
	}

	@Test
	public void testchangeTime() {
		service = new ShopServicesImpl();
		Order o1 = createOrder("TestMeat", "1506176687");
		Order o2 = createOrder("TestPizza", "1474295087");
		List<Order> sorted_list = new ArrayList<>(Arrays.asList(o1, o2));

		List<Order> actual_changed_list = service.changeTime(sorted_list);

		List<String> expectedName = new ArrayList<>(
				Arrays.asList("Sun, 18 Jan 1970 10:22:56 UTC", "Sun, 18 Jan 1970 01:31:35 UTC"));
		int count = 0;
		for (Order o : actual_changed_list) {
			assertEquals(expectedName.get(count), o.getTime());
			count++;
		}

	}

}
