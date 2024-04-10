
public class Professor extends Person {

	private int booksPublished;

	public Professor() {
	}

	public Professor(String name, int booksPublished) {
		super(name);
		this.booksPublished = booksPublished;
	}

	public int getBooksPublished() {
		return booksPublished;
	}

	public void setBooksPublished(int booksPublished) {
		this.booksPublished = booksPublished;
	}

	@Override
	public boolean isOutstanding() {
		return booksPublished >= 4;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;

		Professor other = (Professor) obj;
		if (this.booksPublished != other.booksPublished)
			return false;

		return true;
	}

	public String print() {
		return "Name: " + getName() + ", Books Published: " + booksPublished;
	}

}
