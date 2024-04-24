package com.springapps.springcoreapp;

import java.util.ArrayList;

public class StudentList {
	private ArrayList<Student> students;

	public StudentList() {
	}

	public StudentList(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
}
