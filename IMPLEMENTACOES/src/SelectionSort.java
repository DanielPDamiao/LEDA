public class SelectionSort {
    
    public void SecSort(int[] array, int tamanho){
        if(tamanho == 1){
            return;
        }
        int maiorInd = SecMaior(array, 0, tamanho-1);
        int troca = array[tamanho-1];
        array[tamanho-1] = array[maiorInd];
        array[maiorInd] = troca;
        SecSort(array, tamanho-1);
    }
    
    public int SecMaior(int[] array, int ini, int fim){
        int maiorInd = 0;
        if(ini == fim-1){
            maiorInd = (array[ini] < array[ini+1]) ? ini+1 : ini;
        }
        else{
            maiorInd = SecMaior(array, ini+1, fim);
            maiorInd = (array[ini] < array[maiorInd]) ? maiorInd : ini;
        }
        return maiorInd;
    }
}
