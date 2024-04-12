
public class Student implements Comparable<Student> {
	private String name;
	private String techStream;
	private int id;

	public Student() {
	}

	public Student(String name, String techStream, int id) {
		this.name = name;
		this.techStream = techStream;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechStream() {
		return techStream;
	}

	public void setTechStream(String techStream) {
		this.techStream = techStream;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Student o) {
		if (this == o)
			return 0;
		return Integer.compare(this.getId(), o.getId());
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ", Stream: " + this.techStream;
	}

}
