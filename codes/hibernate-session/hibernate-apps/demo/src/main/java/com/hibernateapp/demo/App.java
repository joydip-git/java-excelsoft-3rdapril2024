package com.hibernateapp.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("app started...");

		//Author anilAuthor = new Author();
		//anilAuthor.setId(1);
		//anilAuthor.setName("sunil");
		//anilAuthor.setBooksPublished(6);
		
//		Book book = new Book();
//		book.setName("Java Beginners");
//		book.setAuthor(anilAuthor);
		
		Book book1 = new Book();
		book1.setName("Java Beginners");
		Book book2 = new Book();
		book2.setName("Hibernate Beginners");
		
		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		
		Author anilAuthor = new Author();
		anilAuthor.setName("anil");
		anilAuthor.setBooksPublished(books);

		// this configuration object will read the configuration from hibernate.cfg.xml
		// file by looking for a file by the same name
		Configuration config = new Configuration();

		// path => src/main/java/hibernate.cfg.xml 
		//config.configure("hibernate.cfg.xml");
		config.configure();
		
		SessionFactory factory = config.buildSessionFactory();
		// get any current session object if there is already a session object present
		// factory.getCurrentSession();

		// open a fresh session
		Session session = factory.openSession();

		// all CRUD operations
		// for non-select (insert, update and delete) operations create a transaction
		Transaction transaction = session.beginTransaction();
		// perform a DDL operation - INSERT
		
		session.persist(book1);
		session.persist(book2);
		session.persist(anilAuthor);
		
		//DELETE
		//session.remove(anilAuthor);
		transaction.commit();

		// select an author operation (select * from authors where id=1)
		Author author = session.get(Author.class, 1);
		System.out.println(author != null ? author : "Author NA");
		
		Book savedBook = session.get(Book.class, 1);
		System.out.println(savedBook != null ? savedBook : "Book NA");

//		if(savedBook!=null)
//			System.out.println(savedBook.getAuthor());
//		else
//			System.out.println("Author NA");
		
		session.close();
		factory.close();
	}
}
