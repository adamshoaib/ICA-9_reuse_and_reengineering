package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

abstract public class Person {
	int type = 0; // type=0 : student, type=1 instructor
	String userName;
	ClassCourseList courseList;
	CourseMenu theCourseMenu;
	Course currentCourse;

	public Person() {
		courseList = new ClassCourseList();
	}

	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	public void showAddButton() {
		theCourseMenu.ShowAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.ShowViewButtons();
	}

	public void showComboxes() {
		theCourseMenu.showComboxes();
	}

	public void showRadios() {
		theCourseMenu.showRadios();
	}

	// show course Menu
	public void show() {
		theCourseMenu.setVisible(true);
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	// show the assignment list
	public boolean showMenu() {
		// create a iterator for the assignment list
		// Iterator theIter=new ListIterator(CurrentCourse.AssList );
		Iterator<Assignment> iterator = currentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = currentCourse;
		Assignment theAssignment;
		while (iterator.hasNext()) {
			theAssignment = iterator.next();
			theCourseMenu.assignmentComboBox.addItem(theAssignment);
		}
		return false;
	}

	// add course to the courseList
	public void addCourse(Course theCourse) {
		courseList.add(theCourse);
	}
}
