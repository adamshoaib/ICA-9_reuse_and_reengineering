package hacs;

import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Jave 8
 */

public class Facade {
	private Course theSelectedCourse = null;
	private int nCourseLevel = 0;
	ClassCourseList theCourseList;
	Person thePerson;

	public Facade() {
		System.out.println("Inside Facade Class");
	}

	static public boolean Login(UserInfoItem userinfoItem) {
		System.out.println("I am here login fn start");
		Login login = new Login();
		System.out.println("I am here login fn 1");
		login.setModal(true);
		System.out.println("I am here login fn 2");
		login.setVisible(true);
		System.out.println("I am here login fn 3");
		userinfoItem.strUserName = login.GetUserName();
		System.out.println("I am here login fn 4");
		userinfoItem.userType = login.GetUserType();
		System.out.println("I am here login fn end");
		return login.isExit();
	}

	/////////////////////////
	//functions for CourseMenu
	/*
	 * When click the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */

	void AddAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0) {
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	/*
	 * When click the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 */
	void ViewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0) { /// student
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

	//functions for InstructorAssignmentMenu
	/*
	 * this function will grade the give Solution: theSolution this function calls
	 */

	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.ShowMenu(theSolution);
	}

	void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}
	////////////////////

	//functions for StudentAssignmentMenu
	void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	void Remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder();
	}

	void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) { /// student
			thePerson = new Student();
		} else { /// instructor
			thePerson = new Instructor();
		}
		thePerson.userName = userinfoitem.strUserName;
	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile();
	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("/Users/adamshoaibk/IdeaProjects/hacs/src/main/java/hacs/UserCourse.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) {
				strUserName = GetUserName(aline);
				strCourseName = GetCourseName(aline);
				if (strUserName.compareTo(thePerson.userName) == 0) { /// the UserName mateches
					theSelectedCourse = FindCourseByCourseName(strCourseName);
					if (theSelectedCourse != null) { /// Find the Course in the CourseList--->attach
						thePerson.addCourse(theSelectedCourse);
					}
				}
			}
		} catch (Exception ee) {
			System.out.println("Exception occured while reading file :"+ee);
		}
	}

	/*
	 * get the user name from aline UserName:CourseName
	 */
	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the CourseName from aline UserName:CourseName
	 */
	private String GetCourseName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1);
	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelecteCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean SelectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelectedCourse = theDlg.ShowDlg(thePerson.courseList);
		thePerson.currentCourse = theSelectedCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean CourseOperation() {
		thePerson.createCourseMenu(theSelectedCourse, nCourseLevel);
		return thePerson.showMenu();//// 0: logout 1 select an other course
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Course FindCourseByCourseName(String strCourseName) {
		CourseIterator Iterator = new CourseIterator(theCourseList);
		return (Course) Iterator.next(strCourseName);
	}
}

