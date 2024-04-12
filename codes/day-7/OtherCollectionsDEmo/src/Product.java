import java.util.Objects;

public class Product implements Comparable<Product> {
	private int id;
	private String name;
	private double price;

	public Product() {
	}

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return Integer.hashCode(id) * prime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		Product other = (Product) obj;
		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Price: " + price;
	}

	@Override
	public int compareTo(Product o) {
		if (this == o)
			return 0;

		return Integer.compare(this.getId(), o.getId());
	}

}
