package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearchImpl implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer result = null;
		int leftIdx = 0;
		int rightIdx = array.length-1;
		while(leftIdx <= rightIdx){
			int middle = (rightIdx + leftIdx)/2;
			if(array[middle] == x){
				result = array[middle];
				break;
			}
			if(array[middle] > x){
				rightIdx = middle-1;
			}
			else{
				result = array[middle];
				leftIdx = middle+1;
			}
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer result = null;
		int leftIdx = 0;
		int rightIdx = array.length-1;
		while(leftIdx <= rightIdx){
			int middle = (rightIdx + leftIdx)/2;
			if(array[middle] == x){
				result = array[middle];
				break;
			}
			if(array[middle] < x){
				leftIdx = middle+1;
			}
			else{
				result = array[middle];
				rightIdx = middle-1;
			}
		}
		return result;
	}

}
