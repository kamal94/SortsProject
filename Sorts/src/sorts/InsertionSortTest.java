package sorts;

import static org.junit.Assert.*;

/**
 * Created by Kamal on 12/10/15.
 */
public class InsertionSortTest {

    @org.junit.Test
    public void testSort() throws Exception {
        Integer[] integers = new Integer[5];
        for(int i = 0; i< 5; i++)
            integers[i] = 5-i;

        InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        integers = insertionSort.sort(integers);


        Integer[] sorted = new Integer[5];
        for(int i = 0; i< 5; i++)
            sorted[i] = i+1;

        assertEquals(integers, sorted);
    }
}