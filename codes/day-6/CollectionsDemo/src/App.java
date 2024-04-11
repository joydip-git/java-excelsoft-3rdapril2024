import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class App {

	static void useList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(1);

		list.sort(null);

		List<Book> books = new ArrayList<Book>();
		books.add(new Book("the alchemist", "paul cohelo", 399));
		books.add(new Book("pillars of the earth", "ken follet", 799));
		books.add(new Book("sea of poppies", "amitabh ghosh", 599));

		// books.remove(0);
//		Book bookToRemove  = books.get(0);
//		books.remove(bookToRemove);

		System.out.println("No of books: " + books.size());

		// 1. using sort() method of List interface
		// ------------------------------------------------
		// a. implementing "int compareTo(Book o)" method in Book
		// by implementing the Comparable interface

		// books.sort(null);

		// b. create separate class and implement Comparator<Book>
		// interface and its method "int compare(Book o1,Book o2)"

		// BookComparison bc = new BookComparison();
		// books.sort(bc);

		// 2. using sort() method of utility class Collections
		// ------------------------------------------------------
		// a. make sure you have implemented Comparable interface
		// in Book class for the following code to work

		// Collections.sort(books);

		// b. make sure you have a separate class (BookComparison)
		// and implemented Comparator interface for the following
		// code to work
		BookComparison bc = new BookComparison();
		Collections.sort(books, bc);

		//using foreach loop (which uses iterator behind the scene)
//		for (Book book : books) {
//			System.out.println(
//					book.getTitle()
//					+" "
//					+book.getAuthorName()
//					+" "
//					+book.getPrice()
//					);
//		}

		//using for loop
//		for (int i = 0; i < books.size(); i++) {
//			Book b = books.get(i);
//			System.out.println(b);
//		}
		
		//using iterator
		//Iterable<E> interface contains the following method
		//Iterator<E> iterator();
		//this method is implemented in the ArrayList<E> class
		
		//Iterator<E> interface contains methods like...
		//boolean hasNext() => cursor
		//E next(); => returns the current item in the iterator
		Iterator<Book> bookIterator = books.iterator();
		while(bookIterator.hasNext()) {
			Book b = bookIterator.next();
			System.out.println(b);
		}
	}
	public static void main(String[] args) {
		/*
		//useList();
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(12);
		numbers.add(1);
		numbers.add(12);
		
		//for(int i=0;i<numbers.size();i++) {
			//numbers.get(i) <= Set does not have get() method
			//like List
		//}
		
		for (Integer item : numbers) {
			System.out.println(item);
		}
		*/
		Set<Person> people = new HashSet<Person>();
		Person first = new Person("anil");
		Person second = new Person("anil");
		Person third = new Person("joydip");
		people.add(first);
		people.add(second);
		people.add(third);
		
		for (Person person : people) {
			System.out.println(person.getName());
		}
	}

}
