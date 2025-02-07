package orderStatistic;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrderStatisticsSelectionImplTest {

    @Test
    public void testEncontrarEstatisticaOrdem() {
        Integer[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        OrderStatisticsSelectionImpl<Integer> impl = new OrderStatisticsSelectionImpl<>();

        // Teste usando Integer.valueOf() para objetos Integer
        assertEquals(Integer.valueOf(1), impl.getOrderStatistics(array, 1));
        assertEquals(Integer.valueOf(5), impl.getOrderStatistics(array, 5));
        assertEquals(Integer.valueOf(5), impl.getOrderStatistics(array, 7));
        assertEquals(Integer.valueOf(9), impl.getOrderStatistics(array, 10));
        assertEquals(Integer.valueOf(3), impl.getOrderStatistics(array, 3));

        // Ou, se preferir usar tipos primitivos:
        // assertEquals(1, (int) impl.getOrderStatistics(array, 1));
        // assertEquals(5, (int) impl.getOrderStatistics(array, 5));
        // assertEquals(5, (int) impl.getOrderStatistics(array, 7));
        // assertEquals(9, (int) impl.getOrderStatistics(array, 10));
        // assertEquals(3, (int) impl.getOrderStatistics(array, 3));
    }
}
