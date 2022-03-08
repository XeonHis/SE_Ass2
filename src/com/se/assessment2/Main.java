package com.se.assessment2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class Main
{
	public static void main(String[] args)
	{
		ClassDirector classDirector = new ClassDirector("Class Director", 5);
		classDirector.addClass("file.json");
		classDirector.addTeacher("file.json");

		Admin admin = new Admin("Admin", 0);
		Map<String, String> assignment = admin.getAssignment();


		JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout());
		jf.setResizable(true);
		jf.setSize(600, 400);

		// Create Class Panel
		JPanel classPanel = new JPanel(new BorderLayout());

		JLabel classLabel = new JLabel("Class Requirements");

		JScrollPane classScrollPane = new JScrollPane();
		DefaultListModel<Class> classModel = new DefaultListModel<>();
		for (int i = 0; i < SingleList.getClassList().getSize(); i++)
		{
			classModel.add(i, (Class) SingleList.getClassList().get(i));
		}
		JList<Class> classJList = new JList<>(classModel);
		classScrollPane.setViewportView(classJList);

		classPanel.add(classLabel, BorderLayout.NORTH);
		classPanel.add(classScrollPane, BorderLayout.CENTER);

		// Create Teacher Panel
		JPanel teacherPanel = new JPanel(new BorderLayout());

		JLabel teacherLabel = new JLabel("Teachers");

		JScrollPane teacherScrollPane = new JScrollPane();
		DefaultListModel<Teacher> teacherModel = new DefaultListModel<>();
		for (int i = 0; i < SingleList.getTeacherList().getSize(); i++)
		{
			teacherModel.add(i, (Teacher) SingleList.getTeacherList().get(i));
		}
		JList<Teacher> teacherJList = new JList<>(teacherModel);
		teacherScrollPane.setViewportView(teacherJList);

		teacherPanel.add(teacherLabel, BorderLayout.NORTH);
		teacherPanel.add(teacherScrollPane, BorderLayout.CENTER);


		// Create Result Panel
		JPanel resultPanel = new JPanel(new BorderLayout());

		JLabel resultLabel = new JLabel("Assignment Results");

		JScrollPane resultScrollPane = new JScrollPane();
		DefaultListModel<String> resultModel = new DefaultListModel<>();
		JList<String> resultJList = new JList<>(resultModel);
		resultScrollPane.setViewportView(resultJList);


		resultPanel.add(resultLabel, BorderLayout.NORTH);
		resultPanel.add(resultScrollPane, BorderLayout.CENTER);


		// Create Button Panel
		JPanel btnPanel = new JPanel(new FlowLayout());
		JButton showResultBtn = new JButton("Show Automatic Assignment");
		showResultBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				resultRefresh(resultModel, assignment);
			}
		});

		JButton manualAssignBtn = new JButton("Manual Assign");
		manualAssignBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					Class currentSelectedClass = classJList.getSelectedValue();
					Teacher currentSelectedTeacher = teacherJList.getSelectedValue();

					assignment.put(currentSelectedClass.getClassName(), currentSelectedTeacher.getName());
					currentSelectedTeacher.addClass(currentSelectedClass);
					currentSelectedClass.addTeacher(currentSelectedTeacher);
					resultRefresh(resultModel, assignment);
				} catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Please Select Class and Teacher!");
				}
			}
		});

		JButton exportBtn = new JButton("Export Assignment");
		exportBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (resultJList.isVisible())
				{
					StringBuilder sb = new StringBuilder();
					for (Map.Entry<String, String> entry :
							assignment.entrySet())
					{
						sb.append(entry.getValue()).append(" teaches ").append(entry.getKey()).append("\n");
					}
					JFileChooser jfc = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("(*.txt)", "txt");
					jfc.setFileFilter(filter);

					int option = jfc.showSaveDialog(null);
					if (option == JFileChooser.APPROVE_OPTION)
					{
						File file = jfc.getSelectedFile();

						String fname = jfc.getName(file);

						if (!fname.contains(".txt"))
						{
							file = new File(jfc.getCurrentDirectory(), fname + ".txt");
						}

						try (FileWriter fw = new FileWriter(file))
						{
							fw.write(sb.toString());

						} catch (Exception ex)
						{
							ex.printStackTrace();
						}

						JOptionPane.showMessageDialog(
								null, String.format("File Saved As %s", file.getName()));
					}
				} else
				{
					JOptionPane.showMessageDialog(null, "Please Review Assignment Before Exporting!");
				}
			}
		});
		btnPanel.add(showResultBtn);
		btnPanel.add(manualAssignBtn);
		btnPanel.add(exportBtn);

		jf.add(classPanel,BorderLayout.WEST);
		jf.add(teacherPanel,BorderLayout.CENTER);
		jf.add(resultPanel,BorderLayout.EAST);
		jf.add(btnPanel,BorderLayout.SOUTH);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);

	}

	private static void resultRefresh(DefaultListModel<String> resultModel, Map<String, String> assignment)
	{
		resultModel.removeAllElements();
		for (Map.Entry<String, String> entry :
				assignment.entrySet())
		{
			resultModel.add(0, entry.getKey() + ": " + entry.getValue());
		}
	}
}
