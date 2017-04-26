package assignmentobserver;



public class InvModel implements Subject
{
	private InvView theView;
	private InvController theController;
	private String constStartModel = "constStartModel:";
	private InvPersistance thePersistance; // = new InvPersistance();	// Robert, why do I need to define the class for this?
	private InvPersistance dataStore;
	
	private String name;
	private String title;
	private String number;
	




	
	// constructors	
	public InvModel() throws Exception
	{
//		InvPersistance thePersistanceDuplicate = new InvPersistance();
//		thePersistanceDuplicate.datastoreInitialization();
	}
	
	public InvModel(InvPersistance thePersistance, InvController theController) throws Exception
	{
		System.out.print("constStartModel:");
		this.thePersistance = thePersistance;
		this.theController = theController;
		
		
				

		// Robert, don't understand why this works here and not in the other constructor
//		dataStore.testMessage();
//		dataStore.datastoreInitialization();
//		thePersistance.testMessage();
//		thePersistance.datastoreInitialization();

	}
	


	public void setView(InvView theView) 
	{
		// TODO Auto-generated method stub
		
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