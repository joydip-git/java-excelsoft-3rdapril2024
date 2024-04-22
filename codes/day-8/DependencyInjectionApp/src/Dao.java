import java.util.ArrayList;
import java.util.List;

public class Dao implements DataAccessContract {

	public Dao() {
	}

	@Override
	public List<String> getRecords() {
		return new ArrayList<String>();
	}
}
