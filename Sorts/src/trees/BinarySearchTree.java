package trees;
/**
 * A binary tree that is specified as such that the values in the right tree
 * are larger than the node and the values in the left tree are small than
 * the node. Only comparable objects can be inserted in to the BinarySearchTree
 * (BST) and they are inserted depending on their comparable values as to maintain
 * the aforementioned order of logic. This BST handles duplicates by incrementing
 * a private int that represents how many times the same object has been added
 * to the tree.
 * 
 * @author Kamal
 *@version 11/06/2014
 */
public class BinarySearchTree extends BinaryTree {

	//private instance fields
	private int numDup = 0;
	
	public BinarySearchTree(){
		numDup = 1;
	}
	@Override
	public boolean add(Object object) throws WrongInputException{
		
		if(!(object instanceof Comparable))
			throw new WrongInputException();
		
		Comparable toBeAdded = (Comparable) object;
		
		if(this.isEmpty()){
			this.data = object;
			this.left = new BinarySearchTree();
			this.right = new BinarySearchTree();
			return true;
		}
		if(toBeAdded.compareTo(this.getElement())>0){
			return ((BinarySearchTree) this.rightTree()).add(object);
		}
		if(toBeAdded.compareTo(this.getElement())<0){
			return ((BinarySearchTree) this.leftTree()).add(object);
		}
		if(toBeAdded.compareTo(this.getElement())==0){
			numDup++;
			return true;
		}
		
		return false;
	}
	
	/**
	 * finds the leftmost node in the tree and returns its element
	 * @return	element	the element of the leftmost node
	 */
	private Object leftMost(){

		if(this.isLeaf())
			return this.getElement();
		
		return ((BinarySearchTree) this.leftTree()).leftMost();
	}
	
	/**
	 * Finds and removes the leftmost node in the tree and returns its element.
	 * If the leftmost node's right node contains a tree, then the leftmost
	 * node is replaced with the right node and the previously leftmost node
	 * is returned.
	 * @return	element	the element of the leftmost node
	 */
	public Object removeLeftMost(){
		if (this.isEmpty()){
			return null;
		}
		
		BinarySearchTree backupRemoved = new BinarySearchTree(); //used only if the leftmose node has a right tree
		
		//base case
		if(this.leftTree().isEmpty()){	
			if(!this.rightTree().isEmpty()){	//if the right tree is node empty
				//set backup's values as "this" node's values
				backupRemoved.right = this.right;
				backupRemoved.left = this.left;
				backupRemoved.data = this.data;
				
				//copies the data of the right node to "this" tree
				this.data = this.rightTree().data;
				this.left = this.rightTree().left;
				this.right = this.rightTree().right;
				
				//returns the backup tree's element
				return backupRemoved.getElement();
			}
			
			//if both children trees are empty, backup the node
			backupRemoved.data = this.data;
			//and set the node to empty
			this.data = null;
			//and return the backup's element
			return backupRemoved.getElement();
		}
		
		//recursion through the left edge of the tree
		return ((BinarySearchTree) this.leftTree()).removeLeftMost();
	}
	
	public boolean remove(Comparable comparable){
		
		//base case for a found element
		if(((Comparable) this.getElement()).compareTo(comparable)==0){
			
			//if "this" is a leaf, then set it's element to null.
			if(this.isLeaf()){
				this.data = null;
				return true;
			}
			
			//if the right node is empty, then replace "this" node with the left node.
			if(this.rightTree().isEmpty()){
				this.data = this.left.data;
				this.right = this.left.right;
				this.left = this.left.left;
				return true;
			}
			
			//if none of the previous cases match, then replace "this" node with
			//the smallest node from the right tree
			this.data = ((BinarySearchTree) this.rightTree()).removeLeftMost();
			return true;
		}

		//recursive searching and removing for the node that matches the comparable
		if(((Comparable) this.getElement()).compareTo(comparable)<0){
			return ((BinarySearchTree) this.rightTree()).remove(comparable);
		}
		if(((Comparable) this.getElement()).compareTo(comparable)>0){
			return ((BinarySearchTree) this.leftTree()).remove(comparable);
		}
		
		//base case for a non-found element
		return false;
	}
	
	public int getNumDup(){
		return numDup;
	}
}
