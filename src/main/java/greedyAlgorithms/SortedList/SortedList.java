package greedyAlgorithms.SortedList;

import java.util.ArrayList;
import java.util.Collections;

public class SortedList<E extends Comparable<E>> extends ArrayList<E> {
    
    private static final long serialVersionUID = 1L;

    public boolean add(final E e) {
        int insertionIndex = Collections.binarySearch(this, e);

        // < 0 if element is not in the list, see Collections.binarySearch
        if (insertionIndex < 0) {
            insertionIndex = -(insertionIndex + 1);
        } else {
            // Insertion index is index of existing element, to add new element
            // behind it increase index
            insertionIndex++;
        }

        super.add(insertionIndex, e);

        return true;
    }

    public void remove(final E e) {
        final int index = Collections.binarySearch(this, e);
        super.remove(index);
    }

}