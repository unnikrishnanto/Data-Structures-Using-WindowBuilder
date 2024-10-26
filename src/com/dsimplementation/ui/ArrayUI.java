package com.dsimplementation.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
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


public class ArrayUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JButton createButton;
	private JTextField textField;
	private JLabel indexLabel;
	private JTextField textField_1;
	private JButton addButton;
	private JButton deleteButton_1;
	private JButton deleteButton_2;
	private JButton displayButton;
	private JTextArea displayField;
	private JScrollPane sp;
	private Array arr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayUI frame = new ArrayUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ArrayUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea title = new JTextArea("ARRAY");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(new Color(255, 255, 255));
		title.setDisabledTextColor(new Color(0, 255, 255));
		title.setBounds(290, 10, 106, 44);
		contentPane.add(title);
		
				
		JLabel sizeLabel = new JLabel("SIZE");
		sizeLabel.setBounds(39, 84, 85, 35);
		sizeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		contentPane.add(sizeLabel);

		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sizeField.setBounds(177, 84, 85, 35);
		contentPane.add(sizeField);
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
		createButton.setBounds(290, 84, 366, 35);
		createButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(createButton);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(33, 159, 120, 35);
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		contentPane.add(elementLabel);
		
		textField = new JTextField();
		textField.setBounds(177, 159, 85, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		indexLabel = new JLabel("Index");
		indexLabel.setBounds(290, 159, 85, 35);
		indexLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		contentPane.add(indexLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(385, 159, 85, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		addButton = new JButton("ADD ELEMENT");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton.setBounds(507, 144, 140, 50);
		addButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 10));
		contentPane.add(addButton);
		
		deleteButton_1 = new JButton("REMOVE ELEMENT");
		deleteButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		deleteButton_1.setBounds(33, 226, 140, 50);
		deleteButton_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 10));
		contentPane.add(deleteButton_1);
		
		deleteButton_2 = new JButton("REMOVE FROM INDEX");
		deleteButton_2.setBounds(290, 226, 140, 50);
		deleteButton_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 10));
		contentPane.add(deleteButton_2);
		
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
		displayButton.setBounds(507, 223, 140, 50);
		displayButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(displayButton);
		
		displayField = new JTextArea("hii");
		displayField.setEditable(false);
		displayField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		displayField.setDisabledTextColor(new Color(0, 0, 0));
		displayField.setFont(new Font("Times New Roman", Font.BOLD, 30));
		displayField.setColumns(10);
		
		sp = new JScrollPane(displayField, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(25, 298, 650, 60);
		contentPane.add(sp);
	}
}
