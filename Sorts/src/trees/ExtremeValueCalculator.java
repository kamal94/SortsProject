package trees;
/**
 * A class that keeps track of the maximum and minimum between
 * the nodes it visits. It then resets the maximum and minimum
 * after the action is completed and prints the results out.
 * @author Kamal
 * @version	11/06/2014
 */
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

	@Override
	public String completeAction() {
		String result = "Min: "+ min+ ". Max: "+ max+ ".";
		min = null;
		max = null;
		return result;
	}
}

