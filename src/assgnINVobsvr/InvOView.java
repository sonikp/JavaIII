package assgnINVobsvr;

import java.util.Scanner;

public class InvOView extends Observer
{

	private InvOController theController;
	private InvOModel theModel;
	
	// default constructor
	public InvOView(){}
	
	public InvOView(InvOModel theModel){
		this.subject = theModel;
		this.theModel.add(this);
	}
	
	
	public void start() {
		
		System.out.println("Start of the Inventory Program Rebuild");
		
		
		
		this.getItemNumber();
		
		/*
		System.out.println("Figuring out the (HEX) Observer Pattern");
		
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("\nEnter a number: ");
            theModel.setState(scan.nextInt());
          
        }
        */

	}
	
	
	///// Methods///////
	
	public void getItemNumber(){
		
//		System.out.println("DEBUG!!!!");
		theController.getItemNumber();
	}
	
	//////Observer pattern methods
	
	public void update() {
		System.out.print(" " + Integer.toHexString(theModel.getState()));
		
	}
	
	// MVC setters and getters
	public void setTheModel(InvOModel theModel) {
		this.theModel = theModel;
	}
	
	public InvOModel getTheModel() {
		return theModel;	
	}

	public void setTheController(InvOController theController) {
		this.theController = theController;	
	}
	
	public InvOController getTheController() {
		return theController;	
	}





	
}