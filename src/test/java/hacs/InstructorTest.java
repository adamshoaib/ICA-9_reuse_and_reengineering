package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    @Test
    void createCourseMenu() {
        Instructor instructor = new Instructor();
        CourseMenu menu = instructor.createCourseMenu(new hacs.Course("SER 515", 0), 0);
        assertTrue(menu instanceof HighLevelCourseMenu);
    }

    @Test
    void showMenu() {
        Instructor instructor = new Instructor();
        assertEquals(1, instructor.type);
    }
}