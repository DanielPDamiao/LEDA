import java.util.ArrayList;
import java.util.Arrays;

public class Teste {

    static LastOcurrenceSearch los = new LastOcurrenceSearch();
    static int[] array = {0, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9};
    public static void main(String[] args) {
        System.out.println(los.search(array, 2));
    }
}
