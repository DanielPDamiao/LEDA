package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int indAtual = leftIndex+1;
		while(indAtual <= rightIndex){
			ordena(array, leftIndex, indAtual);
			indAtual += 1;
		}
	}

	private void ordena(T[] array, int leftIndex, int rightIndex){
		while(array[rightIndex-1].compareTo(array[rightIndex]) > 0){
			Util.swap(array, rightIndex-1, rightIndex);
			rightIndex -= 1;
			if(rightIndex == leftIndex) { break; }
		}
	}
}

