package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {

    @Test
    void reportSolutions() {
        Facade facade = new Facade();
        Assignment assignment = new Assignment();
        Solution solution = new Solution();
        assignment.theSolutionList.add(solution);
        facade.reportSolutions(assignment);
        assertTrue(assignment.theSolutionList.get(0).reported);
    }

    @Test
    void submitSolution() {
        Facade facade = new Facade();
        int expected = 2;
        Assignment theAssignment = new Assignment();
        Solution solution = new Solution();
        Solution solution2 = new Solution();
        facade.submitSolution(theAssignment, solution);
        facade.submitSolution(theAssignment, solution2);
        int size = theAssignment.getSolutionList().size();
        assertEquals(expected, size);
    }

    @Test
    void createUser() {
        Facade facade = new Facade();
        UserInfoItem user = new UserInfoItem();
        user.userType = UserInfoItem.USER_TYPE.Student;
        facade.createUser(user);
        assertTrue(facade.thePerson instanceof hacs.Student);
    }

    @Test
    void createCourseList() {
        Facade facade = new Facade();
        facade.createCourseList();
        assertEquals(3, facade.theCourseList.size());
    }

    @Test
    void attachCourseToUser() {
        Facade facade = new Facade();
        facade.thePerson = new Student();
        facade.thePerson.userName = "pepe";
        facade.attachCourseToUser();
    }

    @Test
    void GradeSolution() {
        Facade facade = new Facade();
        Solution solution = new Solution();
        facade.gradeSolution();
    }
}
