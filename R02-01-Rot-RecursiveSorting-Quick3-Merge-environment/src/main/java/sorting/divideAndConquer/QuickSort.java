package sorting.divideAndConquer;
import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex){
            return;
        }
        int i = partition(array, leftIndex, rightIndex);
        sort(array, leftIndex, i-1);
        sort(array, i+1, rightIndex);
    }

    private int partition(T[] array, int leftIndex, int rightIndex){
        int pivot = leftIndex;
        int i = ord(array, leftIndex, leftIndex+1, pivot, rightIndex);
        Util.swap(array, i, pivot);;
        return i;
    }

    private int ord(T[] array, int i, int j, int pivot, int rightIndex){
        if(j > rightIndex){
            return i;
        }
        if(array[j].compareTo(array[pivot]) < 0){
            i += 1;
            Util.swap(array, i, j);
            
        }
        i = ord(array, i, j+1, pivot, rightIndex);
        return i;
    }
}

