package com.se.assessment2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

/**
 * @author : Heting Ying
 * @description : Main class to paint GUI
 */
public class Main
{
	public static void main(String[] args)
	{
		// Create class director
		ClassDirector classDirector = new ClassDirector("Class Director", 5);
		classDirector.addClass("file.json");
		classDirector.addTeacher("file.json");

		// Create admin
		Admin admin = new Admin("Admin", 0);
		// Get automatic assignment of class and teacher
		Map<String, String> assignment = admin.getAssignment();


		/*
		Create JFrame
		 */
		JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout());
		jf.setResizable(true);
		jf.setSize(600, 400);

		/*
		Create Class Panel
		 */
		JPanel classPanel = new JPanel(new BorderLayout());

		JLabel classLabel = new JLabel("Class Requirements");

		JScrollPane classScrollPane = new JScrollPane();
		// List model to store class object
		DefaultListModel<Class> classModel = new DefaultListModel<>();
		for (int i = 0; i < SingleList.getClassList().getSize(); i++)
		{
			classModel.add(i, (Class) SingleList.getClassList().get(i));
		}
		// JList to show class object
		JList<Class> classJList = new JList<>(classModel);
		classScrollPane.setViewportView(classJList);

		// Add components into Class Panel
		classPanel.add(classLabel, BorderLayout.NORTH);
		classPanel.add(classScrollPane, BorderLayout.CENTER);

		/*
		Create Teacher Panel
		 */
		JPanel teacherPanel = new JPanel(new BorderLayout());

		JLabel teacherLabel = new JLabel("Teachers");

		JScrollPane teacherScrollPane = new JScrollPane();
		// List model to store teacher object
		DefaultListModel<Teacher> teacherModel = new DefaultListModel<>();
		for (int i = 0; i < SingleList.getTeacherList().getSize(); i++)
		{
			teacherModel.add(i, (Teacher) SingleList.getTeacherList().get(i));
		}
		// JList to show teacher object
		JList<Teacher> teacherJList = new JList<>(teacherModel);
		teacherScrollPane.setViewportView(teacherJList);

		// Add components into Teacher Panel
		teacherPanel.add(teacherLabel, BorderLayout.NORTH);
		teacherPanel.add(teacherScrollPane, BorderLayout.CENTER);


		/*
		Create Result Panel
		 */
		JPanel resultPanel = new JPanel(new BorderLayout());

		JLabel resultLabel = new JLabel("Assignment Results");

		JScrollPane resultScrollPane = new JScrollPane();
		// List model to store result object
		DefaultListModel<String> resultModel = new DefaultListModel<>();
		// JList to show result object
		JList<String> resultJList = new JList<>(resultModel);
		resultScrollPane.setViewportView(resultJList);

		// Add components into Result Panel
		resultPanel.add(resultLabel, BorderLayout.NORTH);
		resultPanel.add(resultScrollPane, BorderLayout.CENTER);


		/*
		Create Button Panel
		 */
		JPanel btnPanel = new JPanel(new FlowLayout());
		// Create show result button
		JButton showResultBtn = new JButton("Show Automatic Assignment");
		// Add listener to show assignment result
		showResultBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				resultRefresh(resultModel, assignment);
			}
		});
		// Create manually assign button
		JButton manualAssignBtn = new JButton("Manual Assign");
		// Add listener to manually assign class and teacher
		manualAssignBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					// Get selected class object
					Class currentSelectedClass = classJList.getSelectedValue();
					// Get selected teacher object
					Teacher currentSelectedTeacher = teacherJList.getSelectedValue();

					// Update assignment
					assignment.put(currentSelectedClass.getClassName(), currentSelectedTeacher.getName());
					currentSelectedTeacher.addClass(currentSelectedClass);
					currentSelectedClass.addTeacher(currentSelectedTeacher);
					// Refresh and repaint the assignment result
					resultRefresh(resultModel, assignment);
				} catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Please Select Class and Teacher!");
				}
			}
		});

		// Create export file button
		JButton exportBtn = new JButton("Export Assignment");
		// Add listener to export assignment into file
		exportBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (resultJList.isVisible())
				{
					/*
					Splice assignment into highly readable text
					 */
					StringBuilder sb = new StringBuilder();
					for (Map.Entry<String, String> entry :
							assignment.entrySet())
					{
						sb.append(entry.getValue()).append(" teaches ").append(entry.getKey()).append("\n");
					}
					/*
					Create File Chooser
					 */
					JFileChooser jfc = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("(*.txt)", "txt");
					jfc.setFileFilter(filter);

					// Show save chosen window
					int option = jfc.showSaveDialog(null);
					if (option == JFileChooser.APPROVE_OPTION)
					{
						File file = jfc.getSelectedFile();

						String fname = jfc.getName(file);

						// Automatic add suffix name
						if (!fname.contains(".txt"))
						{
							file = new File(jfc.getCurrentDirectory(), fname + ".txt");
						}

						// Write data to file
						try (FileWriter fw = new FileWriter(file))
						{
							fw.write(sb.toString());

						} catch (Exception ex)
						{
							ex.printStackTrace();
						}

						// Show successfully saved window
						JOptionPane.showMessageDialog(
								null, String.format("File Saved As %s", file.getName()));
					}
				} else
				{
					// Show alert if assignment is not visible
					JOptionPane.showMessageDialog(null, "Please Review Assignment Before Exporting!");
				}
			}
		});

		// Add buttons into Button Panel
		btnPanel.add(showResultBtn);
		btnPanel.add(manualAssignBtn);
		btnPanel.add(exportBtn);

		// Add Panels into JFrame
		jf.add(classPanel, BorderLayout.WEST);
		jf.add(teacherPanel, BorderLayout.CENTER);
		jf.add(resultPanel, BorderLayout.EAST);
		jf.add(btnPanel, BorderLayout.SOUTH);

		// Set JFrame attributes
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);

	}

	/**
	 * Real-time refresh the assignment
	 *
	 * @param resultModel model to store object
	 * @param assignment  Map to store assignment
	 */
	private static void resultRefresh(DefaultListModel<String> resultModel, Map<String, String> assignment)
	{
		// Remove all old elements
		resultModel.removeAllElements();
		// Update with new data
		for (Map.Entry<String, String> entry :
				assignment.entrySet())
		{
			resultModel.add(0, entry.getKey() + ": " + entry.getValue());
		}
	}
}
