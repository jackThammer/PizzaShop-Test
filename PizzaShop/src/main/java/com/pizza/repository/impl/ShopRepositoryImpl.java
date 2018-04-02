package com.pizza.repository.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.pizza.entity.Order;
import com.pizza.repository.ShopRepository;

public class ShopRepositoryImpl implements ShopRepository {

	public List<String> readTextFile(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}

		bufferedReader.close();

		return lines;
	}

	@Override
	public void writeTextFile(String destination_path, List<Order> sorted_order) {
		// TODO Auto-generated method stub
		File fout;

		try {

			fout = new File(destination_path + "\\output.txt");
			FileOutputStream fos = new FileOutputStream(fout);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

			//writer = new FileWriter(destination_path + "\\output.txt");
			for (Order order : sorted_order) {
				writer.write(order.getName());
				writer.write(" ordered on ");
				writer.write(order.getTime());
				writer.newLine();

			}

			writer.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

}
