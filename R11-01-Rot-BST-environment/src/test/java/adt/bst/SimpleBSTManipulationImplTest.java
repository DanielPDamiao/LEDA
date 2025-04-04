package adt.bst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class SimpleBSTManipulationImplTest {
    
    @Test
    public void genericTest(){
        SimpleBSTManipulationImpl<Integer> manipulation = new SimpleBSTManipulationImpl<>();
        BSTImpl<Integer> bst = new BSTImpl<>();

        Integer[] list = new Integer[]{20, 17, 40, 16, 18, 21, 44, 32, 30, 34, 42, 48};
        for(Integer n : list){
            bst.insert(n);
        }
        int order = 5;
        Integer res = manipulation.orderStatistic(bst, order);
        Arrays.sort(list); // {16, 17, 18, 20, 21, 30, 32, 34, 40, 42, 44, 48}
        assertEquals(res, list[order-1]);

        res = manipulation.orderStatistic(bst, 48);
        assertEquals(null, res);
    }
}
