package trees;

/*
	Main file for Binary Tree Lab
	@author Autumn C. Spaulding
	Creation Date: 24 July 2000
	
	More thorough documentation may be found within the BinaryTree class file.
*/

public class BinaryTreeLab
{

	public static void main(String args[])
	{
		// Debug.turnOn();
		Debug.turnOff();

		Integer i;
		
		//construct an empty binary tree here.
		BinaryTree binaryTree = new BinaryTree();
		try {
			binaryTree.add(new Integer(12));
			binaryTree.add(new Integer(7));
			binaryTree.add(new Integer(3));
			binaryTree.add(new Integer(4));
			binaryTree.add(new Integer(8));
			binaryTree.add(new Integer(25));
			binaryTree.add(new Integer(10));
			binaryTree.add(new Integer(142));
			binaryTree.add(new Integer(17));
			binaryTree.add(new Integer(26));
		} catch (WrongInputException e) {
			e.printStackTrace();
		}
		
		
		//insert elements in level order here.


		//traverse the tree in breadth-first order to see what you have done.
        NodeVisitor printer = new PrintAction();
		System.out.println("******Traversing Tree: breadth-first order******");
		// tree.breadthFirstTraversal(printer);
			
	}

}	//end class BinaryTreeLab
