package trees;



/*

The BinaryTree Class

@author Autumn C. Spaulding <a href="mailto:autumn@max.cs.kzoo.edu">email</a>
Creation Date: 24 July 2000

Modifications:
    Modifier: Alyce Brady
    Modification Date: November 11, 2002
    Modifications Made: Modifications to documentation (e.g., to remove
        empty preconditions); added levelOrderTraversal;
        also modified to use NodeAction interface.

Modifications:
    Modifier: Kamalaldin Kamalaldin
    Modification Date: 11/06/2014
    Modifications Made: Added many method to improve functionality, like depth traversal
    method and equal() method.

Description:
    This file contains some of the implementation of a BinaryTree class. 
    It is intended as an outline and starting point for the "Binary Trees"
    lab in the Data Structures course.  The implementation is based on the 
    recursive definition of a tree rather than on the graph theory definition
    of a tree (compare to Bailey, 190).
    
    A binary tree is either:
        1.  An empty tree; or
        2.  a node, called a root (the node contains the data), and two 
            children, left and right, each of which are themselves binary trees.
                (Berman, "Data Structures via C++: Objects by Evolution", 1997.)
    
    In this implementation, an empty tree is represented by a node with null
    data and null references for the children.  A leaf node is represented by
    a node with a data value and two references to empty trees (NOT a data
    value and two null references!).  We could represent this as an object
    invariant: data, left, right are either all null (representing an empty
    tree) or none of them are null (a non-empty tree).

*/

public class BinaryTree
{
    //instance variables
    protected Object data;
    protected BinaryTree left;
    protected BinaryTree right;
        

    /** Creates an empty binary tree with no data and no children. */
    public BinaryTree()
    {
        //this is the constructor for the BinaryTree object
        data = null;
        left = null;
        right = null;
    }
     
    /** Tests whether this is an empty tree.
            @return true if the tree is empty; false otherwise
    */
    public boolean isEmpty()
    {return data == null;}

	/**
	 * verifies if a tree is a leaf 
	 * @return boolean true if the node has empty trees as children, false if 
	 * the node has non-empty trees.
	 */
	public boolean isLeaf(){
		if(this.leftTree().isEmpty() && this.rightTree().isEmpty())
			return true;
		return false;
	}
	
/** Gets the data associated with the root node of this particular tree
    (recall recursive definition of trees).
    @return value associated with tree's root node; 
                          null if tree is empty
    */
    public Object getElement()
    {return data;}

    /** Gets the left child of the current tree.
            @return the left child (a tree)
    */
    public BinaryTree leftTree()
    { return left;}

    /** Gets the right child of the current tree.
            @return the right child (a tree)
    */
    public BinaryTree rightTree()
    {return right;}

    /** Adds elements to a binary tree.  This implementation adds the
        elements in breadth-first (top-down, left-to-right) order.
            @param value the value to be added to the tree.
            @return true when the value has been added; should never return false
    */
    public boolean add(Object value) throws WrongInputException
    {
    	if(! (value instanceof Integer)){
    		throw new WrongInputException();
    	}
        Queue queue = new Queue();
        queue.enqueue(this);
        while( ! queue.isEmpty() )
        {
            BinaryTree tree = (BinaryTree)queue.dequeue();

            //if the current position is null, then we know we can place a
            //value here.
            //place the value in that position in the tree, and create new 
            //BinaryTrees for its children, which will both initially be null.
            if (tree.isEmpty())
            {
                tree.data = value;
                tree.left = new BinaryTree();
                tree.right = new BinaryTree();
                return true;
            }
            //otherwise, if the position is not null (that is, we can't place
            //it at the current position), then we add the left and right children
            //to the queue (if we can) and go back to the beginning of the loop.
            queue.enqueue(tree.left);
            queue.enqueue(tree.right);
        }
        return false;    //this statement should never be executed.
    }

