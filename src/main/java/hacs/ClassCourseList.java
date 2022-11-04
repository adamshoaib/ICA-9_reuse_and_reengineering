package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

	void initializeFromFile() {
		try {
			BufferedReader file;
			String strCourseName;
			file = new BufferedReader(new FileReader("/Users/adamshoaibk/IdeaProjects/hacs/src/main/java/hacs/CourseInfo.txt"));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				add(theCourse);
			}
		} catch (Exception ee) {
			System.out.println("Exception Occured while reading File"+ee);
		}
	}

	Course findCourseByCourseName(String CourseName) {
		for (Course course : this) {
			Course theCourse;
			theCourse = course;
			if (theCourse.courseName.compareTo(CourseName) == 0)
				return theCourse;
		}
		return null;
	}
}
