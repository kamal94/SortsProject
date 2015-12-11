package sorts;

/**
 * Created by Kamal on 12/10/15.
 */
public class InsertionSort <T extends Comparable>{

    /**
     * Sorts the passed array using insertion sort.
     *
     * @param ar    T[] Array of elements t.
     */
    public T[] sort(T[] ar) {

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
}
