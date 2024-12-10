public class InsertionSort {

    public void InsSort(int[] array, int atualInd){
        if(atualInd == array.length){
            return;
        }
        InsSortOrd(array, atualInd);
        InsSort(array, atualInd+1);
        
    }

    public void InsSortOrd(int[] array, int atualInd){
        if(atualInd == 0){
            return;
        }
        if(array[atualInd] < array[atualInd-1]){
            int troca = array[atualInd];
            array[atualInd] = array[atualInd-1];
            array[atualInd-1] = troca;
            InsSortOrd(array, atualInd-1);
        }
    }
    
}
