package zTBDassgn;


public class InvModel 
{
	private InvView theView;
	private InvController theController;

	InvPersistance dataStore = new InvPersistance();



	String valueItem;
//	private int calculationValue;
	
	
	// constructor:	
	public InvModel() throws Exception
	{

	}
	
	
	
	// constructor: my attempt to start the persistance layer from the model
	public InvModel(InvView theView, InvController theController) throws Exception	//
	{
		this.theView = theView;
		this.theController = theController;
		dataStore.populateDataTable();
//		dataStore.readDataTable();
	}
	
	
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
	


	
}