	/** Traverses the tree in breadth-first order.
	    @param action an object that will act on all the nodes in the tree
    */
	public void breadthFirstTraversal(NodeVisitor action)
	{
		Queue queue = new Queue();
		queue.enqueue(this);
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
	

	/**
	 * Traverses the tree in depth-first (in-order) order.
	 * @param action	an object that will act on the nodes in the tree
	 * as they are visited
	 */
	public void preOrderDepthFirstTraversal(NodeVisitor action){
		if(this.getElement()==null)
			return;

		action.visit(this.getElement());
		this.left.preOrderDepthFirstTraversal(action);
		this.right.preOrderDepthFirstTraversal(action);
	}
	
	
    
	/**
	 * Traverses the tree in depth-first (in-order) order.
	 * @param action	an object that will act on the nodes in the tree
	 * as they are visited
	 */
	public void inOrderDepthFirstTraversal(NodeVisitor action){
		if(this.getElement()==null)
			return;
		
		this.left.inOrderDepthFirstTraversal(action);
		action.visit(this.getElement());
		this.right.inOrderDepthFirstTraversal(action);
	}
	
	
	/**
	 * Traverses the tree in depth-first (in-order) order.
	 * @param action	an object that will act on the nodes in the tree
	 * as they are visited
	 */
	public void postOrderDepthFirstTraversal(NodeVisitor action){
		if(this.getElement()==null)
			return;
		
		this.left.postOrderDepthFirstTraversal(action);
		this.right.postOrderDepthFirstTraversal(action);
		action.visit(this.getElement());			
	}
	
	/**
	 * Keeps track of the number of leaves in the tree.
	 * @param action	a NodeVisitor that performs an action on 
	 * every node in the tree
	 */
	public void numLeafs(NodeVisitor action){
		Queue queue = new Queue();
		
		queue.enqueue(this);
		
		while(!queue.isEmpty()){
			BinaryTree tree = (BinaryTree) queue.dequeue();
			if(tree.isLeaf()){
				action.visit(tree.getElement());
			}else {
				if (tree.left.getElement()!=null)
					queue.enqueue(tree.left);
				
				if(tree.right.getElement()!=null)
					queue.enqueue(tree.right);
			}
		}
	}
	
	/**
	 * Counts the number of nodes in a tree
	 * @param action	a NodeVisitor that performs an action on 
	 * every node in the tree
	 */
	public void numNodes(NodeVisitor action){
		Queue queue = new Queue();
		
		queue.enqueue(this);
		
		while(!queue.isEmpty()){
			BinaryTree tree = (BinaryTree) queue.dequeue();
			
			if (tree.left.getElement()!=null)
				queue.enqueue(tree.left);
			
			if(tree.right.getElement()!=null)
				queue.enqueue(tree.right);
			
			action.visit(tree.getElement());
			}
		
	}
	
	/**
	 * Measures the depth of the tree
	 * @return depth the depth of the tree
	 */
	public int depth(){
		int depth = 0;
		if(this.isEmpty()){
			return depth;
		} else {
			depth= 1;
		}
		Queue queue = new Queue();
		queue.enqueue(this);
		
		while(!queue.isEmpty()){
			BinaryTree tree = (BinaryTree) queue.dequeue();
			if(tree.left.getElement()!=null){
				queue.enqueue(tree.left);
				depth++;
			}
		}
		
		return depth;
	}
	
	/**
	 * Traverses the tree to check if it contains the passed element
	 * @param object	the element that is searched for in the tree
	 * @return	boolean	returns true if the tree contains the object passed,
	 * returns false if it doesn't 
	 */
	public boolean contains(Object object){
		Queue queue = new Queue();
		
		queue.enqueue(this);
		
		while(!queue.isEmpty()){
			BinaryTree tree = (BinaryTree) queue.dequeue();
			
			if((object).equals(tree.getElement())){
				return true;
			}
			
			if(!tree.isLeaf()){
				queue.enqueue(tree.left);
				queue.enqueue(tree.right);
			}
		}
		return false;
	}
	
	/**
	 * Traverses through the tree and counts every time a node 
	 * in the tree has the same value as the passed object
	 * @param object	the object to be searched for
	 * @return	occur	the number of occurances of the object passed in the tree
	 */
	public int numOccurences(Object object){
		
		int occur = 0;
		Queue queue = new Queue();
		queue.enqueue(this);
		
		while(!queue.isEmpty()){
			BinaryTree tree = (BinaryTree) queue.dequeue();
			
			if((object).equals(tree.getElement())){
				occur++;
			}
			
			if(!tree.leftTree().isEmpty())
				queue.enqueue(tree.left);
			if(!tree.rightTree().isEmpty())
				queue.enqueue(tree.rightTree());
		}
		
		return occur;
	}
	
	/**
	 * Traverses the tree and determines the maximum and minimum
	 * values within it.
	 * @param action	a Nodevisitor that visits each node
	 */
	public void ExtremeValuesTraversal(NodeVisitor action){
		Queue queue = new Queue();
		queue.enqueue(this);
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
	
	/**
	 * Determines if the tree is equal to the passed tree.
	 * @param object	the tree that is being compared
	 * @return 	boolean	true if the two trees are equal, false if not
	 * @throws Exception	thrwows an exception if the object passed is not a tree
	 */
	public boolean equal(Object object) throws Exception{
		if(!(object instanceof BinaryTree)){
			System.out.println("The object is not a BinaryTree");
			throw new Exception();
		}
		
		
		BinaryTree tree = (BinaryTree) object;
		if((this.leftTree()==null) && tree.leftTree()==null){
			return true;
		}
		if((this.leftTree()==null && tree.rightTree()!=null) || (this.rightTree()!=null &&tree.rightTree()==null)){
			return false;
		}
		if(this.getElement().equals(tree.getElement()) && this.leftTree().equal(tree.leftTree()) && this.rightTree().equal(tree.rightTree())){
			return true;
		}
		
		return false;
	}
}    //end class BinaryTree
