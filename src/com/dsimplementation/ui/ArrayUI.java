package com.dsimplementation.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import com.dsimplementation.datastructures.Array;
import com.dsimplementation.util.RoundedButton;
import com.dsimplementation.util.SquareButtons;


public class ArrayUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField sizeField;
	private JButton createButton;
	private JTextField elementField;
	private JLabel indexLabel;
	private JTextField indexField;
	private JButton addButton;
	private JButton deleteButton_1;
	private JButton deleteButton_2;
	private JButton displayButton;
	private JTextArea displayField;
	private JScrollPane sp;
	private Array arr;


	public ArrayUI() {
		
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(219, 211, 211));
	    setLayout(null);
		
		JTextArea title = new JTextArea("ARRAY");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(null);
		title.setDisabledTextColor(new Color(255, 131, 5));
		title.setBounds(290, 10, 106, 44);
		add(title);
		
				
		JLabel sizeLabel = new JLabel("SIZE");
		sizeLabel.setBounds(39, 84, 85, 35);
		sizeLabel.setForeground(new Color(2, 76, 170));
		sizeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(sizeLabel);

		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sizeField.setBounds(149, 84, 85, 35);
		add(sizeField);
		sizeField.setColumns(10);
		
		createButton = new SquareButtons("CREATE AN ARRAY OF ENTERED SIZE", 20);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int size = Integer.parseInt(sizeField.getText());
					arr = new Array();
					displayField.setText(arr.createArray(size));
				} catch (Exception ex) {
					displayField.setText("Enter a valid size.");
				}
			}
		});
		createButton.setBounds(280, 84, 366, 35);
		add(createButton);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(252, 159, 120, 35);
		elementLabel.setForeground(new Color(2, 76, 170));
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(elementLabel);
		
		elementField = new JTextField();
		elementField.setBounds(394, 159, 85, 35);
		elementField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(elementField);
		elementField.setColumns(10);
		
		indexLabel = new JLabel("Index");
		indexLabel.setBounds(39, 159, 85, 35);
		indexLabel.setForeground(new Color(2, 76, 170));
		indexLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(indexLabel);
		
		indexField = new JTextField();
		indexField.setBounds(138, 159, 85, 35);
		indexField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(indexField);
		indexField.setColumns(10);
		
		addButton = new SquareButtons("<html>ADD<br> ELEMENT<html>", 20);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr == null) {
					displayField.setText("Create an array First");
					return;
				}
				try {
					int index = Integer.parseInt(indexField.getText());
					int element = Integer.parseInt(elementField.getText());
					displayField.setText(arr.set(element, index));
				} catch (Exception ex) {
					displayField.setText("Ente a valid index and element.");
				}
			}
		});
		addButton.setBounds(507, 144, 140, 50);
		add(addButton);
		
		deleteButton_1 = new SquareButtons("<html>REMOVE<br> ELEMENT<html>", 18);
		deleteButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr == null) {
					displayField.setText("Create an array First");
					return;
				}
				try {
					int element = Integer.parseInt(elementField.getText());
					if(arr.deleteElement(element)) {
						displayField.setText("Element " + element + " Removed");
					} else {
						displayField.setText("Element Not Found.");
					}
				} catch (Exception ex) {
					displayField.setText("Enter an integer value for element.");
				}
			}
		});
		
		deleteButton_1.setBounds(40, 226, 140, 50);
		add(deleteButton_1);
		
		deleteButton_2 = new SquareButtons("<html>REMOVE<br>FROM INDEX<html>", 18);
		deleteButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr == null) {
					displayField.setText("Create an array First");
					return;
				}
				try {
					int index = Integer.parseInt(indexField.getText());	
					displayField.setText(arr.deleteFromIndex(index));
				} catch (Exception ex) {
					displayField.setText("Ente a positive integer as index.");
				}
			}
		});
		deleteButton_2.setBounds(280, 226, 140, 50);
		add(deleteButton_2);
		
		displayButton = new SquareButtons("DISPLAY");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr == null) {
					displayField.setText("Create an array First");
				} else {
					displayField.setText(arr.getArray());
					 // Ensure the viewport is set to the top-left corner
		            SwingUtilities.invokeLater(new Runnable() {
		                public void run() {
		                    sp.getViewport().setViewPosition(new Point(0, 0));
		                }
		            });
				}
			}
		});
		displayButton.setBounds(507, 223, 140, 50);
		add(displayButton);
		
		displayField = new JTextArea("Create an Array.");
		displayField.setEditable(false);
		displayField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		displayField.setDisabledTextColor(new Color(0, 0, 0));
		displayField.setFont(new Font("Times New Roman", Font.BOLD, 30));
		displayField.setColumns(10);
		
		sp = new JScrollPane(displayField, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(25, 298, 650, 60);
		add(sp);
		
		ImageIcon closeIcon  =new ImageIcon(getClass().getResource("/resources/closeButton.png"));
		RoundedButton backButton = new RoundedButton(30, closeIcon, 1);
		backButton.addActionListener(e -> MainFrame.cardLayout.first(MainFrame.contentPanel) );
		backButton.setBounds(630, 20, 30, 30);		
		add(backButton);
	}
}
