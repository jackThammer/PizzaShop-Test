package com.pizza.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.pizza.repository.impl.ShopRepositoryImpl;
import com.pizza.services.impl.ShopServicesImpl;

class ShopRepositoryTest {
	ShopRepositoryImpl repo;

	@Test
	public void testreadTextFile() {
		repo = new ShopRepositoryImpl();
		try {
			List<String> actual_orderList = repo.readTextFile("C:\\Users\\Joel\\Desktop\\Aquent - Egen\\testInput.txt");

			List<String> orderList = new ArrayList<>(
					Arrays.asList("Order		time", "Meat		1506176687", "pizza		1477578287"));
			assertEquals(orderList, actual_orderList);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
