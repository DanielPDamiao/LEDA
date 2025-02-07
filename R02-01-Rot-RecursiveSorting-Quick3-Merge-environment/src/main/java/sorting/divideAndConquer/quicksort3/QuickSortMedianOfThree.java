package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex){
            return;
        }

        
		int meio = (leftIndex + rightIndex)/2;
		if(array[meio].compareTo(array[rightIndex]) > 0){
			Util.swap(array, rightIndex, meio);
		}		
		if(array[leftIndex].compareTo(array[rightIndex]) > 0){
			Util.swap(array, rightIndex, leftIndex);
		}
		if(array[leftIndex].compareTo(array[meio]) > 0){
			Util.swap(array, meio, leftIndex);
		}
		Util.swap(array, meio, rightIndex-1);
        
        int i = partition(array, leftIndex+1, rightIndex-1);
        sort(array, leftIndex, i-1);
        sort(array, i+1, rightIndex);
    }

    private int partition(T[] array, int leftIndex, int rightIndex){
        int pivot = rightIndex;
		int i = ord(array, rightIndex, rightIndex-1, pivot, leftIndex);
        Util.swap(array, i, pivot);;
        return i;
    }

    private int ord(T[] array, int i, int j, int pivot, int leftIndex){
        if(j < leftIndex){
            return i;
        }
        if(array[j].compareTo(array[pivot]) > 0){
            i -= 1;
			Util.swap(array, i, j);
        }
        i = ord(array, i, j-1, pivot, leftIndex);
        return i;
    }
}


