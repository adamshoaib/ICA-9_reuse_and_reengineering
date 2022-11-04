package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionIteratorTest {

    @Test
    void moveToHead() {
        SolutionList list = new SolutionList();
        Solution sol = new Solution();
        list.add(sol);
        SolutionIterator itr = new SolutionIterator(list);
        itr.moveToHead();
        assertEquals(-1, itr.getCurrentSolutionNumber());
    }

    @Test
    void hasNext() {
        SolutionList list = new SolutionList();
        Solution sol = new Solution();
        list.add(sol);
        hacs.SolutionIterator itr = new hacs.SolutionIterator(list);
        assertTrue(itr.hasNext());
    }

    @Test
    void next() {
        SolutionList list = new SolutionList();
        Solution sol = new Solution();
        list.add(sol);
        hacs.SolutionIterator itr = new hacs.SolutionIterator(list);
        assertNotNull(itr.next());
    }

    @Test
    void testNext() {
        SolutionList list = new SolutionList();
        SolutionIterator itr = new SolutionIterator(list);
        assertNull(itr.next());
    }

    @Test
    void remove() {
        SolutionList list = new SolutionList();
        Solution sol = new Solution();
        list.add(sol);
        list.add(sol);
        list.add(sol);
        SolutionIterator itr = new SolutionIterator(list);
        itr.next();
        itr.next();
        itr.remove();
        assertEquals(1,itr.getCurrentSolutionNumber());
    }
}