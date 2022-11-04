package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createCourseMenu() {
        Student student = new Student();
        Course course = new Course("SER501", 1);
        CourseMenu menu = student.createCourseMenu(course, 0);
        assertTrue(menu instanceof HighLevelCourseMenu);
    }
}