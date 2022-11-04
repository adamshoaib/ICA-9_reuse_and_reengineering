package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import java.text.DateFormat;
import java.util.Date;

public class Assignment {

  protected String assignmentName;
  protected Date dueDate = new Date();
  protected String assignmentSpecifications;
  protected SolutionList theSolutionList = new SolutionList();
  protected Solution suggestSolution = new Solution();

  public Assignment() {
  }

  public void setDueDate(Date theDueDate){
    this.dueDate = theDueDate;
  }

  public void setAssignmentSpecifications(String theSpec){
    this.assignmentSpecifications = theSpec;
  }

  public boolean isOverDue() {
    Date today = new Date();
    return today.after(this.dueDate);
  }

  ////add the theSolution to the Solutionlist
  public void addSolution(Solution theSolution)
  {
    theSolutionList.add(theSolution);
  }

  public boolean submitSolution() {
    System.out.println("Dummy submitting");
    return true;
  }

  public SolutionList getSolutionList() {
    return theSolutionList;
  }

  public Solution getSugSolution(){
    return suggestSolution;
  }

  public SolutionIterator getSolutionIterator() {
    return new SolutionIterator(theSolutionList);
  }

  public String toString()
  {
    return assignmentName;
  }

  public String getDueDateString() {
    return DateFormat.getDateInstance(DateFormat.SHORT).format(dueDate);
  }

  public void accept(NodeVisitor visitor)
  {
    visitor.visitAssignment(this);
  }
}
