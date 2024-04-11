
public class Sample<T extends Person> {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

/*
 * public class Sample {
 * 
 * private Object data;
 * 
 * public Object getData() { return data; }
 * 
 * public void setData(Object data) { this.data = data; } }
 */
