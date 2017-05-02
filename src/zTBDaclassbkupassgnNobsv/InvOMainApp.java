package zTBDaclassbkupassgnNobsv;

// https://sourcemaking.com/design_patterns/observer/java/1

import java.util.Scanner;

public class InvOMainApp
{
	public static void main(String[] args)
	{
		// Create objects
		InvOModel theModel = new InvOModel();
		InvOController theController = new InvOController();
		InvOView theView = new InvOView();
		
		// Link objects
		theController.setTheView(theView);
		theController.setTheModel(theModel);
		
		theModel.setTheView(theView);
		theModel.setTheController(theController);
		theModel.add(theView);
		
		theView.setTheModel(theModel);
		theView.setTheController(theController);
		
		/*
		System.out.println("Figuring out the (HEX) Observer Pattern");
		
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) 
        {
            System.out.print("\nEnter a number: ");
            theModel.setState(scan.nextInt());
            System.out.println("Subject state" + theModel.getState());
        }
        */

		
		theView.start();
		
	}
}