package com.springcoreapp.beanwithannotation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		//DaoContract dao = new ProductDao();
		//BoContract bo = new ProductBo(dao);
		
		try {
			ApplicationContext iocContainerObj = new ClassPathXmlApplicationContext("com/springcoreapp/beanwithannotation/config.xml");
			//BoContract bo = (BoContract) iocContainerObj.getBean("boBean");
			BoContract bo = (BoContract) iocContainerObj.getBean(ProductBo.class);
			System.out.println(bo.fetchData());
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}