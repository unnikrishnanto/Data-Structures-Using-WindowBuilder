package com.dsimplementation.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.dsimplementation.datastructures.LinkedList;

public class LinkedListUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField elementField;
	private JButton	 addFrontButton;
	private JButton addLastButton;
	private JTextField indexField;
	private JLabel indexLabel;
	private JButton deleFrontButton;
	private JButton deleRearButton;
	private JTextArea displayArea;
	private JScrollPane scrollArea;
	
	private LinkedList ll;
	private JButton addNButton;
	private JButton removeNButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkedListUI frame = new LinkedListUI();
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
	public LinkedListUI() {
		ll = new LinkedList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTextArea title = new JTextArea("LINKED LIST");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(new Color(255, 255, 255));
		title.setDisabledTextColor(new Color(0, 255, 255));
		title.setBounds(243, 10, 200, 44);
		contentPane.add(title);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(40, 84, 120, 35);
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		contentPane.add(elementLabel);
		
		elementField = new JTextField();
		elementField.setBounds(190, 84, 85, 35);
		elementField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(elementField);
		elementField.setColumns(10);
		
		
		addFrontButton = new JButton("ADD FRONT");
		addFrontButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int element = Integer.parseInt(elementField.getText());
					displayArea.setText(ll.addFirst(element));
				} catch (Exception ex) {
					displayArea.setText("Ente a valid element.");
				}
			}
		});
		addFrontButton.setBounds(320, 75, 140, 50);
		addFrontButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(addFrontButton);
		
		addLastButton = new JButton("ADD LAST");
		addLastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int element = Integer.parseInt(elementField.getText());
					displayArea.setText(ll.addLast(element));
				} catch (Exception ex) {
					displayArea.setText("Ente a valid element.");
				}
			}
		});
		
		addLastButton.setBounds(500, 75, 140, 50);
		addLastButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(addLastButton);
		
		indexLabel = new JLabel("Index");
		indexLabel.setBounds(40, 159, 85, 35);
		indexLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		contentPane.add(indexLabel);
		
		indexField = new JTextField();
		indexField.setBounds(190, 159, 85, 35);
		indexField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(indexField);
		indexField.setColumns(10);
		

		addNButton = new JButton("<html>ADD ELEMENT<br>AT INDEX</html>");
		addNButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int index = Integer.parseInt(indexField.getText());
					int element = Integer.parseInt(elementField.getText());
					displayArea.setText(ll.addNthNode(index, element));
					SwingUtilities.invokeLater(new Runnable() {
		                public void run() {
		                    scrollArea.getViewport().setViewPosition(new Point(0, 0));
		                }
		            });
				} catch (Exception ex) {
					displayArea.setText("Ente valid element and index.");
				}
			}
		});
		addNButton.setBounds(320, 150, 140, 50);
		addNButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(addNButton);
	
		
		removeNButton = new JButton("<html>REMOVE FROM<br> INDEX</html>");
		removeNButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = Integer.parseInt(indexField.getText());
					displayArea.setText(ll.deleteNthNode(index));
					SwingUtilities.invokeLater(new Runnable() {
		                public void run() {
		                    scrollArea.getViewport().setViewPosition(new Point(0, 0));
		                }
		            });
				} catch (Exception ex) {
					displayArea.setText("Ente valid index.");
				}
			}
		});
		removeNButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		removeNButton.setBounds(500, 150, 140, 50);
		contentPane.add(removeNButton);
		
		
		
		deleFrontButton = new JButton("<html>DELETE FROM<br> FRONT</html>");
		deleFrontButton.setMargin(new Insets(2, 5, 2, 5));
		deleFrontButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				displayArea.setText(ll.deleteFromFront());
			}
		});
		deleFrontButton.setBounds(25, 225, 140, 50);
		deleFrontButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(deleFrontButton);
		
		deleRearButton = new JButton("<html>DELETE FROM<br>REAR</html>");
		deleRearButton.setMargin(new Insets(2, 5, 2, 5));
		deleRearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayArea.setText(ll.deleteFromRear());
			}
		});
		
		deleRearButton.setBounds(190, 225, 140, 50);
		deleRearButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(deleRearButton);
		
		JButton dispFrontButton = new JButton("<html>DISPLAY FROM<br>FRONT</html>");
		dispFrontButton.setMargin(new Insets(2, 5, 2, 5));
		dispFrontButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayArea.setText(ll.getLLFromFront());
				SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    scrollArea.getViewport().setViewPosition(new Point(0, 0));
	                }
	            });
			}
		});
		dispFrontButton.setBounds(355, 225, 140, 50);
		dispFrontButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(dispFrontButton);
		
		JButton dispRearButton = new JButton("<html>DISPLAY FROM<br>REAR</html>");
		dispRearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayArea.setText(ll.getLLFromRear());
				SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    scrollArea.getViewport().setViewPosition(new Point(0, 0));
	                }
	            });
			}
		});
		dispRearButton.setMargin(new Insets(2, 5, 2, 5));
		
		dispRearButton.setBounds(520, 225, 140, 50);
		dispRearButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(dispRearButton);
		
		displayArea = new JTextArea();
		displayArea.setMargin(new Insets(10, 10, 2, 10));
		displayArea.setFont(new Font("Times New Roman", Font.BOLD, 30));

		
		scrollArea = new JScrollPane(displayArea,JScrollPane.VERTICAL_SCROLLBAR_NEVER , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollArea.setBounds(40, 300, 606, 60);
		contentPane.add(scrollArea);
		

	}
}