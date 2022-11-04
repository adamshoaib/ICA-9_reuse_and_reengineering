package hacs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {

    @Test
    void hasNext() {
        ArrayList<Object> al = new ArrayList<>();
        al.add(1);
        ListIterator listIterator = new ListIterator(al);
        assertTrue(listIterator.hasNext());
    }

    @Test
    void next() {
        ArrayList<Object> testList = new ArrayList<>();
        testList.add(1);
        ListIterator listIterator = new ListIterator(testList);
        assertEquals(1,listIterator.next());
    }

    @Test
    void remove() {
        ArrayList<Object> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        ListIterator listIterator = new ListIterator(testList);
        listIterator.next();
        listIterator.remove();
        assertFalse(listIterator.hasNext());
    }
}