package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(canSort(array, leftIndex, rightIndex)){

			int maxValue = findMax(array, leftIndex, rightIndex);
			int minValue = findMin(array, leftIndex, rightIndex);
			int[] countArray = new int[(maxValue-minValue)+1];
			
			for(int i = leftIndex; i <= rightIndex; i++){
				countArray[array[i]-minValue] += 1;
			}

			for(int i = 1; i < countArray.length; i++){
				countArray[i] += countArray[i-1];
			}

			int[] compArray = new int[rightIndex-leftIndex+1];
			for(int i = leftIndex; i <= rightIndex; i++){
				compArray[i - leftIndex] = array[i];
			}

			for(int i = leftIndex; i <= rightIndex; i++){
				array[countArray[compArray[i - leftIndex] - minValue] + leftIndex -1] = compArray[i - leftIndex];
				countArray[compArray[i - leftIndex] - minValue] -= 1;
			}
		}
	}

	private int findMax(Integer[] array, int leftIndex, int rightIndex) {
		int maxValue = array[leftIndex];
		for(int i = leftIndex+1; i <= rightIndex; i++){
			if(array[i] > maxValue){
				maxValue = array[i];
			}
		}
		return maxValue;
	}

	private int findMin(Integer[] array, int leftIndex, int rightIndex){
		int minValue = array[leftIndex];
		for(int i = leftIndex+1; i <= rightIndex; i++){
			if(array[i] < minValue){
				minValue = array[i];
			}
		}
		return minValue;
	}

	private boolean canSort(Integer[] array, int leftIndex, int rightIndex){
		boolean canSort = true;
		if (leftIndex >= rightIndex) {
			canSort = false;
		}
		if (array.length <= 1) {
			canSort = false;
		}
		if (leftIndex < 0 || rightIndex > array.length-1){
			canSort = false;
		}
		return canSort;
	}

}
