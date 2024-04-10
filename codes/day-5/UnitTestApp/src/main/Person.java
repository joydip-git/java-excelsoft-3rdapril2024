package main;

public class Person {
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
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		Person other = (Person)obj;
		if(!this.name.equals(other.name))
			return false;
		
		return true;		
	}
	
	
}
