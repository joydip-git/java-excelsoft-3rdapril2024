
public abstract class DataReader {
	private String path;

	public DataReader() {
	}

	public DataReader(String path) {
		this.path = path;
	}

	//public abstract String getPath();
	public String getPath() {
		return this.path;
	}

	public abstract String readData();
}

public class TextFileDataReader extends DataReader {

	public TextFileDataReader() {
	}

	public TextFileDataReader(String path) {
		super(path);
	}

	@Override
	public String readData() {
		return "file data";
	}
	
	@Override
	public String getPath() {
		return "";
	}

}

public class DataBaseDataReader extends DataReader {

	public DataBaseDataReader() {
	}

	public DataBaseDataReader(String path) {
		super(path);
	}

	@Override
	public String readData() {
		return "db data";
	}

}
