package hacs;

import java.util.Iterator;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class SolutionIterator implements Iterator
{
  SolutionList solutionlist;

  ///  CurrentSolutionNumber: point to the location before the first element
  int currentSolutionNumber = -1;

  public SolutionIterator(SolutionList thesolutionList)
  {
    solutionlist = thesolutionList;
    moveToHead();
  }

  public int getCurrentSolutionNumber() {
    return currentSolutionNumber;
  }

  public void moveToHead() { ///  CurrentSolutionNumber: point to the location before the first element
    currentSolutionNumber =-1;
  }

  public boolean hasNext() {
    return currentSolutionNumber < solutionlist.size() - 1;
  }
  public Object next() {
    if (hasNext()) {
      currentSolutionNumber++;
      return solutionlist.get(currentSolutionNumber);
    } else {
      return null;
    }
  }

  /// get the next Solution that fits the Username;
  public Object next(String UserName) {
    Solution theSolution;
    theSolution = (Solution)next();
    while(theSolution != null) {
      if(UserName.compareTo(theSolution.theAuthor) == 0) {
        return theSolution;
      }
      theSolution = (Solution)next();
    }
    return null;
  }

  public void remove() {
    solutionlist.remove(currentSolutionNumber);
  }
}
