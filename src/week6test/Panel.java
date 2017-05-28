package week6test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel
{
	
	JFrame frame;
	JPanel panel1, panel2, panel3, panel4;
	
	static String content = "Here men from the planet Earth\n"
		      + "first set foot upon the Moon,\n" + "July 1969, AD.\n"
		      + "We came in peace for all mankind.";
	
	public Panel()
	{
		frame = new JFrame("JFrame test");
		frame.setSize(800, 400);
		frame.setLayout(new BorderLayout());
		
		// new GridLayout()
		// new BorderLayout()
		
		panel1 = new JPanel(new GridLayout(2,0));
		panel2 = new JPanel(new FlowLayout());
		panel3 = new JPanel(new FlowLayout());
		panel4 = new JPanel(new GridLayout(2,0));

		
		
		JButton button1 = new JButton("button1");
		JButton button2 = new JButton("button2");
		JButton button3 = new JButton("button3");
		JButton button4 = new JButton("button4");
		JButton button5 = new JButton("button5");
		JButton button6 = new JButton("button6");
		JButton button7 = new JButton("button7");
		JButton button8 = new JButton("button8");	
		JButton button9 = new JButton("button9");
		JButton button10 = new JButton("button10");
		JButton button11 = new JButton("button11");
		JButton button12 = new JButton("button12");
		
		JTextArea textArea = new JTextArea(content);
		JScrollPane scrollPane = new JScrollPane();

		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		panel2.add(new JScrollPane(new JTextArea(content, 3, 3)));
		
		panel3.add(button7);
		panel3.add(button8);
		panel3.add(button9);
		
		panel4.add(button10);
		panel4.add(button11);
		panel4.add(button12);
		
		
//		// BorderLayout
//		panel1.add(button1, BorderLayout.NORTH);
//		panel1.add(button2, BorderLayout.SOUTH);
//		panel1.add(button3, BorderLayout.EAST);
//		panel1.add(button4, BorderLayout.WEST);
		
		

		frame.add(panel1, BorderLayout.WEST);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
		frame.add(panel4, BorderLayout.EAST);
		
		

		// ending frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200,600);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new Panel();
	}
}