package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import problems.FloorCeilBinarySearchImpl;

public class FloorCeilBinarySearchImplTest {
    
    FloorCeilBinarySearchImpl implementation = new FloorCeilBinarySearchImpl();

    @Test
    public void genericTest(){
        Integer[] lista = {2, 3, 4, 6, 8, 13, 15, 16, 20, 27};

        Integer result = implementation.ceil(lista, 9);
        assertEquals((Integer) 13, result);
    }
}
