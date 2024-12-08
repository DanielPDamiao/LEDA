import java.util.Arrays;

public class Teste {

    static SelectionSort ss = new SelectionSort();
    static int[] array = {8, 6, 2, 3, 1 ,7, 4, 9, 5, 0};
    public static void main(String[] args) {
        ss.SecSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
