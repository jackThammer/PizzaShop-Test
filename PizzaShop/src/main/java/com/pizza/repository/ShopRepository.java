package com.pizza.repository;

import java.io.IOException;
import java.util.List;

import com.pizza.entity.Order;

public interface ShopRepository {

	public List<String> readTextFile(String read_path) throws IOException;

	public void writeTextFile(String destination_path, List<Order> sorted_order);
}
