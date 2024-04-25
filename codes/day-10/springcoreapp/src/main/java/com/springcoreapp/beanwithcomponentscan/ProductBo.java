package com.springcoreapp.beanwithcomponentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductBo implements BoContract {

	//@Autowired
	private DaoContract dao;
	
	public ProductBo() {
		System.out.println("default ctor");
	}

	//@Autowired
	public ProductBo(DaoContract _dao) {
		System.out.println("ctor...");
		dao = _dao;
	}

	@Autowired
	public void setDao(DaoContract _dao) {
		System.out.println("setter");
		dao = _dao;
	}

	@Override
	public String fetchData() {
		return dao.getData();
	}

}
