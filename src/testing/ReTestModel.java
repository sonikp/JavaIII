package testing;


public class ReTestModel
{
	public ReTestModel() throws Exception
	{
		ReTestProperties retest = new ReTestProperties();
		retest.storeData();
	}
	
	public void message()
	{
		System.out.println("MESSAGE");
	}
	
}