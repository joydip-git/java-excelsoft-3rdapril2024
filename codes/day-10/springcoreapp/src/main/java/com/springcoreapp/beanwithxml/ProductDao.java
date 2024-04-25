package com.springcoreapp.beanwithxml;

public class ProductDao implements DaoContract {

	@Override
	public String getData() {
		return "data from dao";
	}

}
