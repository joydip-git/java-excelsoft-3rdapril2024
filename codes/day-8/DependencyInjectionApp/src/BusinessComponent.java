import java.util.List;

public class BusinessComponent {

	private DataAccessContract dao;

//	public BusinessComponent(DataAccessContract _dao) {
//		dao = _dao;
//	}

	public void setDataAccessContract(DataAccessContract _dao) {
		dao = _dao;
	}

	public List<String> fetchRecords() {
		return dao.getRecords();
	}
}
