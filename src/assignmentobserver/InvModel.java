package assignmentobserver;



public class InvModel implements Subject
{
	private InvView theView;
	private InvController theController;
	private String constStartModel = "constStartModel:";
	private InvPersistance thePersistance; // = new InvPersistance();	// Robert, why do I need to define the class for this?
	
	private String name;
	private String title;
	private String number;
	




	
	// constructors	
	public InvModel() throws Exception
	{
		InvPersistance thePersistance = new InvPersistance();
		thePersistance.datastoreInitialization();
	}
	

	


	public void setView(InvView theView) 
	{
		// reference to that view that the model holds onto for use later
		this.theView = theView;
	}

	public void getStoredValue(String input) throws Exception 
	{
		System.out.println("DBug:Mdl:getStoredValue:input; " + input);
		thePersistance.getStoredValue(input);

		
	}

	public void updateItem() 
	{
		System.out.println("updateItem()");


	}

	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}
	
	
	

	public InvView getTheView() {
		return theView;
	}

	public void setTheView(InvView theView) {
		this.theView = theView;
	}

	public InvController getTheController() {
		return theController;
	}

	public void setTheController(InvController theController) {
		this.theController = theController;
	}

	public InvPersistance getThePersistance() {
		return thePersistance;
	}

	public void setThePersistance(InvPersistance thePersistance) {
		this.thePersistance = thePersistance;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//==========================Old Shit=============================
	
	
//	String valueItem;
//	private int calculationValue;

	/*
	public void deleteKeyValue(String keyName) 
	{

		try 
		{
//			System.out.println("Debug:theModel:setNum: number = " + number);
//			dataStore.writeDataStream(number);
			dataStore.readDataElement(keyName);	// testing read method
			System.out.println("Debug:theModel:searchKey: key = " + keyName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String searchKey(String keyName) 
	{

		try 
		{

			valueItem = dataStore.readDataElement(keyName);	// testing read method
			System.out.println("Debug:theModel:searchKey: key = " + keyName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Debug:theModel:searchKey: returnValue = " + valueItem);
		return valueItem;
	}
	
	public void accessRecord(String db, String number) 
	{

		try {
			System.out.println("Debug:theModel:accessRecord: db " + db + " number = " + number);
			dataStore.readDataTable(db, number);
//			dataStore.writeDataStream(number);
//			dataStore.readDataStream(number);	// testing read method
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	*/
	/*
	
	public void setNumber(String number) 
	{

		try {
			System.out.println("Debug:theModel:setNum: number = " + number);
			dataStore.writeDataStream(number);
			dataStore.readDataStream(number);	// testing read method
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getNumber()
	{
		return dataStore.getProdID();
	}
	
	*/
	


	
}