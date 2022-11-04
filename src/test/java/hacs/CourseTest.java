package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void addAssignment() {
        Course course = new Course("CSE505", 1);
        Assignment assignment = new Assignment();
        course.addAssignment(assignment);
        assertTrue(course.assignmentList.contains(assignment));
    }

    @Test
    void toStringTest() {
        Course course = new Course("test", 1);
        assertEquals("test", course.toString());
    }
}