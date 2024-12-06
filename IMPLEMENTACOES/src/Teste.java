import java.util.Arrays;

public class Teste {

    static BubbleSort bs = new BubbleSort();
    static int[] array = {6, 2, 3, 1 ,7, 4, 9, 5, 10, 0};
    public static void main(String[] args) {
        bs.BubSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
