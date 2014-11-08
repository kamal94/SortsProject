package trees;

/*
	Main file for Binary Tree Lab
	@author Autumn C. Spaulding
	Creation Date: 24 July 2000
	
	More thorough documentation may be found within the BinaryTree class file.
*/

public class BinaryTreeLab
{

	public static void main(String args[]) throws Exception
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

		//traverse the tree in breadth-first order to see what you have done.
		System.out.println("\n" + "\n" +"******Traversing Tree: breadth-first order (Using a static method in the main)******");
		BinaryTreeLab.breadthFirstTraversal(binaryTree, printer);
		
		//traverse the tree in-order depth-first order to see what you have done.
		System.out.println( "\n" + "\n" + "******Traversing Tree: pre-order-depth-first order******");
		binaryTree.preOrderDepthFirstTraversal(printer);
		
		//traverse the tree in-order depth-first order to see what you have done.
		System.out.println("\n" + "\n" + "******Traversing Tree: in-order-depth-first order******");
		binaryTree.inOrderDepthFirstTraversal(printer);

		//traverse the tree post-order depth-first order to see what you have done.
		System.out.println("\n" + "\n" + "******Traversing Tree: post-order-depth-first order******");
		binaryTree.postOrderDepthFirstTraversal(printer);
		

		//traverse the tree breadth-first order to see what you have done.
		System.out.println("\n" + "\n" + "******Traversing Tree: breadth-first order******");
		NodeVisitor adder = new AddActionVisitor();
		binaryTree.breadthFirstTraversal(adder);
		System.out.println(adder.completeAction());
		
		//counts the number of leafs in the tree
		NodeVisitor counter = new CounterActionVisitor();
		System.out.println("\n" + "\n" + "******Traversing Tree: breadth-first order******");
		System.out.println("Calculating the number of leafs...");
		binaryTree.numLeafs(counter);
		System.out.println(counter.completeAction());
		
		//counts the number of nodes in the tree
		System.out.println("\n" + "\n" + "******Traversing Tree: breadth-first order******");
		System.out.println("Calculating the number of nodes...");
		binaryTree.numNodes(counter);
		System.out.println(counter.completeAction());
		
		//measures the depth of the tree
		System.out.println("\n"  + "\n" + "*******Traversing Tree to find depth*******");
		System.out.println("Tree depth: " + binaryTree.depth());

		//searches for a number in the tree and returning <code>true<codeif it is present
		System.out.println("\n"  + "\n" + "*********Testing for contains() method*******");
		int numToFind = 12;
		System.out.println("Does the tree contain "+ numToFind + ": " + binaryTree.contains(numToFind) );
		
		//tests how many times an object of the same value is in the tree
		System.out.println("\n"  + "\n" + "*********Testing for numOccurances() method*******");
		System.out.println("How many times does the tree contain 12: " + binaryTree.numOccurences(12) );
		

		ExtremeValueCalculator extremeCalc = new ExtremeValueCalculator();
		//traverse the tree in breadth-first order to see what you have done.
		System.out.println("\n"  + "\n" + "******Finding extreme values: breadth-first order******");
		binaryTree.breadthFirstTraversal(extremeCalc);
		System.out.println(extremeCalc.completeAction());

		/*
		 * Tests three trees for equality
		 */
		BinaryTree tree1 = new BinaryTree();
		tree1.add(new Integer(2));
		tree1.add(new Integer(1));
		tree1.add(new Integer(2));
		tree1.add(new Integer(1));
		tree1.add(new Integer(2));
		tree1.add(new Integer(1));
		tree1.add(new Integer(2));
		tree1.add(new Integer(1));
		
		BinaryTree tree2 = new BinaryTree();
		tree2.add(new Integer(2));
		tree2.add(new Integer(1));
		tree2.add(new Integer(2));
		tree2.add(new Integer(1));
		tree2.add(new Integer(2));
		tree2.add(new Integer(1));
		tree2.add(new Integer(2));
		tree2.add(new Integer(1));

		BinaryTree tree3 = new BinaryTree();
		tree3.add(new Integer(2));
		tree3.add(new Integer(1));
		tree3.add(new Integer(2));
		tree3.add(new Integer(1));
		tree3.add(new Integer(2));
		tree3.add(new Integer(1));
		tree3.add(new Integer(2));
		tree3.add(new Integer(1));
		tree3.add(new Integer(2));
		tree3.add(new Integer(1));

		//printing the identity of tree1 and tree2
		System.out.print(" \n \nTree 1 created: ");
		tree1.breadthFirstTraversal(printer);
		System.out.println(" ");
		System.out.print("Tree 2 created: ");
		tree2.breadthFirstTraversal(printer);
		System.out.println(" ");
		System.out.print("Tree 3 created: ");
		tree3.breadthFirstTraversal(printer);
		
		//traverse the tree in post-order depth-first to see if the trees are equal.
		System.out.println("\n"  + "\n" + "******Equating trees: post-order depth-first traversal******");
		System.out.println("Is tree 1 equal to tree 2? : " + tree1.equals(tree2));

		//traverse the tree in post-order depth-first to see if the trees are equal.
		System.out.println("\n"  + "\n" + "******Equating trees: post-order depth-first traversal******");
		System.out.println("Is tree 1 equal to tree 3? : " + tree1.equals(tree3));
		
		
	}


	/**
	 * A static implementation of the breadthFirstTraversal of a BinaryTree.
	 * 
	 * @param biTree	the binary tree to be traversed
	 * @param action	the NodeVisitor that implements an action on each visit
	 */
	public static void breadthFirstTraversal(BinaryTree biTree, NodeVisitor action)
	{
		Queue queue = new Queue();
		queue.enqueue(biTree);
		while( ! queue.isEmpty() )
		{
			BinaryTree tree = (BinaryTree)queue.dequeue();
			if ( ! tree.isEmpty() )
            {
    			action.visit(tree.getElement());
    			queue.enqueue(tree.leftTree());
    			queue.enqueue(tree.rightTree());
            }
		}
	}	
	
}	//end class BinaryTreeLab
