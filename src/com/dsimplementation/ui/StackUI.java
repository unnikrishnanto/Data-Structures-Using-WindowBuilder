package com.dsimplementation.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import com.dsimplementation.datastructures.Stack;
import com.dsimplementation.util.RoundedButton;
import com.dsimplementation.util.SquareButtons;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class StackUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField sizeField;
	private JButton createButton;
	private JTextField elementField;
	private JButton pushButton;
	private JButton popButton;
	private JButton peekButton;
	private JButton displayButton;
	private JTextPane displayPane;
	private JScrollPane sp;
	private Stack stack;
	

	
	public StackUI() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(219, 211, 211));
	    setLayout(null);
		
		
		JTextArea title = new JTextArea("STACK");
		title.setEditable(false);
		title.setEnabled(false);
		title.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		title.setBackground(null);
		title.setDisabledTextColor(new Color(255, 131, 5));
		title.setBounds(280, 10, 102, 44);
		add(title);
		
		JLabel sizeLabel = new JLabel("SIZE");
		sizeLabel.setBounds(39, 84, 85, 35);
		sizeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(sizeLabel);

		
		sizeField = new JTextField();
		sizeField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sizeLabel.setForeground(new Color(2, 76, 170));
		sizeField.setBounds(152, 84, 85, 35);
		add(sizeField);
		sizeField.setColumns(10);
		
		createButton = new SquareButtons("<html>CREATE<br>STACK</html>", 20);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int size = Integer.parseInt(sizeField.getText());
					stack = new Stack().createStacK(size);
					displayPane.setText("Stack of\n Size\n" +size+ "\nCreated.");
				} catch (Exception ex) {
					displayPane.setText("Enter\na\nvalid\nsize.");
				}
			}
		});
		createButton.setBounds(280, 76, 140, 50);
		add(createButton);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setBounds(39, 159, 120, 35);
		elementLabel.setForeground(new Color(2, 76, 170));
		elementLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 33));
		add(elementLabel);
		
		elementField = new JTextField();
		elementField.setBounds(188, 159, 85, 35);
		elementField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(elementField);
		elementField.setColumns(10);
		
		
		pushButton = new SquareButtons("PUSH", 30);
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(stack == null) {
					displayPane.setText("Create\na\nStack\nFirst");
					return;
				}
				try {
					int element = Integer.parseInt(elementField.getText());
					if(stack.push(element)) {
						displayPane.setText("Pushed\n" + element);
					} else {
						displayPane.setText("Stack\nIs\nFull");
					}
				} catch (Exception ex) {
					displayPane.setText("Ente\na\nvalid\nelement.");
				}
			}
		});
		pushButton.setBounds(280, 150, 140, 50);
		add(pushButton);
		
		popButton = new SquareButtons("POP", 30);
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(stack == null) {
					displayPane.setText("Create\na\nStack\nFirst");
					return;
				}
				displayPane.setText(stack.pop());
			}
		});
		
		popButton.setBounds(39, 226, 140, 50);
		add(popButton);
		
		peekButton = new SquareButtons("PEEK", 30);
		peekButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(stack == null) {
					displayPane.setText("Create\na\nStack\nFirst");
					return;
				}
				
				displayPane.setText(stack.peek());
			}
		});
		peekButton.setBounds(280, 226, 140, 50);
		add(peekButton);
		
		displayButton = new SquareButtons("DISPLAY");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(stack == null) {
					displayPane.setText("Create\na\nStack\nFirst");
				} else {
					displayPane.setText(stack.getStack());

					 // Ensure the viewport is set to the top-left corner
		            SwingUtilities.invokeLater(new Runnable() {
		                public void run() {
		                    sp.getViewport().setViewPosition(new Point(0, 0));
		                }
		            });
				}
			}
		});
		displayButton.setBounds(152, 288, 140, 50);
		add(displayButton);

		
		displayPane = new JTextPane();
		displayPane.setDisabledTextColor(new Color(0, 0, 0));
		displayPane.setText("Create\na\nStack.");
		displayPane.setEditable(false);
		displayPane.setEnabled(false);
		displayPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		displayPane.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		// Center-align the content
        StyledDocument doc = displayPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
        // wrap the text pane to display scroll bar when needed
		sp = new JScrollPane(displayPane ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(509, 43, 126, 295);
		add(sp);
		
		ImageIcon closeIcon  =new ImageIcon(getClass().getResource("/resources/closeButton.png"));
		RoundedButton backButton = new RoundedButton(30, closeIcon, 1);
		backButton.addActionListener(e -> MainFrame.cardLayout.first(MainFrame.contentPanel) );
		backButton.setBounds(640, 20, 30, 30);		
		add(backButton);
	}

}
