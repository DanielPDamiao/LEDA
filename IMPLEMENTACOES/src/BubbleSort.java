public class BubbleSort {
    
    public BubbleSort() {
    }

    public void BubSort(int[] array, int ini, int fim) {
        if(ini == fim){
            return;
        }
        BubOrd(array, ini, fim);
        BubSort(array, ini, fim-1);
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