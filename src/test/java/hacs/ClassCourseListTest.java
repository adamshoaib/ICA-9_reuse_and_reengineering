package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassCourseListTest {

    @Test
    void findCourseByCourseName() {
        ClassCourseList courseList = new ClassCourseList();
        String name = "SER515";
        courseList.initializeFromFile();
        assertEquals(name, courseList.findCourseByCourseName(name).toString());
    }
}