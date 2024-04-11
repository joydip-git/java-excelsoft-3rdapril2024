import java.util.Comparator;

public class BookComparison implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		if(o1==o2)
			return 0;
		
		return o1.getAuthorName().compareTo(o2.getAuthorName());
	}

}
