package com.se.assessment2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class Main
{
	public static void main(String[] args)
	{
		classDirector classDirector = new classDirector();
		classDirector.addClass("file.json");
		classDirector.addTeacher("file.json");

		Admin admin = new Admin();
		Map<String, String> assignment = admin.getAssignment();


		JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout(10, 5));
		jf.setResizable(true);
		jf.setSize(800, 600);

		JTextPane textPane = new JTextPane();
		textPane.setPreferredSize(new Dimension(400, 600));
		JButton getClassBtn = new JButton("get class");
		getClassBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				textPane.setText("");
				LoC classList = singleList.getClassList();
				for (int i = 0; i < classList.getSize(); i++)
				{
					String temp = classList.get(i).getCollege() + ": " + classList.get(i).getClassName();
					textPane.setText(textPane.getText() + temp + "\n");
				}
			}
		});

		JButton getTeacherBtn = new JButton("get teacher");
		getTeacherBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				textPane.setText("");
				LoT teacherList = singleList.getTeacherList();
				for (int i = 0; i < teacherList.getSize(); i++)
				{
					String temp = teacherList.get(i).toString();
					textPane.setText(textPane.getText() + temp + "\n");
				}
			}
		});

		JPanel jPanel = new JPanel(new FlowLayout());
		jPanel.add(getClassBtn);
		jPanel.add(getTeacherBtn);

		jf.add(textPane, BorderLayout.NORTH);
		jf.add(jPanel,BorderLayout.SOUTH);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);


	}

}
