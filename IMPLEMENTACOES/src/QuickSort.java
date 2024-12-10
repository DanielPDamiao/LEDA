public class QuickSort {
    
    public void QuiSort(int[] array, int ini, int fim){
        if(ini == fim){
            return;
        }
        int i = partition(array, ini, fim, ini, ini+1);
        QuiSort(array, ini, i-1);
        QuiSort(array, i+1, fim);
    }

    private int partition(int[] array, int ini, int fim, int i, int j){
        int pivot = ini;
        if(j > fim){
            int troca = array[i];
            array[i] = array[pivot];
            array[pivot] = troca;
        }
        else if(array[j] >= array[pivot]){
            i = partition(array, ini, fim, i, j+1);
        }
        else{
            i = i+1;
            int troca = array[i];
            array[i] = array[j];
            array[j] = troca;
            i = partition(array, ini, fim, i, j+1);
        }
        return i;
    }
}
