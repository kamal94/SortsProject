import java.util.ArrayList;
import java.util.Random;

/**
 * A class that serves to easily provide data to insertionSort classes
 * @author Kamal Kamalaldin
 * @version 10/30/2014
 *
 */
public class Data<T> {

	private static Random random = new Random();
	/**
	 * A method that returns an arraylist of integers of the specified size
	 * @param size	
	 * @return	array	an ArrayList from 0 to size.
	 */
	public static ArrayList<Integer> getRandomArray(int size){
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i=0;i<size;i++)
			array.add(random.nextInt(size));
		return array;
	}

}
