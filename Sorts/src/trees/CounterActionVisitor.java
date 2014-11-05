package trees;

public class CounterActionVisitor implements NodeVisitor {

	private int count;
	@Override
	public void visit(Object data) {
		if(data!=null){
			count++;
			System.out.println(data.toString());
		}
	}
	
	public void printCount(){
		System.out.println("Number of nodes of the speicified properties in tree is: "+count);
	}

}
