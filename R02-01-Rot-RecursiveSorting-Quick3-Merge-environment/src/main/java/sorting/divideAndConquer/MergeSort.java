package sorting.divideAndConquer;

import java.util.ArrayList;

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
	}

	private ArrayList<T> MerSort(T[] array, int ini, int fim){
        ArrayList<T> listaResp = new ArrayList<>();
        if(ini == fim){
             listaResp.add(array[ini]);
        }
        else{
            int medio = (ini + fim)/2;
            ArrayList<T> lista1 = (ArrayList<T>) MerSort(array, ini, medio).clone();
            ArrayList<T> lista2 = (ArrayList<T>) MerSort(array, medio+1, fim).clone();
            listaResp = (ArrayList<T>) MerSortOrd(listaResp, lista1, lista2).clone();
        }
        return listaResp;
    }

    private ArrayList<T> MerSortOrd(ArrayList<T> listaResp, ArrayList<T> lista1, ArrayList<T> lista2){
        if(lista1.size() == 0 && lista2.size() == 0){
            return listaResp;
        }
        else if(lista1.size() == 0){
            listaResp.add(lista2.get(0));
            lista2.remove(0);
        }
        else if(lista2.size() == 0){
            listaResp.add(lista1.get(0));
            lista1.remove(0);
        }
        else{
            if(lista1.get(0).compareTo(lista2.get(0)) <= 0){
                listaResp.add(lista1.get(0));
                lista1.remove(0);
            }
            else{
                listaResp.add(lista2.get(0));
                lista2.remove(0);
            }
        }
        listaResp = (ArrayList<T>) MerSortOrd(listaResp, lista1, lista2).clone();
        return listaResp;
    }
}
