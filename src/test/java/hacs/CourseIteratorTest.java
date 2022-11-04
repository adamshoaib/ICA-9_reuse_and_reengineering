package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseIteratorTest {

    @Test
    void hasNext() {
        ClassCourseList courseList = new ClassCourseList();
        Course course = new hacs.Course("SER501", 1);
        courseList.add(course);
        CourseIterator courseIterator = new CourseIterator(courseList);
        assertTrue(courseIterator.hasNext());
    }

    @Test
    void next() {
        ClassCourseList courseList = new ClassCourseList();
        Course course = new hacs.Course("SER501", 1);
        courseList.add(course);
        hacs.CourseIterator courseIterator = new hacs.CourseIterator(courseList);
        assertTrue(courseIterator.hasNext());
    }

    @Test
    void remove() {
        ClassCourseList courseList = new ClassCourseList();
        Course course = new hacs.Course("SER501", 1);
        Course course2 = new hacs.Course("SER531", 1);
        courseList.add(course);
        courseList.add(course2);
        CourseIterator courseIterator = new CourseIterator(courseList);
        courseIterator.next();
        courseIterator.remove();
        assertFalse(courseIterator.hasNext());
    }

    @Test
    void testNext() {
        ClassCourseList courseList = new ClassCourseList();
        Course course = new hacs.Course("SER501", 1);
        Course course2 = new hacs.Course("SER531", 1);
        courseList.add(course);
        courseList.add(course2);
        CourseIterator courseIterator = new CourseIterator(courseList);
        assertEquals(course, courseIterator.next());
    }
}