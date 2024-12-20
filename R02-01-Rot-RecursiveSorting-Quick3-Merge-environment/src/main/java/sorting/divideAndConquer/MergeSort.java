package sorting.divideAndConquer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
        T[] listaResp = MerSort(array, leftIndex, rightIndex);
        for(int i = 0; i < array.length; i++){ array[i] = listaResp[i];}
	}

	private T[] MerSort(T[] array, int leftIndex, int rightIndex){
        if(leftIndex >= rightIndex){
            T[] listaResp = Arrays.copyOfRange(array, leftIndex, rightIndex+1);
            return listaResp;
        }
        else{
            int medio = (leftIndex + rightIndex)/2;
            T[] leftList = MerSort(array, leftIndex, medio);
            T[] rightList = MerSort(array, medio+1, rightIndex);

            T[] listaResp = Arrays.copyOfRange(array, leftIndex, rightIndex+1);
            listaResp = MerSortOrd(listaResp, leftList, rightList, 0, 0 ,0);
            return listaResp;
        }
    }

    private T[] MerSortOrd(T[] listaResp, T[] leftList, T[] rightList, int n, int i, int j){
        if(i >= leftList.length && j >= rightList.length){
            return listaResp;
        }
        else if(i >= leftList.length){
            listaResp[n] = rightList[j];
            MerSortOrd(listaResp, leftList, rightList, n+1, i, j+1);
        }
        else if(j >= rightList.length){
            listaResp[n] = leftList[i];
            MerSortOrd(listaResp, leftList, rightList, n+1, i+1, j);
        }
        else{
            if(leftList[i].compareTo(rightList[j]) <= 0){
                listaResp[n] = leftList[i];
                MerSortOrd(listaResp, leftList, rightList, n+1, i+1, j);
            }
            else{
                listaResp[n] = rightList[j];
                MerSortOrd(listaResp, leftList, rightList, n+1, i, j+1);
            }
        }
        return listaResp;
    }
}
