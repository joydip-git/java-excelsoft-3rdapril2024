
public class Product {
	// data members
	private String name;
	private int id;
	private double price;

	// constructors
	public Product() {
	}

	public Product(String name, int id, double price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		// modify the code below
		final int prime = 31;
		int hash = Integer.hashCode(this.id) * prime;
		hash = this.name.hashCode() * hash;
		hash = Double.hashCode(this.price) * hash;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
