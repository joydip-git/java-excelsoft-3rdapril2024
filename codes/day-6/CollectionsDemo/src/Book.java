
public class Book implements Comparable<Book> {
	private String title;
	private String authorName;
	private double price;

	public Book() {
	}

	public Book(String title, String authorName, double price) {
		this.title = title;
		this.authorName = authorName;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Book o) {
		if (this == o)
			return 0;

		return this.getTitle().compareTo(o.getTitle());
	}
}
