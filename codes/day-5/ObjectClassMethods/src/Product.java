import java.util.Objects;

public class Product {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		Product other = (Product) obj;
		
		// if (this.id != other.id) {
		if (!Objects.equals(this.id, other.id)) 
			return false;
		
		//if(!this.name.equals(other.name))
		if (!Objects.equals(this.name, other.name)) 
			return false;
		
		//if(!Objects.equals(this.price, other.price))
		if(this.price != other.price)
			return false;
		
		return true;
	}

}
