package com.dsimplementation.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class SquareButtons extends JButton {
	
	private static final long serialVersionUID = 1L;

	public SquareButtons(String text) {
		setText(text);
		setBackground(new Color(9, 16, 87));
		setForeground(new Color(219, 211, 211));
		setFocusable(false);
		setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));

	}
	
	public SquareButtons(String text, int fontSize) {
		setText(text);
		setBackground(new Color(9, 16, 87));
		setForeground(new Color(219, 211, 211));
		setFocusable(false);
		setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, fontSize));

	}
	}
