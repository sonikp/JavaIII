package assgnINVobsvr;

import java.util.ArrayList;
import java.util.List;






public class InvOModel extends Subject
{
	
//	private InvOView theView;
	private InvOController theController;
	private InventoryPersistance thePersistance;
	
	private List<Observer> observers = new ArrayList<>();
    private int state;
    
    private String itemNum;
    private String itemType;
    private String title;
	private String artist;
	private String productCode;
	private String quantity;
	
	// constructor
	public InvOModel() throws Exception {
		thePersistance = new InventoryPersistance();
	}
	
	///// Methods///////
	
	public void getItemNumber() {
//		System.out.println("DEBUG!!!!");
		thePersistance.getItemNumber();
		
	}
	
	
	public void setItemNum() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	/////////////////////////////////////////////
	// Subject is the Model in MVC///////////////
	/////////////////////////////////////////////
	
	/*
	public void add(Observer o) {
        observers.add(o);
    }

    public int getState() {
        return state;
    }

    public void setState(int value) {
        this.state = value;
        System.out.println("DB:Subject.setState = value ::" + value);
        execute();
    }

    private void execute() {
    	System.out.println("Debug: Observers.execute() ENTERED" );
//    	System.out.println("!!!Debug " + observers.get(0));
        for (Observer observer : observers) 		// there is nothing registered here
        {      	
        	System.out.println("Debug: Observers.execute() " + observer );
        	observer.update();
        }
    }
	*/
	
	
	/////////////////////////////////////////////

	
	// MVC setters and getters
	public void setTheController(InvOController theController) {
		this.theController = theController;
	}
	
	public InvOController getTheController(){
		return theController;
	}


	
	
//	public void setTheView(InvOView theView) {
//		this.theView = theView;	
//	}
//	
//	public InvOView getTheView(){
//		return theView;
//	}





}