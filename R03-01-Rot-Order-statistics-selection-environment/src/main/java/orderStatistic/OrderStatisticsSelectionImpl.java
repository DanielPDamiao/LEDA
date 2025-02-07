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
		int elementIndex = selectionOrderStatistics(array, k);
		return array[elementIndex];
	}

	private int selectionOrderStatistics(T[] array, int target){
		int actualIdx = -1;
		int maxValueIdx = findMax(array);
		
		for(int i = target; i > 0; i--){
			
			int nextMinIdx = findNextEqual(array, actualIdx);
			if(nextMinIdx == -1){
				actualIdx = findMin(array, actualIdx, maxValueIdx);
			}
			else{
				actualIdx = nextMinIdx;
			}
		}
		return actualIdx;
	}

	private int findMax(T[] array){
		int newMaxIdx = 0;
		for(int i = 1; i < array.length; i++){
			if(array[i].compareTo(array[newMaxIdx]) >= 0){
				newMaxIdx = i;
			}
		}
		return newMaxIdx;
	}

	private int findMin(T[] array, int actualIdx, int maxValueIdx){
		int newMinIdx = maxValueIdx;
		if(actualIdx == -1){
			for(int i = array.length-1; i >= 0; i--){
				if( array[i].compareTo(array[newMinIdx]) <= 0 ){
					newMinIdx = i;
				}
			}
		}
		else{
			for(int i = array.length-1; i >= 0; i--){
				if( array[i].compareTo(array[newMinIdx]) <=0 && array[i].compareTo(array[actualIdx]) > 0 ){
					newMinIdx = i;
				}
			}
		}
		return newMinIdx;
	}

	private int findNextEqual(T[] array, int actualIdx){
		int nextEqual = -1;
		if(actualIdx != -1){
			for(int i = actualIdx+1; i < array.length; i++){
				if(array[i].compareTo(array[actualIdx]) == 0){
					nextEqual = i;
					break;
				}
			}
		}
		return nextEqual;
	}
}

