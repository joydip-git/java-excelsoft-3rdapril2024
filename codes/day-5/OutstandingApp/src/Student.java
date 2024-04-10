
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

	public String display() {
		return "Name: " + getName() + ", Marks: " + marks;
	}
}
