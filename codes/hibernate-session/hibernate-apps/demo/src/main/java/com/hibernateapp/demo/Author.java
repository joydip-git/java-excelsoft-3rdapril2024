package com.hibernateapp.demo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "author_name")
	private String name;

	//@Column(name = "books_published")
	// private int booksPublished;
	
	@OneToMany
	private List<Book> booksPublished;

	public Author() {
		super();
	}

	//public Author(int id, String name, int booksPublished) {
	public Author(int id, String name, List<Book> booksPublished) {
		super();
		this.id = id;
		this.name = name;
		this.booksPublished = booksPublished;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public int getBooksPublished() {
//		return booksPublished;
//	}
//
//	public void setBooksPublished(int booksPublished) {
//		this.booksPublished = booksPublished;
//	}
	public List<Book> getBooksPublished() {
		return booksPublished;
	}

	public void setBooksPublished(List<Book> booksPublished) {
		this.booksPublished = booksPublished;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}
}
