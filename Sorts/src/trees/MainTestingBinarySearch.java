package trees;

/**
 * A main class that tests the functionality of BST.
 * @author Kamal
 *@version	11/06/2014
 */
public class MainTestingBinarySearch {

	public static void main(String[] args){
		
		/*
		 * Testing creating a BST
		 */
		BinarySearchTree searchTree = new BinarySearchTree();
		try{
		searchTree.add(new Integer(8));
		searchTree.add(new Integer(14));
		searchTree.add(new Integer(5));
		searchTree.add(new Integer(6));
		searchTree.add(new Integer(3));
		searchTree.add(new Integer(4));
		searchTree.add(new Integer(60));
		} catch (WrongInputException e){
			e.printStackTrace();
		}
		
		
		/*
		 * Testing traversing a BST
		 */
		NodeVisitor printer = new PrintAction();
		System.out.println("******Traversing Tree: breadth-first order******");
		System.out.println("BST searchTree created: ");
		searchTree.breadthFirstTraversal(printer);
		System.out.println(printer.completeAction());

		/*
		 * Testing removing from a BST
		 */
		System.out.println(" \n******Removing 6 and 5*******");
		System.out.println("Operation succeeded?  " + searchTree.remove(new Integer(6)));
		System.out.println("Operation succeeded?  " + searchTree.remove(new Integer(5)));

		System.out.println("\n******Traversing Tree: breadth-first order******");
		searchTree.breadthFirstTraversal(printer);
		printer.completeAction();
		

		/*
		 * Testing removing leftmost from a BST
		 */
		System.out.println("\n******Removing leftmost in BST*******");
		System.out.println("Element removed: " + searchTree.removeLeftMost());

		System.out.println("\n******Traversing Tree: breadth-first order******");
		searchTree.breadthFirstTraversal(printer);
		printer.completeAction();
		
		
		/*
		 * Testing comparing BSTs
		 */
		BinarySearchTree tree1 = new BinarySearchTree();
		try {
			tree1.add(new Integer(8));
			tree1.add(new Integer (4));
			tree1.add(new Integer(14));
			tree1.add(new Integer(7));
			tree1.add(new Integer(3));
			tree1.add(new Integer(17));
			tree1.add(new Integer(2));
		} catch (WrongInputException e) {
			e.printStackTrace();
		}


		System.out.println("******Traversing Tree: breadth-first order******");
		System.out.println("BST tree1 created: ");
		tree1.breadthFirstTraversal(printer);
		System.out.println(printer.completeAction());
		
		BinarySearchTree tree2 = new BinarySearchTree();
		try {
			tree2.add(new Integer(8));
			tree2.add(new Integer (4));
			tree2.add(new Integer(14));
			tree2.add(new Integer(7));
			tree2.add(new Integer(3));
			tree2.add(new Integer(2));
			tree2.add(new Integer(17));
		} catch (WrongInputException e) {
			e.printStackTrace();
		}

		System.out.println("******Traversing Tree: breadth-first order******");
		System.out.println("BST tree2 tree1 created: ");
		tree2.breadthFirstTraversal(printer);
		System.out.println(printer.completeAction());
		
		
		System.out.println("is tree1 equal to tree2? " + tree1.equals(tree2));
		
		System.out.println(" \n******Removing 4 from tree1*******");
		System.out.println("Operation succeeded?  " + tree1.remove(new Integer(4)));
		
		System.out.println("******Traversing Tree: breadth-first order******");
		System.out.println("BST tree1 modified: ");
		tree1.breadthFirstTraversal(printer);
		System.out.println(printer.completeAction());
		
		System.out.println("is tree1 equal to tree2? " + tree1.equals(tree2));
		
		int numToFind = 43242;
		System.out.println("does tree1 contain "+ numToFind + " ?" + tree1.contains(numToFind));
		
		
		/*
		 * Testing tree1 and testFalse for being BSTs
		 */
		System.out.println("Is tree1 a BST? " +  MainTestingBinarySearch.isBST(tree1));
		
		BinaryTree testFalse = new BinaryTree();
		try {
			testFalse.add(new Integer(8));
			testFalse.add(new Integer(4));
			testFalse.add(new Integer(10));
			testFalse.add(new Integer(11));
		} catch (WrongInputException e) {
			e.printStackTrace();
		}
		

		System.out.println("\n******Traversing Tree: breadth-first order******");
		System.out.println("Binary tree testFalse created: ");
		testFalse.breadthFirstTraversal(printer);
		System.out.println(printer.completeAction());
		
		System.out.println("Is testFalse a BST? " + MainTestingBinarySearch.isBST(testFalse));
	}
	

	/**
	 * A static method that checks if a tree is a BinarySearchTree or not.
	 * @param binaryTree	a BST to test
	 * @return	boolean	true if the binary tree is a BST, false if not
	 */
	public static boolean isBST(BinaryTree binaryTree){
		
		//handles an empty node
		if(binaryTree.isEmpty())
			return true;
		
		//handles a leaf
		if(binaryTree.isLeaf())
			return true;
		
		//handles a node with an empty left node
		if(binaryTree.leftTree().isEmpty()){
			if(((Comparable)binaryTree.rightTree().getElement()).compareTo(binaryTree.getElement())>0)
				return true;
			else return false;
		}
		
		//handles a node with an empty right node
		if(binaryTree.rightTree().isEmpty()){
			if(((Comparable)binaryTree.leftTree().getElement()).compareTo(binaryTree.getElement())<0)
				return true;
			else return false;
		}
		
		//handles comparisons of trees recursively
		if(((Comparable) binaryTree.leftTree().getElement()).compareTo(binaryTree.rightTree().getElement())<0){
			if(MainTestingBinarySearch.isBST(binaryTree.leftTree()) && MainTestingBinarySearch.isBST(binaryTree.rightTree()))
					return true;
		}
		
		//base-case for false
		return false;
	}

}
