import java.util.ArrayList;
import java.util.Arrays;

public class Teste {

    static MergeSortGeneric<Integer> msg = new MergeSortGeneric<Integer>();
    static Integer[] array = {0, 2, 2, 2, 3, 4, 5, 6, 7, 8};
    public static void main(String[] args) {
        msg.sort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
}
