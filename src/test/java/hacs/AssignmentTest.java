package hacs;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {

    @Test
    void setDueDate() {
        Assignment assignment = new Assignment();
        Date today = new Date();
        assignment.setDueDate(today);
        assertEquals(today, assignment.dueDate);
    }

    @Test
    void setAssignmentSpec() {
        Assignment assignment = new Assignment();
        String spec = "test";
        assignment.setAssignmentSpecifications(spec);
        assertEquals(spec, assignment.assignmentSpecifications);
    }

    @Test
    void isOverDue() {
        Assignment assignment = new Assignment();
        Date today = new Date();
        assignment.setDueDate(today);
        assertEquals(false, assignment.isOverDue());
    }

    @Test
    void addSolution() {
        Assignment assignment = new Assignment();
        Solution solution = new Solution();
        Solution solution1 = new Solution();
        int expected = 2;
        assignment.addSolution(solution);
        assignment.addSolution(solution1);
        assertEquals(expected, assignment.getSolutionList().size());
    }

    @Test
    void testAddSolution() {
        Assignment assignment = new Assignment();
        Solution solution = new Solution();
        Solution solution1 = new Solution();
        assignment.addSolution(solution);
        assignment.addSolution(solution1);
        assertTrue(assignment.theSolutionList.contains(solution));
        assertTrue(assignment.theSolutionList.contains(solution1));
    }

    @Test
    void submitSolution() {
        Assignment assignment = new Assignment();
        assertTrue(assignment.submitSolution());
    }

    @Test
    void getSolutionList() {
        Assignment assignment = new Assignment();
        Solution solution = new Solution();
        Solution solution1 = new Solution();
        int expected = 2;
        assignment.addSolution(solution);
        assignment.addSolution(solution1);
        SolutionList s = assignment.getSolutionList();
        assertEquals(expected, s.size());
    }

    @Test
    void getSugSolution() {
        Assignment assignment = new Assignment();
        assignment.getSugSolution();
    }

    @Test
    void testToString() {
        Assignment assignment = new Assignment();
        assignment.assignmentName = "test";
        assertEquals(assignment.toString(), "test");
    }

    @Test
    void getDueDateString() {
        Assignment assignment = new Assignment();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        assignment.dueDate = new Date();
        String dueDate = assignment.getDueDateString();
        String formattedDate =  dateFormat.format(new Date());
        assertEquals(dueDate, formattedDate);
    }
}