package sorts;

/**
 * Created by Kamal on 12/10/15.
 */
public class Sort<T extends Comparable>{

    /**
     * Sorts the passed array using insertion insertionSort.
     *
     * @param ar    T[] Array of elements t.
     */
    public T[] insertionSort(T[] ar) {

        if(ar.length <= 1)
            return ar;

        for(int i = 1; i < ar.length; i++) {
            T t = ar[i];
            int pos = i - 1;
            while(pos >= 0 && ar[pos].compareTo(t) > 0) {
                ar[pos+1] = ar[pos];
                pos --;
            }
            ar[pos+1] = t;
        }
        return ar;
    }

    /**
     *
     * @param ar
     */
    public void quickSort(T[] ar) {
        quickSortPartition(ar, 0, ar.length-1);
    }

    /**
     * The partition step of quickSort. Separates the array into elements
     * bigger than the pivot and elements greater than the pivot, then partitions
     * those two segments recursively. The pivot is always the element in the index
     * end.
     *
     * @param ar    T[]     The array to be partitioned and sorted.
     * @param begin int     The beginning index of the segment of the array to be partitioned.
     * @param end   int     The ending index of the segment of the array to be partitioned.
     */
    private void quickSortPartition(T[] ar, int begin, int end) {
        int length = end - begin + 1;
        if(length <= 1)
            return;

        T pivot = ar[end];
        int j = begin;
        for(int i = begin; i < end+1 ; i++) {
            if(ar[i].compareTo(pivot) < 0) {
                T temp = ar[j];
                ar[j] = ar[i];
                ar[i] = temp;
                j++;
            }
        }

        ar[end] = ar[j];
        ar[j] = pivot;

        quickSortPartition(ar, begin, j - 1);
        quickSortPartition(ar, j + 1, end);
    }

    /**
     * Prints the elements in the array in ascending order of index.
     *
     * @param ar T[] An array of objects extending comparable class.
     */
    public void printArray(T[] ar) {
        for(T t: ar)
            System.out.print(t.toString() + " ");
        System.out.println();
    }

    public String arrayToString(T[] ar) {
        StringBuilder stringBuilder = new StringBuilder();
        for(T t: ar)
            stringBuilder.append(t.toString() + " ");

        return stringBuilder.toString();
    }
}
