package com.pizza.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.entity.Order;
import com.pizza.services.ShopServices;
import com.pizza.services.impl.ShopServicesImpl;

@RestController
public class ShopController {

	@RequestMapping(method = RequestMethod.POST, value = "/order", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String create(@RequestBody Map<String, String> path) {
		System.out.println("POST Request :: /order");

		ShopServices service = new ShopServicesImpl();

		String read_path;
		try {

			read_path = path.get("read_path");
			// Read File
			List<String> original_order = service.readFile(read_path);
			// displayOriginalOrder(original_order);

			// Convert time to appropriate format
			List<Order> list_order = service.createOrderList(original_order);
			// displayListOrder(list_order);

			// Sort Orders according to time
			List<Order> sorted_order = service.sortOrderList(list_order);
			// displayListOrder(list_order);

			// Change the date from Epoch time to user understandable form
			List<Order> write_order = service.changeTime(sorted_order);

			// Write file
			String destination_path = path.get("destination_path");
			service.writeFile(destination_path, write_order);

			System.out.println("---DONE----");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Completed";
	}

}
