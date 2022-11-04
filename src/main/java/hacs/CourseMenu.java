package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class CourseMenu extends JDialog
{
  Course theCourse;
  boolean bLogout=true;

  JRadioButton assignmentRadio = new JRadioButton();
  JComboBox assignmentComboBox = new JComboBox();
  JButton assignmentViewButton = new JButton();
  JButton assignmentAddButton = new JButton();
  JRadioButton optionRadio = new JRadioButton();
  JLabel assignmentContentLable = new JLabel();
  JComboBox optionCombo = new JComboBox();
  JButton optionViewButton = new JButton();
  JButton optionAddButton = new JButton();
  JButton buttonChangeCourse = new JButton();
  JButton buttonLogout = new JButton();

  public CourseMenu() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    setModal(true);
    setSize(503,294);
  }

  private void jbInit() {
    buttonChangeCourse.setText("ChangeCourse");
    buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
    buttonChangeCourse.addActionListener(this::buttonChangeCourseActionPerformed);
    this.getContentPane().setLayout(null);
    this.setTitle("");
    buttonLogout.setText("Logout");
    buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
    buttonLogout.addActionListener(this::buttonlogoutActionPerformed);
    this.getContentPane().add(buttonChangeCourse, null);
    this.getContentPane().add(buttonLogout, null);
  }

  /* when the add button is pressed, call add assignment
  function of facade, after that refresh window
  */

  /* when the add button is pressed, call ViewAssignment
  function of facade, after that refresh window
  */
  abstract void ShowAddButtons();
  abstract void ShowViewButtons();
  abstract void showRadios();
  abstract void showComboxes();
  void assignmentAddButtonActionPerformed(ActionEvent e) {
    Hacs.theFacade.AddAssignment(theCourse);
    refresh();
  }
  void assignmentViewButtonActionPerformed(ActionEvent e) {
    Assignment theAss = (Assignment) assignmentComboBox.getSelectedItem() ;
    Hacs.theFacade.ViewAssignment(theAss);
  }
  void refresh() {
    assignmentComboBox.removeAllItems() ;
    for (Assignment assignment : theCourse.assignmentList) {
      assignmentComboBox.addItem(assignment);
    }
  }

  void buttonChangeCourseActionPerformed(ActionEvent e) {
    bLogout = false;
    setVisible(false);
  }

  void buttonlogoutActionPerformed(ActionEvent e) {
    bLogout = true;
    setVisible(false);
  }
  boolean ifLogout()
  {
    return bLogout;
  }
}
