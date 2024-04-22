
public class Container {
	
	private static Container factory;
	
	private Container() {
		System.out.println("created");
	}
	
	public static Container instantiate() {
		if (factory == null)
			factory = new Container();	
		
		return factory;
	}

	public DataAccessContract create() {
		DataAccessContract dao = new Dao();
		return dao;
	}
}
