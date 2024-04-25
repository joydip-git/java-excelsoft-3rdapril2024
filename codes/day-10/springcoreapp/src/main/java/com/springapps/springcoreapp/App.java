package com.springapps.springcoreapp;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		try {
			ApplicationContext iocContainer = new ClassPathXmlApplicationContext("com/springapps/springcoreapp/beans-config.xml");
			Student student = (Student) iocContainer.getBean("sunilStdBean");
			System.out.println(student.getName() + " " + student.getId() + " " + student.getAddress().getCity());

			Student nextStudent = (Student) iocContainer.getBean("anilStdBean");
			System.out.println(nextStudent.getName() + " " + nextStudent.getId() + nextStudent.getAddress().getCity());

			StudentList studentList = (StudentList) iocContainer.getBean("stdList");
			List<Student> list = studentList.getStudents();
			for (Student s : list) {
				System.out.println(s.getName());
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}
}
