package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		while(rightIndex >= leftIndex){
			ordenaBi(array, leftIndex, rightIndex);
			rightIndex -= 1;
			leftIndex += 1;
		}
	}

	private void ordenaBi(T[] array, int leftIndex, int rightIndex) {
		for(int indAtual = 0; indAtual < rightIndex; indAtual++){
			if(array[indAtual].compareTo(array[indAtual+1]) > 0){
				Util.swap(array, indAtual, indAtual+1);
			}
			if(array[(rightIndex-indAtual)].compareTo(array[(rightIndex-indAtual)-1]) < 0){
				Util.swap(array, (rightIndex-indAtual), (rightIndex-indAtual)-1);
			}
		}
	}
}
