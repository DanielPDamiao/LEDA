import java.util.Arrays;

public class Teste {

    static InsertionSort is = new InsertionSort();
    static int[] array = {8, 6, 2, 3, 1 ,7, 4, 9, 5, 0};
    public static void main(String[] args) {
        is.InsSort(array, 1);
        System.out.println(Arrays.toString(array));
    }
}
