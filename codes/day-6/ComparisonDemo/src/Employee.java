
public class Employee implements Comparable {
	private int id;
	private String name;

	public Employee() {
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public int compareTo(Object o) {
		if (this == o)
			return 0;
		
		Employee other = (Employee) o;
		if (Integer.compare(this.id, other.id) == 0)
			return this.name.compareTo(other.name);
		else
			return Integer.compare(this.id, other.id);
	}
}
