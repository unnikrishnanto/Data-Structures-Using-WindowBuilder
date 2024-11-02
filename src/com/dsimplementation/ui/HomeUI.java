package com.dsimplementation.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class HomeUI extends JPanel {
	
	private static final long serialVersionUID = 1L;

	HomeUI (){
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		
		JTextArea textArea = new JTextArea("Choose a Data Structure...");
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setDisabledTextColor(new Color(0, 255, 255));
		textArea.setBounds(159, 35, 382, 41);
		add(textArea);
		
		JButton arrayButton = new JButton("ARRAY");
		arrayButton.setBounds(50, 140, 140, 50);
		arrayButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
		arrayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "Array");
			}
		});
		
		add(arrayButton);
		
		JButton stackButton = new JButton("STACK");
		stackButton.setBounds(280, 140, 140, 50);
		stackButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
		stackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "Stack");
			}
		});
		add(stackButton);
		
		JButton queueButton = new JButton("QUEUE");
		queueButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame.cardLayout.show(MainFrame.contentPanel, "Queue");
				}
		});
		
		queueButton.setBounds(510, 140, 140, 50);
		queueButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
		add(queueButton);
		
		JButton circularQueueButton = new JButton("<html>CIRCULAR<br>&nbsp&nbsp QUEUE</html>");
		circularQueueButton.setBounds(50, 260, 140, 50);
		circularQueueButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		circularQueueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "Circular Queue");
			}
		});
		add(circularQueueButton);
		
		JButton linkedListButton = new JButton("LINKED LIST");
		linkedListButton.setBounds(280, 260, 140, 50);
		linkedListButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		linkedListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "Linked List");
			}
		});
		
		add(linkedListButton);
		
		JButton binarySearchTreeButton = new JButton("BINARY SEARCH TREE");
		binarySearchTreeButton.setBounds(510, 260, 140, 50);
		binarySearchTreeButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 10));
		binarySearchTreeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "BST");
			}
		});	
			
		add(binarySearchTreeButton);
		}

}
