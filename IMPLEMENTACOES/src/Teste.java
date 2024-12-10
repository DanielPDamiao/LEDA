import java.util.ArrayList;
import java.util.Arrays;

public class Teste {

    static MergeSort ms = new MergeSort();
    static int[] array = {8, 6, 2, 3, 1 ,7, 4, 9, 5, 0};
    public static void main(String[] args) {
        ArrayList<Integer> lista = ms.MerSort(array, 0, array.length-1);
        System.out.println(lista);
    }
}
