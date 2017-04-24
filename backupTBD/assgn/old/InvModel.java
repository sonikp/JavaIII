package assgn.old;

import TBD.InvPersistanceOLD;

public class InvModel
{
	InvPersistanceOLD dataStore = new InvPersistanceOLD();
//	private String title;
//	private String number;
	private int calculationValue;
	
	
	// constructor: empty
	public InvModel()
	{
		
	}
	
	/*
	// constructor: single title
	public InvModel(String title)
	{
		this.title = title;
	}
	*/

	/*
	// constructor: 
	public InvModel(String title, String number)
	{
		this.title = title;
		this.number = number;
	}
	*/
	
	public void setNumber(String number) // throws Exception
	{
		System.out.println("Debug: Model: " + number);
		dataStore.setProdID(number);
		System.out.println("MoreDebugfromPersisLayer : " + dataStore.getProdID());
		dataStore.getProdID();
		try {
			dataStore.writeDataStream(number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getNumber()
	{
		
		return dataStore.getProdID();
	}
	
	/*
	// for calculate action listener in controller
	public void addTwoNumbers(int firstNumber, int secondNumber){
		
		calculationValue = firstNumber + secondNumber;
		
	}
	
	public int getCalculationValue(){
		
		return calculationValue;
		
	}	
	*/
	
	/*
	// setters and getters
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setNumber(String number)
	{
		this.number = number;
	}
	*/
	/*
	public String getNumber()
	{
		return number;
	}
	*/
	/*
	public String toString()
	{
		 return "title: " + title
				 + "number: " + number;
		 
	}
	*/



	
}