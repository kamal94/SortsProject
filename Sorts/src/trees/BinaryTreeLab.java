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

		NodeVisitor printer = new PrintAction();
		
		
		//insert elements in level order here.
		try {
			binaryTree.add(new Integer(12));
			binaryTree.add(new Integer(7));
			binaryTree.add(new Integer(3));
			binaryTree.add(new Integer(4));
			binaryTree.add(new Integer(8));
			binaryTree.add(new Integer(25));
			binaryTree.add(new Integer(0));
			binaryTree.add(new Integer(142));
			binaryTree.add(new Integer(17));
			binaryTree.add(new Integer(26));
		} catch (WrongInputException e) {
			e.printStackTrace();
		}

		//traverse the tree in breadth-first order to see what you have done.
		System.out.println("******Traversing Tree: breadth-first order******");
		binaryTree.breadthFirstTraversal(printer);
		
		//traverse the tree in-order depth-first order to see what you have done.
		System.out.println("\n" + "\n" + "******Traversing Tree: in-order-depth-first order******");
		binaryTree.inOrderDepthFirstTraversal(printer);

		//traverse the tree post-order depth-first order to see what you have done.
		System.out.println("\n" + "\n" + "******Traversing Tree: post-order-depth-first order******");
		binaryTree.postOrderDepthFirstTraversal(printer);
		
		
			
		AddActionVisitor adder = new AddActionVisitor();
		binaryTree.breadthFirstTraversal(adder);
		adder.printSum();
		
		System.out.println("\n" + "\n" + "******Traversing Tree: breadth-first order******");
		System.out.println("Calculating the number of leafs...");
		binaryTree.numLeafs(new CounterActionVisitor());
		

		System.out.println("\n" + "\n" + "******Traversing Tree: breadth-first order******");
		System.out.println("Calculating the number of nodes...");
		binaryTree.numNodes(new CounterActionVisitor());
		
		System.out.println("\n"  + "\n" + "*******Traversing Tree to find depth*******");
		System.out.println("Tree depth: " + binaryTree.depth());

		System.out.println("*********Testing for contains() method*******");
		System.out.println("Does the tree contain 12: " + binaryTree.contains(12) );
		
		System.out.println("*********Testing for numOccurances() method*******");
		System.out.println("How many times does the tree contain 12: " + binaryTree.numOccurences(12) );
		

		ExtremeValueCalculator extremeCalc = new ExtremeValueCalculator();
		//traverse the tree in breadth-first order to see what you have done.
		System.out.println("******Finding extreme values: breadth-first order******");
		binaryTree.breadthFirstTraversal(extremeCalc);
		extremeCalc.printMinMax();
	}

}	//end class BinaryTreeLab
