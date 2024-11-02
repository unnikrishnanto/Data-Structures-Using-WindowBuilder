package com.dsimplementation.ui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
    static JPanel contentPanel;
	static CardLayout cardLayout;
//	static JPanel homePanel;
//	static JPanel arrayPanel;

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

	
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 400);
		
		cardLayout = new CardLayout(); 
		contentPanel = new JPanel(cardLayout);
		setContentPane(contentPanel);
		
		JPanel homePanel = new HomeUI();
		JPanel arrayPanel = new ArrayUI();
		JPanel queuePanel = new QueueUI();
		JPanel bstPanel = new BSTUI();
		JPanel circulerQueuePanel = new CircularQueueUI();
		JPanel linkedListPanel = new LinkedListUI();
		JPanel stackPanel = new StackUI();
		 
		contentPanel.add(homePanel, "Home");
		contentPanel.add(arrayPanel, "Array");
		contentPanel.add(queuePanel, "Queue");
		contentPanel.add(stackPanel, "Stack");
		contentPanel.add(circulerQueuePanel, "Circular Queue");
		contentPanel.add(linkedListPanel, "Linked List");
		contentPanel.add(bstPanel, "BST");
		
		
		}
}
