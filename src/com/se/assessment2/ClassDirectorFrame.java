package com.se.assessment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author : Heting Ying
 * @description : Paint Class Director Frame
 */
public class ClassDirectorFrame extends JFrame
{
	/**
	 * Create Class Director Interface
	 *
	 * @param name window title name
	 */
	public ClassDirectorFrame(String name, Admin admin)
	{
		this.setName(name);
		this.setLayout(new FlowLayout());
		this.setResizable(true);
		this.setSize(600, 400);

		// Create add panels
		JPanel classAddPanel = new JPanel(new BorderLayout());
		JPanel teacherAddPanel = new JPanel(new BorderLayout());

		// Create and add tip label components
		classAddPanel.add(new JLabel("Manually Add Class"), BorderLayout.NORTH);
		teacherAddPanel.add(new JLabel("Manually Add Teacher"), BorderLayout.NORTH);

		// Create text input panel
		JPanel classInputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
		JPanel teacherInputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

		/*
		Create and add components of class input panel
		 */
		JLabel classJLabel = new JLabel("Class Name: ");
		JLabel collegeJLabel = new JLabel("College Name: ");

		JTextArea classJTextArea = new JTextArea();
		JTextArea collegeJTextArea = new JTextArea();

		classInputPanel.add(classJLabel);
		classInputPanel.add(classJTextArea);
		classInputPanel.add(collegeJLabel);
		classInputPanel.add(collegeJTextArea);

		/*
		Create and add components of teacher input panel
		 */
		JLabel teacherNameJLabel = new JLabel("Teacher Name: ");
		JLabel teacherIdJLabel = new JLabel("Teacher id: ");
		JLabel teacherMajorJLabel = new JLabel("Teacher Major: ");
		JLabel teacherRateJLabel = new JLabel("Teacher's Rate: ");

		JTextArea teacherNameJTextArea = new JTextArea();
		JTextArea teacherIdJTextArea = new JTextArea();
		JTextArea teacherMajorJTextArea = new JTextArea();
		JTextArea teacherRateJTextArea = new JTextArea();

		teacherInputPanel.add(teacherNameJLabel);
		teacherInputPanel.add(teacherNameJTextArea);
		teacherInputPanel.add(teacherIdJLabel);
		teacherInputPanel.add(teacherIdJTextArea);
		teacherInputPanel.add(teacherMajorJLabel);
		teacherInputPanel.add(teacherMajorJTextArea);
		teacherInputPanel.add(teacherRateJLabel);
		teacherInputPanel.add(teacherRateJTextArea);

		// Create Buttons
		JButton addClassBtn = new JButton("Add Class");
		JButton addTeacherBtn = new JButton("Add Teacher");
		JButton backBtn = new JButton("Back to Role Selection");

		// Add button listeners
		backBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ClassDirectorFrame.this.dispose();
				new RoleSelectionFrame("Role Selection Interface", admin);
			}
		});
		addClassBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ListOfClass classList = ListOfClass.getInstance();
				Class newClass = new Class(classJTextArea.getText(), collegeJTextArea.getText());
				classList.add(newClass);
				JOptionPane.showMessageDialog(null,
						"Class " + newClass.getClassName() + " Added!");
			}
		});
		addTeacherBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ListOfTeacher teacherList = ListOfTeacher.getInstance();
				Teacher newTeacher = new Teacher(
						teacherNameJTextArea.getText(),
						Integer.parseInt(teacherIdJTextArea.getText()),
						teacherMajorJTextArea.getText(),
						Integer.parseInt(teacherRateJTextArea.getText()));
				teacherList.add(newTeacher);
				JOptionPane.showMessageDialog(null,
						"Teacher " + newTeacher.getName() + " Added!");
			}
		});

		// Add components
		classAddPanel.add(classInputPanel, BorderLayout.CENTER);
		classAddPanel.add(addClassBtn, BorderLayout.SOUTH);
		teacherAddPanel.add(teacherInputPanel, BorderLayout.CENTER);
		teacherAddPanel.add(addTeacherBtn, BorderLayout.SOUTH);


		this.add(classAddPanel);
		this.add(teacherAddPanel);
		this.add(backBtn);

		// Set attributes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
}
