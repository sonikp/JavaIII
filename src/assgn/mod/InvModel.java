package assgn.mod;


public class InvModel
{
	InvPersistance dataStore = new InvPersistance();
//	private int calculationValue;
	
	
	// constructor: empty
	public InvModel()
	{
		
	}
	
	
	public void setNumber(String number) 
	{

		try {
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