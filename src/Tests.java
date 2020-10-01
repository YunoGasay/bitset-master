import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class Tests {
    BitSetSimple bitSetSimple1 = new BitSetSimple(15);
    BitSetSimple bitSetSimple2 = new BitSetSimple(15);

    @Test
    public void addTest() {
        bitSetSimple1.add(new int[] {1,2,3,5,7,20});  //20 игнорируется, т.к. больше размера множества
        assertEquals("1 2 3 5 7", bitSetSimple1.getNumbers());
    }

    @Test
    public void deleteTest() {
        bitSetSimple1.add(new int[] {1,2,3,5,7});
        bitSetSimple1.delete(1);
        assertEquals("2 3 5 7", bitSetSimple1.getNumbers());
        bitSetSimple1.delete(new int[] {2,3});
        assertEquals("5 7", bitSetSimple1.getNumbers());
    }

    @Test
    public void crossingTest() {  //пересечение
        bitSetSimple1.add(new int[] {1,2,3,5,7});
        bitSetSimple2.add(new int[] {4,9,6,5,7});
        BitSetSimple resultBitSetSimple = bitSetSimple1.crossing(bitSetSimple2); // пересечение

        assertEquals("5 7",resultBitSetSimple.getNumbers());
    }

    @Test
    public void unionTest() {  //объединение
        bitSetSimple1.add(new int[] {1,2,3,5,7});
        bitSetSimple2.add(new int[] {4,9,6,5,7});
        BitSetSimple resultBitSetSimple = bitSetSimple1.union(bitSetSimple2); // объединение

        assertEquals("1 2 3 4 5 6 7 9",resultBitSetSimple.getNumbers());
    }

    @Test
    public void complementTest() {  //дополнение
        bitSetSimple1.add(new int[] {1,2,3,5,7});
        bitSetSimple2.add(new int[] {4,9,6,5,7});
        BitSetSimple resultBitSetSimple = bitSetSimple1.complement(bitSetSimple2); // дополнение

        assertEquals("4 6 9",resultBitSetSimple.getNumbers());
    }

    @Test
    public void isExistTest() {
        bitSetSimple1.add(new int[] {1,2,3,5,7});
        bitSetSimple2.add(new int[] {4,9,6,5,7});

        assertFalse(bitSetSimple1.isExist(4));
        assertTrue(bitSetSimple2.isExist(4));

    }

}
