package assgn.add;

import java.util.Scanner;
import java.awt.event.ActionListener;
import javax.swing.*;


public class InvView extends JFrame
{
	private JTextField prodNumber  = new JTextField(10);
	private JButton setNumberButton = new JButton("Add Number");
	
//	private JTextField firstNumber  = new JTextField(10);
//	private JButton addItemNumberButton = new JButton("Add Item Number");
	private JLabel additionLabel = new JLabel("+");
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("Calculate");
	private JTextField calcSolution = new JTextField(10);

	
	InvView()
	{
		JPanel inventoryPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200,200);
		
		inventoryPanel.add(prodNumber);
		inventoryPanel.add(setNumberButton);
		
//		inventoryPanel.add(firstNumber);
//		inventoryPanel.add(additionLabel);
//		inventoryPanel.add(secondNumber);
//		inventoryPanel.add(calculateButton);
//		inventoryPanel.add(calcSolution);
		
		/*
		inventoryPanel.add(firstNumber);
//		inventoryPanel.add(addItemNumberButton);
		inventoryPanel.add(additionLabel);
		inventoryPanel.add(secondNumber);
		inventoryPanel.add(calculateButton);
		inventoryPanel.add(calcSolution);
		*/
		System.out.println("theView Test: " + prodNumber.getText());

		
		this.add(inventoryPanel);
	}
	
	public String getProdNumber()
	{
		return prodNumber.getText();
	}
	
	/*
	public int getFirstNumber()
	{
		return Integer.parseInt(prodNumber.getText());
//		return Integer.parseInt(firstNumber.getText());
	}
	
	public int getSecondNumber()
	{
		return Integer.parseInt(secondNumber.getText());
	}
	
	public int getCalcSolution()
	{
		return Integer.parseInt(calcSolution.getText());
	}
	*/

	
	/*
	public void setCalcSolution(int solution)		// String string
	{
		calcSolution.setText(Integer.toString(solution));
		//calcSolution.setText(string);
	}
	*/
	
	void addNumberListener(ActionListener listenForCalcButton)
	{
		
		setNumberButton.addActionListener(listenForCalcButton);
		
	}
	/*
	void addCalculateListener(ActionListener listenForCalcButton)
	{
		
		calculateButton.addActionListener(listenForCalcButton);
		
	}
	*/
	
	/*
	Scanner scanner = new Scanner(System.in);
	private String welcomeMessage1 = "this is an inventory project";
	private String welcomeMessage2 = "please add an item,\nenter item number: ";
	private int itemNumber;
	
	public InvView()
	{
		System.out.println(welcomeMessage2);
		getUserInput(scanner);
		
		System.out.println("you entered: " + getItemNumber());
	}
	
	public void getUserInput(Scanner input)
	{
		itemNumber = scanner.nextInt();
	}

	
	public int getItemNumber(){
		
		return Integer.parseInt(scanner.nextLine());
		
	}
	*/
	
	/*
	
	//private String itemName;
	// my previous stuff
		// constructor: empty
	public InvView()
	{
		System.out.println("DEBUG: InvView Object");
		System.out.println(welcomeMessage1);
		System.out.println(welcomeMessage2);
		
		// set itemName
		setUserInput(scanner);
		
		// check itemName was set
		System.out.println(getItemNumber());

	}
	
	
	public void setUserInput(Scanner input)
	{
		itemNumber = scanner.nextInt();
	}
	
	
	
	public int getItemNumber()
	{
		return Integer.parseInt(scanner.nextLine());
	}
	
	
	public void setUserInput(Scanner input)
	{
		itemName = scanner.nextLine();
	}
	*/
	

	
	
	
	/*
	public String getItemName()
	{
		return itemName;
	}

	*/

	
}