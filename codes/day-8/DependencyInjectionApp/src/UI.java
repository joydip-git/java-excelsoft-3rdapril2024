public class UI {
	public static void main(String[] args) {
		
		//Container factory = new Container();
		Container factory = Container.instantiate();
		Container.instantiate();
		//up-casting
		DataAccessContract dao =  factory.create();
		
		BusinessComponent bo;
		//bo = new BusinessComponent(dao);
		bo = new BusinessComponent();
		bo.setDataAccessContract(dao);
		bo.fetchRecords();
	}
}
