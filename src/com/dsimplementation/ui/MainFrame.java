package com.dsimplementation.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;


import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea("Choose a Data Structure...");
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setDisabledTextColor(new Color(0, 255, 255));
		textArea.setBounds(159, 35, 382, 41);
		contentPane.add(textArea);
		
		JButton arrayButton = new JButton("ARRAY");
		arrayButton.setBounds(50, 140, 140, 50);
		arrayButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(arrayButton);
		
		JButton stackButton = new JButton("STACK");
		stackButton.setBounds(280, 140, 140, 50);
		stackButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(stackButton);
		
		JButton queueButton = new JButton("QUEUE");
		queueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		queueButton.setBounds(510, 140, 140, 50);
		queueButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(queueButton);
		
		JButton circularQueueButton = new JButton("<html>CIRCULAR<br>&nbsp&nbsp QUEUE</html>");
		circularQueueButton.setBounds(50, 260, 140, 50);
		circularQueueButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(circularQueueButton);
		
		JButton linkedListButton = new JButton("LINKED LIST");
		linkedListButton.setBounds(280, 260, 140, 50);
		linkedListButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(linkedListButton);
		
		JButton binarySearchTreeButton = new JButton("BINARY SEARCH TREE");
		binarySearchTreeButton.setBounds(510, 260, 140, 50);
		binarySearchTreeButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 10));
		contentPane.add(binarySearchTreeButton);
		
		JLabel backgroundImageLabel = new JLabel(new ImageIcon("C:\\Users\\cek\\Documents\\Backup_1\\Java Full Stack Internship\\ECLIPSE\\DSImplementation\\img\\main_background.png"));
		backgroundImageLabel.setBounds(0, 0, 686, 363);
		contentPane.add(backgroundImageLabel);
		
		
	}
}
