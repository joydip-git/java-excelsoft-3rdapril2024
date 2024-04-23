package functionalinterfaacedemo;

@FunctionalInterface
public interface PrintLogic<TInput> {
	void print(TInput value);
	// class Implementation implements PrintLogic{
	//
//		@Override
//		public void print(String value) {
//			// TODO Auto-generated method stub
//			
//		}
	//
	// }
}

//class Implementation implements PrintLogic{
//
//	@Override
//	public void print(String value) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}