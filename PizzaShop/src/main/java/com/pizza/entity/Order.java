package com.pizza.entity;

import java.util.UUID;


public class Order {
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", time=" + time + "]";
	}
	private String id;
	private String name;
	private String time;
	
	
	public Order() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}