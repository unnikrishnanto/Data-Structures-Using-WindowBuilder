package com.dsimplementation.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.dsimplementation.datastructures.LinkedList;
import com.dsimplementation.util.RoundedButton;
import com.dsimplementation.util.SquareButtons;

public class LinkedListUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
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

	
	public LinkedListUI() {
		ll = new LinkedList();
		
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(219, 211, 211));
	    setLayout(null);
		
		
		
		JTextArea title = new JTextArea("LINKED LIST");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(null);
		title.setDisabledTextColor(new Color(255, 131, 5));
		title.setBounds(243, 10, 200, 44);
		add(title);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(25, 84, 120, 35);
		elementLabel.setForeground(new Color(2, 76, 170));
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(elementLabel);
		
		elementField = new JTextField();
		elementField.setBounds(190, 84, 85, 35);
		elementField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(elementField);
		elementField.setColumns(10);
		
		
		addFrontButton = new SquareButtons("ADD FRONT", 20);
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
		addFrontButton.setBounds(355, 75, 140, 50);
		add(addFrontButton);
		
		addLastButton = new SquareButtons("ADD LAST", 20);
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
		
		addLastButton.setBounds(520, 75, 140, 50);
		addLastButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		add(addLastButton);
		
		indexLabel = new JLabel("Index");
		indexLabel.setBounds(25, 159, 85, 35);
		indexLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		indexLabel.setForeground(new Color(2, 76, 170));
		add(indexLabel);
		
		indexField = new JTextField();
		indexField.setBounds(190, 159, 85, 35);
		indexField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(indexField);
		indexField.setColumns(10);
		

		addNButton = new SquareButtons("<html>ADD ELEMENT<br>AT INDEX</html>", 15);
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
		addNButton.setBounds(355, 150, 140, 50);
		add(addNButton);
	
		
		removeNButton = new SquareButtons("<html>REMOVE FROM<br> INDEX</html>", 15);
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
		
		removeNButton.setBounds(520, 150, 140, 50);
		add(removeNButton);
		
		
		
		deleFrontButton = new SquareButtons("<html>DELETE FROM<br> FRONT</html>", 15);
		deleFrontButton.setMargin(new Insets(2, 5, 2, 5));
		deleFrontButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				displayArea.setText(ll.deleteFromFront());
			}
		});
		deleFrontButton.setBounds(25, 225, 140, 50);
		add(deleFrontButton);
		
		deleRearButton = new SquareButtons("<html>DELETE FROM<br>REAR</html>", 15);
		deleRearButton.setMargin(new Insets(2, 5, 2, 5));
		deleRearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayArea.setText(ll.deleteFromRear());
			}
		});
		
		deleRearButton.setBounds(190, 225, 140, 50);
		add(deleRearButton);
		
		JButton dispFrontButton = new SquareButtons("<html>DISPLAY FROM<br>FRONT</html>", 15);
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
		add(dispFrontButton);
		
		JButton dispRearButton = new SquareButtons("<html>DISPLAY FROM<br>REAR</html>", 15);
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
		add(dispRearButton);
		
		displayArea = new JTextArea("Empty List is Ready");
		displayArea.setMargin(new Insets(10, 10, 2, 10));
		displayArea.setFont(new Font("Times New Roman", Font.BOLD, 30));

		
		scrollArea = new JScrollPane(displayArea,JScrollPane.VERTICAL_SCROLLBAR_NEVER , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollArea.setBounds(40, 300, 606, 60);
		add(scrollArea);
		
		
		ImageIcon closeIcon  =new ImageIcon(getClass().getResource("/resources/closeButton.png"));
		RoundedButton backButton = new RoundedButton(30, closeIcon, 1);
		backButton.addActionListener(e ->{
			elementField.setText("");
			indexField.setText("");
			displayArea.setText(ll.getLLFromFront());
			MainFrame.cardLayout.first(MainFrame.contentPanel);	
		});
		backButton.setBounds(630, 20, 30, 30);		
		add(backButton);

	}
}
