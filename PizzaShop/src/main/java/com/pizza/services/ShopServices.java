package com.pizza.services;

import java.io.IOException;
import java.util.List;

import com.pizza.entity.Order;

public interface ShopServices {

	public List<String> readFile(String read_path) throws IOException;

	public List<Order> createOrderList(List<String> original_order);

	public List<Order> sortOrderList(List<Order> recreated_order);

	public void writeFile(String destination_path, List<Order> sorted_order);

	public List<Order> changeTime(List<Order> order);

}
