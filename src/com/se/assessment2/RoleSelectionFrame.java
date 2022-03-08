package com.se.assessment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author : Heting Ying
 * @description : Paint Role Selection JFrame
 */
public class RoleSelectionFrame extends JFrame
{
	/**
	 * Create Role Login Interface
	 *
	 * @param name  window title name
	 * @param admin admin object
	 */
	public RoleSelectionFrame(String name, Admin admin)
	{
		this.setName(name);
		this.setLayout(new FlowLayout());
		this.setResizable(true);
		this.setSize(600, 400);

		// Create tip label
		JLabel tipJLabel = new JLabel("Please Select Your Role\n");

		// Create panels to store labels and buttons
		JPanel adminPanel = new JPanel(new BorderLayout());
		JPanel classDirectorPanel = new JPanel(new BorderLayout());

		// Create role selection label
		JLabel adminJLabel = new JLabel("Admin");
		JLabel classDirectorJLabel = new JLabel("Class Director");

		// Create different roles' buttons
		JButton adminLoginBtn = new JButton("Admin");
		JButton classDirectorLoginBtn = new JButton("Class Director");

		// Add listeners of role selection buttons
		adminLoginBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// Kill current window and show admin window
				RoleSelectionFrame.this.dispose();
				new AdminFrame("Admin Interface", admin).setVisible(true);
			}
		});
		classDirectorLoginBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// Kill current window and show class director window
				RoleSelectionFrame.this.dispose();
				new ClassDirectorFrame("Class Director Interface", admin).setVisible(true);
			}
		});

		// Add labels and buttons into different panel
		adminPanel.add(adminJLabel, BorderLayout.NORTH);
		adminPanel.add(adminLoginBtn, BorderLayout.CENTER);
		classDirectorPanel.add(classDirectorJLabel, BorderLayout.NORTH);
		classDirectorPanel.add(classDirectorLoginBtn, BorderLayout.CENTER);

		// Add tip label and panels into login JFrame
		this.add(tipJLabel);
		this.add(adminPanel);
		this.add(classDirectorPanel);

		// Set attributes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}
