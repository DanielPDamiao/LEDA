package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N 
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta classe.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		
		int leftIndex = 0;
		int rightIndex = array.length -1;

		int elementIndex = selectionOrderStatistics(array, leftIndex, rightIndex, k);
		return array[elementIndex];
	}

	private int selectionOrderStatistics(T[] array, int leftIndex, int rightIndex, int target){
		int actualMinIdx = -1;

		for(int i = target; i > 0; i--){
			actualMinIdx = findMin(array, leftIndex, rightIndex, actualMinIdx);
		}

		return actualMinIdx;
	}

	private int findMin(T[] array, int leftIndex, int rightIndex, int actualMinIdx){
		int newMinIdx = leftIndex;
		
		if(actualMinIdx == -1){
			for(int i = leftIndex+1; i <= rightIndex; i++){
				if( array[i].compareTo(array[newMinIdx]) < 0 ){
					newMinIdx = i;
				}
			}
		} 
		else {
			for(int i = leftIndex+1; i <= rightIndex; i++){
				if( array[i].compareTo(array[actualMinIdx]) == 0 && i != actualMinIdx){
					newMinIdx = i;
					break;
				}
				else if( array[i].compareTo(array[newMinIdx]) < 0 && array[i].compareTo(array[actualMinIdx]) > 0) {
					newMinIdx = i;
				}
			}
		}
		
		return newMinIdx;
	}
}
