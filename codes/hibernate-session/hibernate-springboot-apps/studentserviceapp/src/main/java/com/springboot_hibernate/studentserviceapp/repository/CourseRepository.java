package com.springboot_hibernate.studentserviceapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot_hibernate.studentserviceapp.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
