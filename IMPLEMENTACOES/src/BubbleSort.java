public class BubbleSort {

    public void BubSort(int[] array, int tamanho) {
        if(tamanho == 1){
            return;
        }
        BubOrd(array, 0, tamanho-1);
        BubSort(array, tamanho-1);
    }

    private void BubOrd(int[] array, int ini, int fim){
        if(ini == fim){
            return;
        }
        if(array[ini] > array[ini+1]){
            int troca = array[ini];
            array[ini] = array[ini+1];
            array[ini+1] = troca;
        }
        BubOrd(array, ini+1, fim);
    }
}