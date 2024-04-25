package com.springcoreapp.beanwithannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductBo implements BoContract {

	// @Autowired (dao= new ProductDao())
	private DaoContract dao;

	// @Autowired
	public ProductBo(DaoContract _dao) {
		dao = _dao;
	}

	@Autowired
	public void setDao(DaoContract _dao) {
		dao = _dao;
	}

	/*
	 * public ProductBo(DaoContract _dao) { dao = _dao; }
	 * 
	 * public void setDao(DaoContract _dao) { dao = _dao; }
	 */
	@Override
	public String fetchData() {
		return dao.getData();
	}

}
