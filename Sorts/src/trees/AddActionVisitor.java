package trees;

public class AddActionVisitor implements NodeVisitor {

	private int sum;
	@Override
	public void visit(Object data) {
		sum+= (Integer) data;
	}
	
	public void completeAction(){
		System.out.print("Total sum is: "+sum);
		int sum=0;
	}

}
