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
		Integer result = FloorBinarySearch(array, x, 0, array.length-1);
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer result = CeilBinarySearch(array, x, 0, array.length-1);
		return result;
	}

	private Integer FloorBinarySearch(Integer[] array, Integer target, int leftIdx, int rightIdx){
		Integer result = null;
		int middle = (rightIdx + leftIdx)/2;
		if(leftIdx >= rightIdx || array[middle] == target){
			result = array[middle];
		}
		else if(array[middle] > target){
			result = FloorBinarySearch(array, target, leftIdx, middle-1);
		}
		else{
			result = FloorBinarySearch(array, target, middle, rightIdx);
		}
		return result;
	}

	private Integer CeilBinarySearch(Integer[] array, Integer target, int leftIdx, int rightIdx){
		Integer result = null;
		int middle = (rightIdx + leftIdx)/2;
		if(leftIdx >= rightIdx || array[middle] == target){
			result = array[middle];
		}
		else if(array[middle] < target){
			result = CeilBinarySearch(array, target, middle+1, rightIdx);
		}
		else{
			result = CeilBinarySearch(array, target, leftIdx, middle);
		}
		return result;
	}
}
