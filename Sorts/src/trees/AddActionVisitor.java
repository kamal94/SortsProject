package trees;
/**
 * A class that adds the nodes that it visits, assuming
 * the nodes are integers. The class resets the data and returns the results
 * in a String format when the completeAction method is called.
 * @author Kamal
 *@version 11/06/2014
 */

public class AddActionVisitor implements NodeVisitor {

	private int sum;
	@Override
	public void visit(Object data) {
		sum+= (Integer) data;
	}
	
	public String completeAction(){
		String result = "Total sum is: "+sum;
		int sum=0;
		return result;
	}

}
