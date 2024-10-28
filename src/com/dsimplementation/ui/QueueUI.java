package com.dsimplementation.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import com.dsimplementation.datastructures.Queue;
import java.awt.Insets;

public class QueueUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizeField;
	private JButton createButton;
	private JTextField elementField;
	private JButton	 enqueueButton;
	private JButton popButton;
	private JButton peekButton;
	private JButton displayButton;
	private JTextArea displayArea;
	private JScrollPane scrollArea;
	private Queue q;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueUI frame = new QueueUI();
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
	public QueueUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTextArea title = new JTextArea("QUEUE");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(new Color(255, 255, 255));
		title.setDisabledTextColor(new Color(0, 255, 255));
		title.setBounds(280, 10, 102, 44);
		contentPane.add(title);
		
		JLabel sizeLabel = new JLabel("SIZE");
		sizeLabel.setBounds(40, 84, 85, 35);
		sizeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		contentPane.add(sizeLabel);

		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sizeField.setBounds(152, 84, 85, 35);
		contentPane.add(sizeField);
		sizeField.setColumns(10);
		
		createButton = new JButton("CREATE QUEUE WITH GIVEN SIZE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int size = Integer.parseInt(sizeField.getText());
					 q = new Queue().createQueue(size);
					 displayArea.setText("Queue Created.");
				} catch (Exception ex) {
					 displayArea.setText("Enter a valid size.");
				}
			}
		});
		
		createButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		createButton.setBounds(280, 84, 260, 35);
		contentPane.add(createButton);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(40, 155, 120, 35);
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		contentPane.add(elementLabel);
		
		elementField = new JTextField();
		elementField.setBounds(190, 155, 85, 35);
		elementField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(elementField);
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
		contentPane.add(enqueueButton);
		
		popButton = new JButton("POP");
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q == null) {
					displayArea.setText("Create a Queue First");
					return;
				}
				displayArea.setText(q.deque());
			}
		});
		
		popButton.setBounds(480, 146, 140, 50);
		popButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(popButton);
		
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
		contentPane.add(peekButton);
		
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
		contentPane.add(displayButton);
		
		displayArea = new JTextArea();
		displayArea.setMargin(new Insets(10, 10, 2, 10));
		displayArea.setFont(new Font("Times New Roman", Font.BOLD, 30));

		
		scrollArea = new JScrollPane(displayArea,JScrollPane.VERTICAL_SCROLLBAR_NEVER , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollArea.setBounds(40, 290, 606, 60);
		contentPane.add(scrollArea);
		

	}
}
