package com.springcoreapp.beanwithcomponentscan;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao implements DaoContract {

	@Override
	public String getData() {
		return "data from dao";
	}

}
