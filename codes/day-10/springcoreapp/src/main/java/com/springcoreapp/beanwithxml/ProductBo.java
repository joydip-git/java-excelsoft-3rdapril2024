package com.springcoreapp.beanwithxml;

public class ProductBo implements BoContract {

	private DaoContract dao;

	public ProductBo(DaoContract _dao) {
		dao = _dao;
	}

	public void setDao(DaoContract _dao) {
		dao = _dao;
	}

	@Override
	public String fetchData() {
		return dao.getData();
	}

}
