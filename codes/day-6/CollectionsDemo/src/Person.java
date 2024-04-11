
public class Person implements Comparable<Person> {
	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		Person other = (Person) obj;
		if (!this.getName().equals(other.getName()))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int hash = this.name.hashCode();
		System.out.println(hash);
		return hash;
	}

	@Override
	public String toString() {
		return "Name: " + name;
	}
}
