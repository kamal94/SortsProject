package trees;

public class BinarySearchTree extends BinaryTree {

	private int numDup = 0;
	
	public BinarySearchTree(){
		super();
		numDup = 1;
	}
	@Override
	public boolean add(Object object) throws WrongInputException{
		
		if(!(object instanceof Comparable))
			throw new WrongInputException();
		
		Comparable toBeAdded = (Comparable) object;
		if(toBeAdded.compareTo(this.getElement())>0){
			this.rightTree().add(object);
		}
		if(toBeAdded.compareTo(this.getElement())<0){
			this.leftTree().add(object);
		}
		if(toBeAdded.compareTo(this.getElement())==0){
			recordDuplicate();
		}
		
		return false;
	}
	
	/**
	 * increments the number of duplicates of the element in <Code>Node<Code>
	 */
	private void recordDuplicate(){
		numDup++;
	}
	
}
