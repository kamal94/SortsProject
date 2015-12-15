package sorts;

import org.junit.Before;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * A class that tests the Sort class and all of its sorts.
 *
 * Created by Kamal on 12/10/15.
 *
 * @version 12/14/2015
 */
public class SortTest {


    private Integer[] unsortedInts;
    private Integer[] sortedInts;
    private final int ARRAY_SIZE = 1000;

    @Before
    public void initialize() {
        sortedInts = new Integer[ARRAY_SIZE];
        unsortedInts = new Integer[ARRAY_SIZE];

        //setup sorted array
        for(int i = 0; i < ARRAY_SIZE; i++)
            sortedInts[i] = i;

        //setup unsorted array
        boolean[] alreadyInArray = new boolean[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++) {
            Random random = new Random();
            int j = random.nextInt(ARRAY_SIZE);
            while(alreadyInArray[j])
                j = random.nextInt(ARRAY_SIZE);
            alreadyInArray[j] = true;
            unsortedInts[i] = j;
        }
    }

    @org.junit.Test
    public void testInsertionSort() throws Exception {
        Sort<Integer> sort = new Sort<Integer>();

        //assert not equal before sort
        assertNotEquals(sortedInts, unsortedInts);
        assertNotEquals(sort.arrayToString(sortedInts), sort.arrayToString(unsortedInts));

        //sort
        sort.insertionSort(unsortedInts);

        //assert equal after sort
        assertArrayEquals(sortedInts, unsortedInts);
        assertEquals(sort.arrayToString(sortedInts), sort.arrayToString(unsortedInts));
    }

    @org.junit.Test
    public void testQuiskSort() throws Exception {
        Sort<Integer> sort = new Sort<Integer>();

        //assert not equal before sort
        assertNotEquals(sortedInts, unsortedInts);
        assertNotEquals(sort.arrayToString(sortedInts), sort.arrayToString(unsortedInts));

        //sort
        sort.quickSort(unsortedInts);

        //assert equal after sort
        assertArrayEquals(sortedInts, unsortedInts);
        assertEquals(sort.arrayToString(sortedInts), sort.arrayToString(unsortedInts));
    }


}