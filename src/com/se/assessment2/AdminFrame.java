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
 * @description : Paint Admin JFrame
 */
public class AdminFrame extends JFrame
{
	/**
	 * Create Admin Interface
	 *
	 * @param name  window title name
	 * @param admin admin object
	 */
	public AdminFrame(String name, Admin admin)
	{
		this.setName(name);
		this.setLayout(new BorderLayout());
		this.setResizable(true);
		this.setSize(600, 400);

		/*
		Create Class Panel
		 */
		JPanel classPanel = new JPanel(new BorderLayout());

		JLabel classLabel = new JLabel("Class Requirements");

		JScrollPane classScrollPane = new JScrollPane();
		// List model to store class object
		DefaultListModel<Class> classModel = new DefaultListModel<>();
		for (int i = 0; i < ListOfClass.getInstance().getSize(); i++)
		{
			classModel.add(i, (Class) ListOfClass.getInstance().get(i));
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
		for (int i = 0; i < ListOfTeacher.getInstance().getSize(); i++)
		{
			teacherModel.add(i, (Teacher) ListOfTeacher.getInstance().get(i));
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
		// Create back to role selection button
		JButton backBtn = new JButton("Back to Role Selection");
		backBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				AdminFrame.this.dispose();
				new RoleSelectionFrame("Role Selection Interface", admin);
			}
		});
		// Create show result button
		JButton showResultBtn = new JButton("Show Automatic Assignment");
		// Add listener to show assignment result
		showResultBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// Check whether show automatic assignment
				int value = JOptionPane.showConfirmDialog(null,
						"Manually Assignment will Discord if not Export! Confirm Automatic Assignment?");
				if (value == JOptionPane.YES_OPTION)
				{
					Admin.findAssignment();
					resultRefresh(resultModel);
				}
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
					Admin.getAssignment().put(currentSelectedClass.getClassName(), currentSelectedTeacher.getName());
					currentSelectedTeacher.addClass(currentSelectedClass);
					currentSelectedClass.addTeacher(currentSelectedTeacher);
					// Refresh and repaint the assignment result
					resultRefresh(resultModel);
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
							Admin.getAssignment().entrySet())
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
		btnPanel.add(backBtn);
		btnPanel.add(showResultBtn);
		btnPanel.add(manualAssignBtn);
		btnPanel.add(exportBtn);

		// Add Panels into JFrame
		this.add(classPanel, BorderLayout.WEST);
		this.add(teacherPanel, BorderLayout.CENTER);
		this.add(resultPanel, BorderLayout.EAST);
		this.add(btnPanel, BorderLayout.SOUTH);

		// Set JFrame attributes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	/**
	 * Real-time refresh the assignment
	 *
	 * @param resultModel model to store object
	 */
	private void resultRefresh(DefaultListModel<String> resultModel)
	{
		Map<String, String> assignment = Admin.getAssignment();
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
