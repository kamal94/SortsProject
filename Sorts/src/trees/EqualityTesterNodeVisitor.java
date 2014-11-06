package trees;

public class EqualityTesterNodeVisitor implements NodeVisitor {

	private static String original = "";
	private static String testing = "";
	@Override
	public void visit(Object data) {
		original +=data.toString()+ " ";
	}

	
	public void completeAction(){
		System.out.print(original);
	}
}
