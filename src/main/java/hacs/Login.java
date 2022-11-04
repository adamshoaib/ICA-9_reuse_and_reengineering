package hacs;

import javax.swing.*;

import hacs.UserInfoItem.USER_TYPE;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Java 8
 */

public class Login extends JDialog {

	boolean m_bExit = false;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton loginButton = new JButton();
	JButton buttonExit = new JButton();
	JTextField userNameText = new JTextField();
	JPasswordField passwordText = new JPasswordField();
	JRadioButton studentRadio = new JRadioButton();
	JRadioButton instructorRadio = new JRadioButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	////// Attributes Added By me
	private String userBox = null;
	private USER_TYPE userType = USER_TYPE.Student; // default to Student

	public Login() {
		try {
			jbInit();
			setSize(300, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(31, 212, 85, 28));
		loginButton.addActionListener(this::loginButtonActionPerformed);
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
		buttonExit.addActionListener(this::buttonExitActionPerformed);
		userNameText.setBounds(new Rectangle(119, 52, 144, 22));
		passwordText.setBounds(new Rectangle(118, 119, 147, 22));
		studentRadio.setSelected(true);
		studentRadio.setText("Student");
		studentRadio.setBounds(new Rectangle(37, 164, 103, 26));
		instructorRadio.setText("Instructor");
		instructorRadio.setBounds(new Rectangle(177, 162, 103, 26));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(userNameText, null);
		this.getContentPane().add(passwordText, null);
		this.getContentPane().add(studentRadio, null);
		this.getContentPane().add(instructorRadio, null);
		buttonGroup1.add(studentRadio);
		buttonGroup1.add(instructorRadio);
	}

	void loginButtonActionPerformed(ActionEvent e) {
		BufferedReader file;
		m_bExit = false;
		System.out.println("login clicked");
		try {
			if (studentRadio.isSelected()) { //// student
				userType = USER_TYPE.Student; /// 0 for student
				file = new BufferedReader(new FileReader("/Users/adamshoaibk/IdeaProjects/hacs/src/main/java/hacs/StuInfo.txt"));
			} else { // instructor
				userType = USER_TYPE.Instructor; // 1 for instructor
				file = new BufferedReader(new FileReader("/Users/adamshoaibk/IdeaProjects/hacs/src/main/java/hacs/InsInfor.txt"));
			}
			userBox = userNameText.getText();
			String PasswordBox = new String(passwordText.getPassword());
			String LoginName = null;
			String aline, UserName , Password ;
			while ((aline = file.readLine()) != null) {
				UserName = GetUserName(aline);
				Password = GetPassword(aline);
				if (UserName.compareTo(userBox) == 0 && Password.compareTo(PasswordBox) == 0)
					LoginName = UserName;
			}
			if (LoginName != null) {
				this.setVisible(false);
			}
		} catch (Exception ee) {
			System.out.println(ee);
			ee.printStackTrace();
		}

	}

	/*
	 * get the user name from aline UserName:Password
	 */
	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the password from aline UserName:Password
	 */
	private String GetPassword(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1);
	}

	/* after login get the UserName of the login interface */
	public String GetUserName() {
		return userBox;
	}

	/* after login get the userType of the login interface */
	public USER_TYPE GetUserType() {
		return userType;
	}

	public boolean isExit() {
		return m_bExit;
	}

	void buttonExitActionPerformed(ActionEvent e) {
		m_bExit = true;
		setVisible(false);
	}
}

