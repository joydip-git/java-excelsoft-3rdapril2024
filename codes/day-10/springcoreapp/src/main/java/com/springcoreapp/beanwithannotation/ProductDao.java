package com.springcoreapp.beanwithannotation;

public class ProductDao implements DaoContract {

	@Override
	public String getData() {
		return "data from dao";
	}

}
