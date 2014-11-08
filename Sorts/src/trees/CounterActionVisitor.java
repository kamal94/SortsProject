package trees;
/**
 * A class that counts the number of nodes it visits. It resets the count and 
 * returns the results when the action is complete.
 * @author Kamal kamalaldin
 *@version 11/06/2014
 */
public class CounterActionVisitor implements NodeVisitor {

	private int count;
	@Override
	public void visit(Object data) {
		if(data!=null){
			count++;
		}
	}
	
	@Override
	/**
	 * Completes the action of the NodeVisitor and prints the result. The value of 
	 * count is also reset in case the NodeVisitor is used again in the future.
	 */
	public String completeAction() {
		String result = "Number of nodes of the speicified properties in tree is: "+count;
		count=0;
		return result;
	}

}
