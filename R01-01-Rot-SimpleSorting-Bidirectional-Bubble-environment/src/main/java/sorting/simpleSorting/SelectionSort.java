package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int maiorInd;
		while (rightIndex > leftIndex) {
			maiorInd = pegaMaior(array, leftIndex, rightIndex);
			Util.swap(array, maiorInd, rightIndex);
			rightIndex -= 1;
		}
	}

	private int pegaMaior(T[] array, int leftIndex, int rightIndex) {
		int maiorInd = leftIndex;
		for(int indAtual = leftIndex+1; indAtual <= rightIndex; indAtual++){
			if(array[indAtual].compareTo(array[maiorInd]) > 0){
				maiorInd = indAtual;
			}
		}
		return maiorInd;
	}
}
