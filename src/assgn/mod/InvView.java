package assgn.mod;

import java.util.Scanner;
import java.awt.event.ActionListener;
import javax.swing.*;


public class InvView extends JFrame
{
	private JTextField prodNumber  = new JTextField(10);
	private JButton setNumberButton = new JButton("Add Number");
	
	
	InvView()
	{
		JPanel inventoryPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200,200);
		
		
		inventoryPanel.add(prodNumber);
		inventoryPanel.add(setNumberButton);
		
		
//		System.out.println("theView Test: " + prodNumber.getText());

		
		this.add(inventoryPanel);
	}
	
	
	
	public String getProdNumber()
	{
		

		return prodNumber.getText();
	}
	
	
	
	
	void addNumberListener(ActionListener listenForAddItemButton)
	{
		
		setNumberButton.addActionListener(listenForAddItemButton);
		
	}


	
}