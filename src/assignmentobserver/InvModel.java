package assignmentobserver;


public class InvModel
{
	private InvView theView;
	private InvController theController;
	private InvPersistance thePersistance = new InvPersistance();	// Robert, why do I need to define the class for this?

//	InvPersistance dataStore = new InvPersistance();
	
	// instance variables
	private String valueItem;
	
	
	public InvModel()
	{

	}
	





	
	
	// constructor:	
	public InvModel(InvPersistance thePersistance, InvController theController) throws Exception
	{
		this.thePersistance = thePersistance;
		this.theController = theController;
//		System.out.println("init model");
		// Robert, don't understand why this works here and not in the other constructor
//		dataStore.testMessage();
//		dataStore.datastoreInitialization();
	}
	
	/*
	// constructor: 
	public InvModel(InvView theView, InvController theController) throws Exception	
	{

		this.theView = theView;
		this.theController = theController;
//		dataStore.testMessage();
//		dataStore.datastoreInitialization();

	}
	*/


	public void setView(InvView theView) {
		// TODO Auto-generated method stub
		
	}

	public void getValue(String input) throws Exception 
	{
		System.out.println("DBug:Mdl:getValue:input; " + input);
//		thePersistance.getValue(input);
		// Robert: why doesn't this object work?
		thePersistance.getValue(input);
		thePersistance.testMessage();
		
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