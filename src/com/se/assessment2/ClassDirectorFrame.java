package com.se.assessment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

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
		this.setTitle(name);
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

		JTextField classJTextArea = new JTextField();
		JTextField collegeJTextArea = new JTextField();

		classInputPanel.add(classJLabel);
		classInputPanel.add(classJTextArea);
		classInputPanel.add(collegeJLabel);
		classInputPanel.add(collegeJTextArea);

		/*
		Create and add components of teacher input panel
		 */
		JLabel teacherNameJLabel = new JLabel("Teacher Name: ");
		JLabel teacherIdJLabel = new JLabel("Teacher id(Numbers Only): ");
		JLabel teacherMajorJLabel = new JLabel("Teacher Major: ");
		JLabel teacherRateJLabel = new JLabel("Teacher's Rate(Numbers Only): ");

		JTextField teacherNameJTextArea = new JTextField();
		JTextField teacherIdJTextArea = new JTextField();
		JTextField teacherMajorJTextArea = new JTextField();
		JTextField teacherRateJTextArea = new JTextField();

		/*
		 Set id and rate input area only allow integer
		 */
		teacherIdJTextArea.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				if (!(e.getKeyChar() >= KeyEvent.VK_0 && e.getKeyChar() <= KeyEvent.VK_9))
				{
					e.consume();
				}
			}
		});
		teacherRateJTextArea.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				if (!(e.getKeyChar() >= KeyEvent.VK_0 && e.getKeyChar() <= KeyEvent.VK_9))
				{
					e.consume();
				}
			}
		});

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
				// If class input data exists
				if (!classJTextArea.getText().equals("") && !collegeJTextArea.getText().equals(""))
				{
					Class newClass = new Class(classJTextArea.getText(), collegeJTextArea.getText());
					classList.add(newClass);
					JOptionPane.showMessageDialog(null,
							"Class " + newClass.getClassName() + " Added!");
					// Reset text input area
					classJTextArea.setText("");
					collegeJTextArea.setText("");
				} else
				{
					JOptionPane.showMessageDialog(null, "Please Add Class Details!");
				}
			}
		});
		addTeacherBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ListOfTeacher teacherList = ListOfTeacher.getInstance();
				// If teacher input data exists
				if (!teacherNameJTextArea.getText().equals("")
						&& !teacherIdJTextArea.getText().equals("")
						&& !teacherMajorJTextArea.getText().equals("")
						&& !teacherRateJTextArea.getText().equals(""))
				{
					Teacher newTeacher = new Teacher(
							teacherNameJTextArea.getText(),
							Integer.parseInt(teacherIdJTextArea.getText()),
							teacherMajorJTextArea.getText(),
							Integer.parseInt(teacherRateJTextArea.getText()));
					teacherList.add(newTeacher);
					JOptionPane.showMessageDialog(null,
							"Teacher " + newTeacher.getName() + " Added!");
					// Reset text input area
					teacherNameJTextArea.setText("");
					teacherIdJTextArea.setText("");
					teacherMajorJTextArea.setText("");
					teacherRateJTextArea.setText("");
				} else
				{
					JOptionPane.showMessageDialog(null, "Please Add Teacher Details!");
				}
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
