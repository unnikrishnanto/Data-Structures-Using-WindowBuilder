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

import com.dsimplementation.datastructures.BST;
import com.dsimplementation.util.RoundedButton;

public class BSTUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField elementField;
	private JButton	 insertButton;
	private JButton deleteButton;
	private JButton searchButton;
	private JButton inOrderButton;
	private JTextArea displayArea;
	private JScrollPane scrollArea;
	
	private BST.Node root;
	public BSTUI() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
	    setLayout(null);
		
		JTextArea title = new JTextArea("BINARY SEARCH TREE");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(null);
		title.setDisabledTextColor(new Color(0, 255, 255));
		title.setBounds(174, 10, 330, 44);
		add(title);
		
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(28, 110, 120, 35);
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(elementLabel);
		
		elementField = new JTextField();
		elementField.setBounds(190, 110, 85, 35);
		elementField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(elementField);
		elementField.setColumns(10);
		
		
		
		insertButton = new JButton("<html>&nbsp; INSERT<br>ELEMENT<html>");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int element = Integer.parseInt(elementField.getText());
					root = BST.insert(root, element);
					displayArea.setText("Node added Sucessfully.");
				} catch (Exception ex) {
					displayArea.setText("Ente a valid element.");
				}
			}
		});
		insertButton.setBounds(320, 101, 140, 50);
		insertButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		add(insertButton);
		
		deleteButton = new JButton("<html>&NBSP; DELETE<br>ELEMENT<html>");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int element = Integer.parseInt(elementField.getText());
					if(BST.search(root, element)) {
					  root = BST.delete(root, element);
					  displayArea.setText("Node deleted Sucessfully.");
					} else {
						displayArea.setText("Node Not Found.");
					}
						
				} catch (Exception ex) {
					displayArea.setText("Ente a valid element.");
				}
			}
		});
		
		deleteButton.setBounds(500, 101, 140, 50);
		deleteButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		add(deleteButton);
		
		
		
		searchButton = new JButton("<html>SEARCH<br> ELEMENT</html>");
		searchButton.setMargin(new Insets(2, 5, 2, 5));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					int element = Integer.parseInt(elementField.getText());
					if(BST.search(root, element)) {
						displayArea.setText("Node Found.");
					} else {
						displayArea.setText("Node Not Found.");
					}
						
				} catch (Exception ex) {
					displayArea.setText("Ente a valid element.");
				}
			}
		});
		searchButton.setBounds(28, 200, 140, 50);
		searchButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		add(searchButton);
		
		inOrderButton = new JButton("<html>DISPLAY<br>IN-ORDER</html>");
		inOrderButton.setMargin(new Insets(2, 5, 2, 5));
		inOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(root == null) {
					displayArea.setText("Tree is Empty.");
					return;
				} else {
				displayArea.setText(BST.inOrder(root));
				}
				SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    scrollArea.getViewport().setViewPosition(new Point(0, 0));
	                }
	            });
			}
		});
		
		inOrderButton.setBounds(190, 200, 140, 50);
		inOrderButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		add(inOrderButton);
		
		JButton preOrderButton = new JButton("<html>DISPLAY<br>PRE-ORDER</html>");
		preOrderButton.setMargin(new Insets(2, 5, 2, 5));
		preOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(root == null) {
					displayArea.setText("Tree is Empty.");
					return;
				} else {
				displayArea.setText(BST.preOrder(root));
				}
				SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    scrollArea.getViewport().setViewPosition(new Point(0, 0));
	                }
	            });
			}
		});
		preOrderButton.setBounds(355, 200, 140, 50);
		preOrderButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		add(preOrderButton);
		
		JButton postOrderButton = new JButton("<html>DISPLAY <br>POST-ORDER</html>");
		postOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(root == null) {
					displayArea.setText("Tree is Empty.");
					return;
				} else {
				displayArea.setText(BST.postOrder(root));
				}
				SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    scrollArea.getViewport().setViewPosition(new Point(0, 0));
	                }
	            });
			}
		});
		postOrderButton.setMargin(new Insets(2, 5, 2, 5));
		
		postOrderButton.setBounds(520, 200, 140, 50);
		postOrderButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		add(postOrderButton);
		
		displayArea = new JTextArea();
		displayArea.setMargin(new Insets(10, 10, 2, 10));
		displayArea.setFont(new Font("Times New Roman", Font.BOLD, 30));

		
		scrollArea = new JScrollPane(displayArea,JScrollPane.VERTICAL_SCROLLBAR_NEVER , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollArea.setBounds(40, 280, 606, 60);
		add(scrollArea);
		
		
		ImageIcon closeIcon  =new ImageIcon(getClass().getResource("/resources/closeButton.png"));
		RoundedButton backButton = new RoundedButton(30, closeIcon, 1);
		backButton.addActionListener(e -> MainFrame.cardLayout.first(MainFrame.contentPanel) );
		backButton.setBounds(630, 20, 30, 30);		
		add(backButton);
	}


}
