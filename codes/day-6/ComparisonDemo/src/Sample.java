import java.util.Comparator;

public class Sample implements Comparable {

	@Override
	public int compareTo(Object o) {
		if(this == o)
			return 0;
		//other logic to follow...
		
		return 0;
	}
	//x.ompareTo(y);

}
public class SampleComparison implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 == o2)
			return 0;
		//other logic to follow...
		return 0;
	}
	//SampleComaprison comp = new SampleComparison();
	//comp.compare(x,y);
	
}
