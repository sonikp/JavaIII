package zTBDassgn;

import java.util.Scanner;
import java.awt.event.ActionListener;
import javax.swing.*;




public class InvView extends JFrame 
{
	private JTextField prodNumber  = new JTextField(10);
	private JButton setNumberButton = new JButton("Add Number");
//	InvController theController = new InvController();
	InvModel theModel = new InvModel();
	
	
	InvView() throws Exception
	{
		System.out.println("access backend DB");
		System.out.println("-----------------");
//		Scanner scanner = new Scanner(System.in);
//		String keyName = scanner.nextLine();
		
		String db = "cdInfos";
		String element = "4";
		System.out.println(db + " " + element);
		theModel.accessRecord(db,element);
		
		
		/*
		// - Select items
		System.out.println("which inventory would you like to view");
		System.out.println("1 = CD, 2 = DVD, 3 = BOOKS, 4 = All Items");
		Scanner scanner = new Scanner(System.in);
		String keyName = scanner.nextLine();
		*/
		
		/*
		System.out.println("enter item to delete");
		Scanner scanner = new Scanner(System.in);
		String keyName = scanner.nextLine();
		System.out.println(keyName);
		theModel.searchKey(keyName);
		*/
		
		/*
		// search for a value pair with a key
		System.out.println("enter search item");
		Scanner scanner = new Scanner(System.in);
		String keyName = scanner.nextLine();
		System.out.println(keyName);
		String returnValue = theModel.searchKey(keyName);
		System.out.println("Result for search: " + returnValue);
		*/
		
		/*
		// change an item number
		System.out.println("enter number");
		Scanner scanner = new Scanner(System.in);
		String prodNumb = scanner.nextLine();
		
		System.out.println("Debug:theView:prodNum :" + prodNumb);
		theModel.setNumber(prodNumb);
		*/

	}
	
	
	/*
	// currently not doing anytihing
	public String getProdNumber()
	{
		

		return prodNumber.getText();
	}
	*/
	
	
	/*
	void addNumberListener(ActionListener listenForAddItemButton)
	{
		
		setNumberButton.addActionListener(listenForAddItemButton);
		
	}
	*/


	
}