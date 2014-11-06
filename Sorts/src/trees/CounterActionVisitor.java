package trees;

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
	public void completeAction() {
		System.out.println("Number of nodes of the speicified properties in tree is: "+count);
		count=0;
	}

}
