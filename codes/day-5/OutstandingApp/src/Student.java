
public class Student extends Person {

	private double marks;

	public Student() {
	}

	public Student(String name, double marks) {
		super(name);
		this.marks = marks;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public boolean isOutstanding() {
		return marks >= 85 ? true : false;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(!super.equals(obj))
			return false;

		Student other = (Student)obj;
		if (this.marks != other.marks)
			return false;
		
		return true;
	}

	public String display() {
		return "Name: " + getName() + ", Marks: " + marks;
	}
}
