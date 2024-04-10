
class Implementation implements Sample, Abstraction {

	private String path;

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void foo() {
		System.out.println("foo...");
	}

}