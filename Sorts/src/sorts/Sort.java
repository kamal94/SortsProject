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

    public void quickSort(T[] ar) {

    }
    public void quickSortPartition(T[] ar, int begin, int end) {
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
    private void printArray(T[] ar) {
        for(T t: ar)
            System.out.print(t.toString() + " ");
        System.out.println();
    }
}
