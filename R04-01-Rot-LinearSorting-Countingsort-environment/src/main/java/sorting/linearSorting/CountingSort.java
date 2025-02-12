package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(rightIndex < leftIndex || array.length <= 0){
			System.exit(0);
		}

		int maxValue = findMax(array, leftIndex, rightIndex);
		int[] countArray = new int[maxValue+1];
		
		for(int i = leftIndex; i <= rightIndex; i++){
			countArray[array[i]] += 1;
		}

		for(int i = 1; i < countArray.length; i++){
			countArray[i] += countArray[i-1];
		}

		int[] compArray = new int[rightIndex-leftIndex+1];
		for(int i = leftIndex; i <= rightIndex; i++){
			compArray[i - leftIndex] = array[i];
		}

		for(int i = leftIndex; i <= rightIndex; i++){
			array[countArray[compArray[i - leftIndex]] + leftIndex -1] = compArray[i - leftIndex];
			countArray[compArray[i-leftIndex]] -= 1;
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

}
