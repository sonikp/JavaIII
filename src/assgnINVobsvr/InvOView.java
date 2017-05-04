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
	
	
	public void start() throws Exception {
		

		/*

		// LIST ALL
		theController.getInventoryALL();
		
		// LIST SINGLE
		String itemNum = "100";
		theController.getInventorySingle(itemNum);
		
		*/
		
		/*
		// Observer pattern testing
		int number = 777;
		String valueString = "TestObserverString"; 
//		theController.testObserver(number);
//		theModel.testObserverString(valueString);
		*/
		
		// code for the observer pattern
		System.out.println("Figuring out the (HEX) Observer Pattern");
		
//        Scanner scan = new Scanner(System.in);
//        for (int i = 0; i < 5; i++) {
//            System.out.print("\nEnter a number: ");
//            theModel.setState(scan.nextInt());
//          
//        }
        
        

	}
	
	
	///// Methods///////
	
	public void getItemNumber(){
		
//		System.out.println("DEBUG!!!!");
		theController.getItemNumber();
	}
	
	//////Observer pattern methods
	
//	public void update() {
//		System.out.print(" " + Integer.toHexString(theModel.getState()));
//		
//	}
	
	public void update(){
		System.out.println(theModel.getNewState());
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