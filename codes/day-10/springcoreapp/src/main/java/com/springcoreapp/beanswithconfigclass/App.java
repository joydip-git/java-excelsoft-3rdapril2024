package com.springcoreapp.beanswithconfigclass;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {		
		try {
			ApplicationContext iocContainerObj = new AnnotationConfigApplicationContext(BeanConfig.class, AnotherConfig.class);			
			BoContract bo = (BoContract) iocContainerObj.getBean(ProductBo.class);
			System.out.println(bo.fetchData());
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
