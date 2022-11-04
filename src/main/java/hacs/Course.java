package hacs;

import java.util.*;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author mjfindler
 * @version 2.0 
 * Update to Java 8
 */

public class Course {
  String courseName;
  public ArrayList<Assignment> assignmentList = new ArrayList();
  int numOfAssignment;
  int courseLevel;


  public Course(String strCourse, int theLevel) {
    this.courseName = strCourse;

    //0 HighLeve presentation    1  LowLevel Experiment
    this.courseLevel = theLevel;
    this.numOfAssignment = 0;
  }
  
  public void addAssignment(Assignment newAss)
  {
    assignmentList.add(newAss);
  }
  
  public String toString()
  {
    return courseName;
  }
  
  void accept(NodeVisitor visitor)
  {
    visitor.visitCourse(this);
  }
}
