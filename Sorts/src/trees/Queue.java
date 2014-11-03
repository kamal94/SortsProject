package trees;

import java.util.NoSuchElementException;

/**
 * A generic queue class that takes in an object and inserts it
 * at the end of a list, then removes an object from the beginning
 * of a list
 * @author 		Kamalaldin Kamalaldin
 * @version		10/09/2014
 * @param <T>
 */
public class Queue<T> implements QueueInterface {

	//private instance variables
	private List list;
	
	// public constructor
	public Queue(){
		list = new List();
	}
	
	/**
	 * Checks if the queue is empty
	 * @return		boolean		True if the queue has no elements
	 */
	@Override
	public boolean isEmpty() {
		return list.size()==0;
	}

	/**
	 * adds an element to the queue. Elements are added to the tail of the queue
	 * 
	 * @param		item	Any generic object at the tail of the queue
	 */
	@Override
	public void enqueue(Object item) {
		list.addElement(list.size(), (T) item);
	}

	
	/**
	 * Removes an element from the queue. The element  is removed from the head
	 * of the list. It tries to remove the head and if the queue is empty it catches the error
	 * 
	 * @return		T		The generic element at the head of the queue.
	 */
	@Override
	public T dequeue() {
		T t = null;
		try {
			t = (T) list.removeFirst();
		} catch (NoSuchElementException e) {
			System.out.println("The queue is empty: " + e);
		}
		return t;
	}

	/**
	 * Returns the head element of the queue without removing it
	 * 
	 * @return		T		The head element of the queue
	 */
	@Override
	public T peekFront() {
		return (T) list.find(0);
	}
	
	/**
	 * Returns a string representation of the queue, starting with the head of the queue
	 * and continuing to the tail of the queue.
	 * 
	 * @return		String		A string representation of the queue, starting with the head and ending with the tail
	 */
	public String toString(){
		if(!isEmpty()){
			String string = "";
			for(int i=0; i<list.size(); i++){
				string += list.find(i).getElement().toString() + " ";
			}
			
			return string;
		}
			
		else
			return "queue is empty";
	}

}
