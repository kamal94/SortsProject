package trees;

public class MainTestingBinarySerach {

	public static void main(String[] args) {
		BinarySearchTree searchTree = new BinarySearchTree();
		
		try{
		searchTree.add(new Integer(2));
		searchTree.add(new Integer(3));
		searchTree.add(new Integer(1));
		} catch (WrongInputException e){
			e.printStackTrace();
		}
		
		NodeVisitor printer = new PrintAction();
		searchTree.breadthFirstTraversal(printer);
		printer.completeAction();


		try{
		searchTree.add(new Integer(4));
		searchTree.add(new Integer(5));
		searchTree.add(new Integer(8));
		searchTree.add(new Integer(6));
		} catch (WrongInputException e){
			e.printStackTrace();
		}
		

		searchTree.breadthFirstTraversal(printer);
		printer.completeAction();
		searchTree.preOrderDepthFirstTraversal(printer);
		printer.completeAction();
	}

}
