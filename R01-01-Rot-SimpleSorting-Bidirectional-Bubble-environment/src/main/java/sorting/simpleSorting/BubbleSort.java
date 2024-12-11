package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		while(rightIndex > leftIndex){
			ordena(array, leftIndex, rightIndex);
			rightIndex -= 1;
		}
	}

	private void ordena(T[] array, int leftIndex, int rightIndex) {
		for(int indAtual = 0; indAtual < rightIndex; indAtual++){
			if(array[indAtual].compareTo(array[indAtual+1]) > 0){
				Util.swap(array, indAtual, indAtual+1);
			}
		}
	}
}
