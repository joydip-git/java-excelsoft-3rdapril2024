package com.springcoreapp.beanswithconfigclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	@Autowired(required = true)
	public BoContract productBo(DaoContract dao) {
		
		return new ProductBo(dao);
		// use @Autowired with private data member
		//return new ProductBo();

		// use of @Autowired with parameterized constructor will not help you
		// you have manually pass dao object to bo constructor
		// return new ProductBo(productDao());

		// ProductBo bo = new ProductBo();
		// use of @Autowired with setter will not help you
		// you have manually pass dao object to the setter
		// bo.setDao(productDao());
		// return bo;
	}

	@Bean
	public DaoContract productDao() {
		return new ProductDao();
	}
}
