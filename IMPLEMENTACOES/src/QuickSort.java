public class QuickSort {
    
    public void QuiSort(int[] array, int ini, int fim){
        if(ini >= fim){
            return;
        }
        int i = partition(array, ini, fim);
        QuiSort(array, ini, i-1);
        QuiSort(array, i+1, fim);
    }

    private int partition(int[] array, int ini, int fim){
        int pivot = ini;
        int i = ord(array, ini, ini+1, pivot);
        int troca = array[i];
        array[i] = array[pivot];
        array[pivot] = troca;
        return i;
    }

    private int ord(int[] array, int i, int j, int pivot){
        if(j == array.length){
            return i;
        }
        if(array[j] < array[pivot]){
            i += 1;
            int troca = array[i];
            array[i] = array[j];
            array[j] = troca;
            
        }
        i = ord(array, i, j+1, pivot);
        return i;
    }
}
