package assgnINVobsvr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;






public class InvOModel extends Subject
{
	
	private InvOView theView;
	private InvOController theController;
	private InventoryPersistance thePersistance;
	
	private List<Observer> observers = new ArrayList<>();
    private int state;
    
    private String itemNum = "666";
    private String itemType = "PS4";
    private String title = "Great Book";
	private String artist = "Bozo the Guitarist";
	private String studio = "Studio One";
	private String author = "Angry the Scribe";
	private String productCode = "PC-789";
	private String UPCCode = "UPC-789";
	private String ISBN = "ISBN-789";
	private String quantity = "444";
	
	private String listInventoryViewALL;		
	private String listInventoryViewSingle;		
	
	// constructor
	public InvOModel() throws Exception {
		super();
		thePersistance = new InventoryPersistance(this);
	}
	
	
	///// Methods///////
	
	public void returnItemNum(String nextCDItemNum){
		System.out.println(nextCDItemNum);
//		returnItemNum(nextCDItemNum);
	}
	
	public void getItemNumber() {
//		System.out.println("DEBUG!!!!");
		thePersistance.getItemNumber();
		
	}
	
	
//	public void setItemNum() {
//		// TODO Auto-generated method stub
//		
//	}
	
	

	
	
	public void getInventoryALL() throws IOException {
		thePersistance.getInventoryALL();
		
	}
	
	public void listInventoryViewALL(String listInventoryViewALL) {
		this.listInventoryViewALL = listInventoryViewALL;	
		System.out.println(this.listInventoryViewALL);	//DEBUG
//		int value = 777;
//		this.setState(value);
//		String someString = "ObserverNotification";
//		this.setNewState(someString);
	}
	
	public void testObserver(int number){
		this.setState(number);
	}
	
	public void testObserverString(String valueString){
		this.setNewState(valueString);
	}



	public void getInventorySingle(String itemNum) throws IOException {
		thePersistance.getInventorySingle(itemNum);
	}
	
	public void listInventoryViewSingle(String listInventoryViewSingle) {
		this.listInventoryViewSingle = listInventoryViewSingle;
		System.out.println(this.listInventoryViewSingle);	//DEBUG
	}

	///////////////////////////////
	// MVC setters and getters
	public void setTheController(InvOController theController) {
		this.theController = theController;
	}
	
	public InvOController getTheController(){
		return theController;
	}


	
	public void setTheView(InvOView theView) {
		this.theView = theView;	
	}
	
	public InvOView getTheView(){
		return theView;
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




}