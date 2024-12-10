import java.util.ArrayList;

public class MergeSort {
    
    public ArrayList<Integer> MerSort(int[] array, int ini, int fim){
        ArrayList<Integer> lista = new ArrayList<>();
        if(ini == fim){
             lista.add(array[ini]);
        }
        else{
            int medio = (ini + fim)/2;
            ArrayList<Integer> lista1 = (ArrayList<Integer>) MerSort(array, ini, medio).clone();
            ArrayList<Integer> lista2 = (ArrayList<Integer>) MerSort(array, medio+1, fim).clone();
            lista = (ArrayList<Integer>) MerSortOrd(lista1, lista2).clone();
        }
        return lista;
    }

    
}
