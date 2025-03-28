package adt.bst.extended;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FloorCeilBSTImplTests {
    
    @Test
    public void genericTest(){
        FloorCeilBST fc = new FloorCeilBSTImpl();
        assertEquals(new Integer(52), fc.floor(new Integer[]{1, 12, 23, 9, 6, 52}, 53.7));
        assertEquals(new Integer(23), fc.floor(new Integer[]{1, 12, 23, 9, 6, 52}, 23.8));
        assertEquals(new Integer(12), fc.floor(new Integer[]{1, 12, 23, 9, 6, 52}, 12));
        assertEquals(null, fc.floor(new Integer[]{1, 12, 23, 9, 6, 52}, 0));

        assertEquals(new Integer(1), fc.ceil(new Integer[]{1, 12, 23, 9, 6, 52}, 1));
        assertEquals(new Integer(52), fc.ceil(new Integer[]{1, 12, 23, 9, 6, 52}, 23.8));
        assertEquals(new Integer(6), fc.ceil(new Integer[]{1, 12, 23, 9, 6, 52}, 5));
        assertEquals(new Integer(9), fc.ceil(new Integer[]{1, 12, 23, 9, 6, 52}, 8.4));
        assertEquals(null, fc.ceil(new Integer[]{1, 12, 23, 9, 6, 52}, 53));
    }
}
