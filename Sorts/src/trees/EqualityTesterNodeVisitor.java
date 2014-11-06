package trees;

public class EqualityTesterNodeVisitor implements NodeVisitor {

	private static String original = "";
	private static String testing = "";
	@Override
	public void visit(Object data) {
		original +=data.toString()+ " ";
	}

	public static void printAll(){
		System.out.println(original);
	}
}
