package com.springcoreapp.beanwithxml;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		//DaoContract dao = new ProductDao();
		//BoContract bo = new ProductBo(dao);
		
		try {
			ApplicationContext iocContainerObj = new ClassPathXmlApplicationContext("com/springcoreapp/beanwithxml/config.xml");
			BoContract bo = (BoContract) iocContainerObj.getBean("boBean");
			System.out.println(bo.fetchData());
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
