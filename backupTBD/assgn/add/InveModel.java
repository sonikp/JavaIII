package assgn.add;


public class InveModel
{
	InvePersistance dataStore = new InvePersistance();
//	private int calculationValue;
	
	
	// constructor: empty
	public InveModel()
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