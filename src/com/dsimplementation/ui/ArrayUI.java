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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import com.dsimplementation.datastructures.Array;


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
	    setLayout(null);
		
		JTextArea title = new JTextArea("ARRAY");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(new Color(255, 255, 255));
		title.setDisabledTextColor(new Color(0, 255, 255));
		title.setBounds(290, 10, 106, 44);
		add(title);
		
				
		JLabel sizeLabel = new JLabel("SIZE");
		sizeLabel.setBounds(39, 84, 85, 35);
		sizeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(sizeLabel);

		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sizeField.setBounds(149, 84, 85, 35);
		add(sizeField);
		sizeField.setColumns(10);
		
		createButton = new JButton("CREATE AN ARRAY OF ENTERED SIZE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int size = Integer.parseInt(sizeField.getText());
					arr = new Array().createArray(size);
				} catch (Exception ex) {
					displayField.setText("Enter a valid size.");
				}
			}
		});
		createButton.setBounds(291, 84, 366, 35);
		createButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		add(createButton);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(252, 159, 120, 35);
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(elementLabel);
		
		elementField = new JTextField();
		elementField.setBounds(394, 159, 85, 35);
		elementField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(elementField);
		elementField.setColumns(10);
		
		indexLabel = new JLabel("Index");
		indexLabel.setBounds(39, 159, 85, 35);
		indexLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(indexLabel);
		
		indexField = new JTextField();
		indexField.setBounds(138, 159, 85, 35);
		indexField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(indexField);
		indexField.setColumns(10);
		
		addButton = new JButton("ADD ELEMENT");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr == null) {
					displayField.setText("Create an array First");
					return;
				}
				try {
					int index = Integer.parseInt(indexField.getText());
					int element = Integer.parseInt(elementField.getText());
					if(arr.set(element, index)) {
						displayField.setText("Added");
					} else {
						displayField.setText("Invalid index.");
					}
				} catch (Exception ex) {
					displayField.setText("Ente a valid index and element.");
				}
			}
		});
		addButton.setBounds(507, 144, 140, 50);
		addButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 10));
		add(addButton);
		
		deleteButton_1 = new JButton("REMOVE ELEMENT");
		deleteButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr == null) {
					displayField.setText("Create an array First");
					return;
				}
				try {
					int element = Integer.parseInt(elementField.getText());
					if(arr.deleteElement(element)) {
						displayField.setText("Element Removed");
					} else {
						displayField.setText("Element Not Found.");
					}
				} catch (Exception ex) {
					displayField.setText("Enter an integer value for element.");
				}
			}
		});
		
		deleteButton_1.setBounds(50, 226, 140, 50);
		deleteButton_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 10));
	    add(deleteButton_1);
		
		deleteButton_2 = new JButton("REMOVE FROM INDEX");
		deleteButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr == null) {
					displayField.setText("Create an array First");
					return;
				}
				try {
					int index = Integer.parseInt(indexField.getText());
					if(arr.deleteFromIndex(index)) {
						displayField.setText("Removed element from index " + index);
					} else {
						displayField.setText("Invalid index.");
					}
				} catch (Exception ex) {
					displayField.setText("Ente a positive integer as index.");
				}
			}
		});
		deleteButton_2.setBounds(280, 226, 140, 50);
		deleteButton_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 10));
		add(deleteButton_2);
		
		displayButton = new JButton("DISPLAY");
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
		displayButton.setBounds(510, 223, 140, 50);
		displayButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		add(displayButton);
		
		displayField = new JTextArea("hii");
		displayField.setEditable(false);
		displayField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		displayField.setDisabledTextColor(new Color(0, 0, 0));
		displayField.setFont(new Font("Times New Roman", Font.BOLD, 30));
		displayField.setColumns(10);
		
		sp = new JScrollPane(displayField, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(25, 298, 650, 60);
		add(sp);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> MainFrame.cardLayout.first(MainFrame.contentPanel) );
		backButton.setBounds(600, 20, 80, 40);		
		add(backButton);
	}
}
