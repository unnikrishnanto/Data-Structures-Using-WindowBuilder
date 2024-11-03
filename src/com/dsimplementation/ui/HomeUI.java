package com.dsimplementation.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.dsimplementation.util.SquareButtons;


public class HomeUI extends JPanel {
	
	private static final long serialVersionUID = 1L;

	HomeUI (){
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(219, 211, 211));
		setLayout(null);
		
		
		JTextArea textArea = new JTextArea("Choose a Data Structure...");
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		textArea.setBackground(null);
		textArea.setDisabledTextColor(new Color(255, 131, 5));
		textArea.setBounds(159, 35, 382, 41);
		add(textArea);
		
		
		SquareButtons arrayButton = new SquareButtons("ARRAY");
		arrayButton.setBounds(50, 140, 140, 50);
		arrayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "Array");
			}
		});
		
		add(arrayButton);
		
		SquareButtons stackButton = new SquareButtons("STACK");
		stackButton.setBounds(280, 140, 140, 50);
		stackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "Stack");
			}
		});
		add(stackButton);
		
		SquareButtons queueButton = new SquareButtons("QUEUE");
		queueButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame.cardLayout.show(MainFrame.contentPanel, "Queue");
				}
		});
		
		queueButton.setBounds(510, 140, 140, 50);
		add(queueButton);
		
		SquareButtons circularQueueButton = new SquareButtons("<html>CIRCULAR<br>&nbsp&nbsp QUEUE</html>", 20);
		circularQueueButton.setBounds(50, 260, 140, 50);
		circularQueueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "Circular Queue");
			}
		});
		add(circularQueueButton);
		
		SquareButtons linkedListButton = new SquareButtons("LINKED LIST", 18);
		linkedListButton.setBounds(280, 260, 140, 50);
		linkedListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "Linked List");
			}
		});
		
		add(linkedListButton);
		
		SquareButtons binarySearchTreeButton = new SquareButtons("<html>BINARY <br>SEARCH TREE<html>", 17);
		binarySearchTreeButton.setBounds(510, 260, 140, 50);
		binarySearchTreeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.contentPanel, "BST");
			}
		});	
			
		add(binarySearchTreeButton);
		}

}
