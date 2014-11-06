package trees;

public class ExtremeValueCalculator implements NodeVisitor {

	private Comparable max;
	private Comparable min;
	
	@Override
	public void visit(Object data) {

		Comparable data1 = (Comparable) data;
		
		if(data1==null)
			return;
		if(max==null && min==null){
			max =  data1;
			min = data1;
		}
		if(data1.compareTo(min)<0)
			min =  data1;
		if(data1.compareTo(max)>0){
			max = data1;
		}
		
	}
	
	public Comparable getMax(){
		return max;
	}
	
	public Comparable getMin(){
		return min;
	}
	
	public void printMinMax(){
		System.out.println("Min: "+ min+ ". Max: "+ max+ ".");
	}
}

