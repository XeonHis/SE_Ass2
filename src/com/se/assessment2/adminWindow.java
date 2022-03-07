package com.se.assessment2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminWindow
{
	private JTextPane textPane1;
	private JButton testButton;

	public adminWindow()
	{
		testButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);
			}
		});
	}
}
