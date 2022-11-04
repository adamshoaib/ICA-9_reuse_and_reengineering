package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testToString() {
        Solution solution = new Solution();
        assertEquals("   Grade=0  not reported",solution.toString() );
    }

    @Test
    void getGradeString() {
        Solution solution = new Solution();
        assertEquals("-1", solution.getGradeString());
    }

    @Test
    void getGradeInt() {
        Solution solution = new Solution();
        assertEquals(0, solution.getGradeInt());
    }

    @Test
    void setReported() {
        Solution solution = new Solution();
        solution.setReported(true);
        assertTrue(solution.isReported());
    }

    @Test
    void isReported() {
        Solution solution = new Solution();
        solution.setReported(false);
        assertFalse(solution.isReported());
    }
}