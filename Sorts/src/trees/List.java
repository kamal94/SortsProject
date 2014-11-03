package trees;

import java.util.NoSuchElementException;

/**
 * 
 * A very basic list class.  Elements can only be added at the beginning at
 * the beginning of the list, and can only be removed according to their
 * index.
 * @Author Nathan Sprague
 * @version October 2, 2014
 * 
 * Modifications: 
 * 10/1/2014		Kamalaldin Kamalaldin		Modified the class to enable the addition and 
 * 												removal of elements from the List. Added functionality
 * 												to remove an element anywhere in the list.
 * 10/03/2014		Kamalaldin Kamalaldin		Added a removeFirst method that uses removeElement() to remove
 * 												the first node from the list
 * 10/04/2014		Kamalaldin Kamalaldin		Added a addElement method that can add an element
 * 												at a specified index rather than the first index
 * 												of the list.
 * 10/08/2014		Kamalaldin Kamalaldin		Modified the find method from private to public 
 * 												to provide an easier, faster implementation of the Queue class
 * 												by simple finding and returning the node at that index rather
 * 												than having to remove the node, return it, then add it again.
 * 10/08/2014		Kamalaldin Kamalaldin		Modified the addElement(index, element) method to allow for addition
 * 												at the 0th index by calling the addElement(element) method. The size
 * 												incremention operation was moved from the end of the addElement(index, element)
 * 												method to avoid duplicate size incremention
 * 					
 */
public class List<T> {

	private Node<T> first;		//the prime node in the list. The list can only be accessed from this node.
	private int size;			//the size of the list (number of elements in the list)
	
	/**
	 * Constructor that creates an empty list.
	 */
	public List() {
		first = null;
		size = 0;
	}

	/**
	 *Adds a new element AT THE BEGINNING of the list. 
	 * If this is the first element to be added to the list,
	 * the first node is instantiated. If it is the second, third, fourth...
	 * element to be added, then make this element the first one and have it
	 * point at the previously added element. At the end of the addition
	 * of the new element, the list size is increased.
	 * 
	 * @param element  The element to add
	 */
	public void addElement(T element) 
	{
		if(first==null){
			first = new Node<T>(element);
		}
		else{
			Node<T> temp = first;
			first = new Node<T>(element);
			first.setNext(temp);
		}
		size+=1;
	}
	
	/**
	 * Adds a new element to the list at the specified index. 
	 * 
	 * The method will throw an exception if the index is negative,
	 * greater than the list size, or if its a non-zero index that is used
	 * to add the first element in the list.
	 * 
	 * @param element  	The element to add
	 * @param index		The index at which the element is added
	 * @throws NoSuchElementException
	 */
	public void addElement(int index, T element){
		if((size==0 && index!=0) || index>size || index<0){
			throw new NoSuchElementException();
		}
		if(index==size && size==0){
			this.addElement(element);
		}
		else if(index==size){
			Node<T> newNode = new Node<T>(element);
			newNode.setNext(null);
			find(index-1).setNext(newNode);
			size+=1;
		}
		else{
			Node<T> newNode = new Node<T>(element);
			newNode.setNext(find(index+1));
			find(index-1).setNext(newNode);
			size+=1;
		}
	}
	
	
	/**
	 * Removes and returns the element at the specified index. Throws
	 * a noSuchElementException if the index is out of bounds.
	 *  
	 * @param 		index		index - position of the element to remove
	 * @return 		T			the element that was removed
	 * @throws 		NoSuchElementException
	 */
	public T removeElement(int index) throws NoSuchElementException
	{
		//if the list is empty or the index is out of bounds, throw an exception
		if(first==null || index<0 || index>size-1){
			throw new NoSuchElementException();
		}
		
		Node<T> currentNode = null;		//sets up current node
		
		//looks at the "depth" of the desired element in the list
		//depth defined as: "how many links from the first node are
		//required to reach the specified element" 
		for(int i=0; i<=index; i++){
			if(currentNode==null){currentNode=first;}	//if its the first iteration of the loop,
														//set the current node to first.
			else{currentNode = currentNode.getNext();}	//"dig deeper" into the list by following the links			
		}
		
		if(currentNode.equals(first)){	//if the first node is the desired node to remove,	
			first = first.getNext();	//then set the node after first as the first node.
		}
		else {			//otherwise, if the desired to remove node is not the first node, then...
			find(index-1).setNext(currentNode.getNext());	//set the link to the previous node as the node after the current one.
		}
		
		size -=1;		//increment list size
		return (T) currentNode.getElement(); 		//return the deleted node.
		
	}
	
	/**
	 * Finds the element at the specified index.
	 * If the element can not be found, throws a NoSuchElementException.
	 * 
	 * @param 	index		the index that contains the element
	 * @return	Node<T>		the node that is to be found
	 * @throws	NoSuchElementException
	 */
	public Node<T> find(int index){
		Node<T> current = null;
		for(int i=0; i<=index;i++){
			if(i==0){current =  first;}
			else {current = current.getNext();}
		}
		
		if(current==null){
			throw new NoSuchElementException();
		}
		return current;
	}
	
	/**
	 * Removes the first element of the list and returns it
	 * 
	 * @return Node<T>		the first Node in the list
	 */
	public T removeFirst(){return removeElement(0);}
	
	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return	size	size of the list
	 */
	public int size()
	{return size;}
	
}
