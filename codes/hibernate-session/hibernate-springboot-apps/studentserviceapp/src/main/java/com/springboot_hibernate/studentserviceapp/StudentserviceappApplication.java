package com.springboot_hibernate.studentserviceapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot_hibernate.studentserviceapp.entities.Course;
import com.springboot_hibernate.studentserviceapp.entities.Student;
import com.springboot_hibernate.studentserviceapp.repository.CourseRepository;
import com.springboot_hibernate.studentserviceapp.repository.StudentRepository;

@SpringBootApplication
public class StudentserviceappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StudentserviceappApplication.class, args);
		StudentRepository studentRepo = context.getBean(StudentRepository.class);
		
		CourseRepository courseRepo = context.getBean(CourseRepository.class);

		Student student1 = new Student();
		student1.setName("anil");
		Student student2 = new Student();
		student2.setName("sunil");

		Course course1 = new Course();
		course1.setName("Java");
		Course course2 = new Course();
		course2.setName("React JS");

		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);

		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);

		student1.setCourses(courses);
		student2.setCourses(courses);

		course1.setStudents(students);
		course2.setStudents(students);

		Iterable<Course> savedCourses = courseRepo.saveAll(courses);
		Iterable<Student> savedStudents = studentRepo.saveAll(students);
		
		savedCourses.forEach(c->System.out.println(c));
		savedStudents.forEach(s->System.out.println(s));
	}
}
