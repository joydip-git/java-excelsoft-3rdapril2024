import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(1);

		list.sort(null);

		List<Book> books = new ArrayList<Book>();
		books.add(new Book("the alchemist", "paul cohelo", 399));
		books.add(new Book("pillars of the earth", "ken follet", 799));
		books.add(new Book("sea of poppies", "amitabh ghosh", 599));
		
		//1. using sort() method of List interface
		//------------------------------------------------
		//a. implementing "int compareTo(Book o)" method in Book 
		//by implementing the Comparable interface
		
		//books.sort(null);
		
		//b. create separate class and implement Comparator<Book>
		//interface and its method "int compare(Book o1,Book o2)"
		
		//BookComparison bc = new BookComparison();
		//books.sort(bc);
		
		//2. using sort() method of utility class Collections
		//------------------------------------------------------
		//a. make sure you have implemented Comparable interface
		//in Book class for the following code to work
		
		//Collections.sort(books);
		
		//b. make sure you have a separate class (BookComparison)
		// and implemented Comparator interface for the following 
		// code to work
		BookComparison bc = new BookComparison();
		Collections.sort(books, bc);
		
		
		
		for (Book book : books) {
			System.out.println(
					book.getTitle()
					+" "
					+book.getAuthorName()
					+" "
					+book.getPrice()
					);
		}

	}

}
