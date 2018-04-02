package com.pizza.api;

import java.io.*;
import java.util.List;

import com.pizza.controller.ShopController;
import com.pizza.entity.Order;

public class Application {
	public static void main(String[] args) {
		/*
		 * SpringApplication.run(Application.class, args);
		 */

		System.out.println("---$tart Pizza-$hop @pplication!----");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ShopController controller = new ShopController();

		String read_path;
		try {
			
			System.out.println("Enter Path of src file -->");
	
			read_path = br.readLine();
			// Read File
			List<String> original_order = controller.readFile(read_path);
			// displayOriginalOrder(original_order);

			// Convert time to appropriate format
			List<Order> list_order = controller.createOrderList(original_order);
			// displayListOrder(list_order);

			// Sort Orders according to time
			List<Order> sorted_order = controller.sortOrderList(list_order);
			// displayListOrder(list_order);

			// Change the date from Epoch time to user understandable form
			List<Order> write_order = controller.changeTime(sorted_order);

			System.out.println("Enter Path for destination file -->");
			// Write file
			String destination_path = br.readLine();;
			controller.writeFile(destination_path, write_order);

			System.out.println("---DONE----");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void displayListOrder(List<Order> list_order) {
		for (Order order : list_order) {
			System.out.println("-> " + order.toString());
		}
	}

	public static void displayOriginalOrder(List<String> original_order) {
		for (String order : original_order) {
			System.out.println("-> " + order);
		}
	}

}
