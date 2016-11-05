package com.bqz.entity;

import java.util.List;

public class Product {

	private int id;
	private String name;
	private long price;
	private List<Spec> spec;

	public List<Spec> getSpec() {
		return spec;
	}

	public void setSpec(List<Spec> spec) {
		this.spec = spec;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
