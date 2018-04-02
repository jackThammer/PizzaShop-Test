package com.pizza.controller;

import java.io.IOException;
import java.util.List;

import com.pizza.entity.Order;
import com.pizza.services.ShopServices;
import com.pizza.services.impl.ShopServicesImpl;

public class ShopController {
	ShopServices service;

	public ShopController() {
		this.service = new ShopServicesImpl();
	}

	public List<String> readFile(String read_path) throws IOException {
		return service.readFile(read_path);
	}

	public List<Order> createOrderList(List<String> original_order) {
		return service.createOrderList(original_order);
	}

	public List<Order> sortOrderList(List<Order> recreated_order) {

		return service.sortOrderList(recreated_order);
	}

	public List<Order> changeTime(List<Order> order) {
		return service.changeTime(order);
	}

	public void writeFile(String destination_path, List<Order> sorted_order) {
		service.writeFile(destination_path, sorted_order);
	}

}
