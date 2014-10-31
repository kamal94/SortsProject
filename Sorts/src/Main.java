import java.util.ArrayList;

import sorts.SelectionSort;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> data = Data.getRandomArray(100);
		SelectionSort.sort(data);
	}

}
