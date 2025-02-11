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
		int actEst = 0;
		int actInd = 0;
		while (actEst < k && k <= array.length) {
			if(actEst == 0){
				actInd = SelectMin(array);
			}
			else{
				actInd = SelectMin(array, actInd);
			}
			actEst = actEst+1;
		}
		return array[actInd];

	}

	private int SelectMin(T[] array){
		int minInd = 0;
		for(int i = minInd+1; i < array.length; i++){
			if(array[i].compareTo(array[minInd]) < 0){
				minInd = i;
			}
		}
		return minInd;
	}

	private int findMax(T[] array){
		int minInd = 0;
		for(int i = minInd+1; i < array.length; i++){
			if(array[i].compareTo(array[minInd]) >= 0){
				minInd = i;
			}
		}
		return minInd;
	}

	private int SelectMin(T[] array, int actInd){
		int minInd = findMax(array);
		int i = 0;
		while(i < array.length && (array[minInd].compareTo(array[actInd]) != 0 || minInd <= actInd)){
			if(array[i].compareTo(array[actInd]) == 0 && i > actInd){
				minInd = i;
			}
			else if(array[i].compareTo(array[minInd]) < 0 && array[i].compareTo(array[actInd]) > 0){
				minInd = i;
			}
			i = i+1;
		}
		return minInd;
	}

}

