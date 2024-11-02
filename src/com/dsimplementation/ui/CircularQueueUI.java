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

import com.dsimplementation.datastructures.CircularQueue;
import com.dsimplementation.util.RoundedButton;

public class CircularQueueUI extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField sizeField;
	private JButton createButton;
	private JTextField elementField;
	private JButton	 enqueueButton;
	private JButton dequeButton;
	private JButton peekButton;
	private JButton displayButton;
	private JTextArea displayArea;
	private JScrollPane scrollArea;
	private CircularQueue q;
	
	public CircularQueueUI() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
	    setLayout(null);
		
		
		JTextArea title = new JTextArea("QUEUE");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(new Color(255, 255, 255));
		title.setDisabledTextColor(new Color(0, 255, 255));
		title.setBounds(280, 10, 102, 44);
		add(title);
		
		JLabel sizeLabel = new JLabel("SIZE");
		sizeLabel.setBounds(40, 84, 85, 35);
		sizeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(sizeLabel);

		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sizeField.setBounds(152, 84, 85, 35);
		add(sizeField);
		sizeField.setColumns(10);
		
		createButton = new JButton("CREATE QUEUE WITH GIVEN SIZE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int size = Integer.parseInt(sizeField.getText());
					 q = new CircularQueue(size);
					 displayArea.setText("Queue Created.");
				} catch (Exception ex) {
					 displayArea.setText("Enter a valid size.");
				}
			}
		});
		
		createButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		createButton.setBounds(280, 84, 260, 35);
		add(createButton);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(40, 155, 120, 35);
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(elementLabel);
		
		elementField = new JTextField();
		elementField.setBounds(190, 155, 85, 35);
		elementField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(elementField);
		elementField.setColumns(10);
		
		
		enqueueButton = new JButton("ENQUEUE");
		enqueueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( q == null) {
					displayArea.setText("Create a Queue First");
					return;	
				}
				try {
					int element = Integer.parseInt(elementField.getText());
					displayArea.setText(q.enque(element));
				} catch (Exception ex) {
					displayArea.setText("Ente a valid element.");
				}
			}
		});
		enqueueButton.setBounds(310, 146, 140, 50);
		enqueueButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
		add(enqueueButton);
		
		dequeButton = new JButton("DEQUEUE");
		dequeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q == null) {
					displayArea.setText("Create a Queue First");
					return;
				}
				displayArea.setText(q.deque());
			}
		});
		
		dequeButton.setBounds(480, 146, 140, 50);
		dequeButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
		add(dequeButton);
		
		peekButton = new JButton("PEEK");
		peekButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q == null) {
					displayArea.setText("Create a Queue First");
					return;
				}
				
				displayArea.setText(q.peek());
			}
		});
		peekButton.setBounds(135, 215, 140, 50);
		peekButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
		add(peekButton);
		
		displayButton = new JButton("DISPLAY");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q == null) {
					displayArea.setText("Create a Queue First");
				} else {
					displayArea.setText(q.getQueue());

					 // Ensure the viewport is set to the top-left corner
		            SwingUtilities.invokeLater(new Runnable() {
		                public void run() {
		                    scrollArea.getViewport().setViewPosition(new Point(0, 0));
		                }
		            });
				}
			}
		});
		displayButton.setBounds(410, 215, 140, 50);
		displayButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		add(displayButton);
		
		displayArea = new JTextArea();
		displayArea.setMargin(new Insets(10, 10, 2, 10));
		displayArea.setFont(new Font("Times New Roman", Font.BOLD, 30));

		
		scrollArea = new JScrollPane(displayArea,JScrollPane.VERTICAL_SCROLLBAR_NEVER , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollArea.setBounds(40, 290, 606, 60);
		add(scrollArea);
		
		ImageIcon closeIcon  =new ImageIcon(getClass().getResource("/resources/closeButton.png"));
		RoundedButton backButton = new RoundedButton(30, closeIcon, 1);
		backButton.addActionListener(e -> MainFrame.cardLayout.first(MainFrame.contentPanel) );
		backButton.setBounds(630, 20, 30, 30);		
		add(backButton);

	}
	

}
