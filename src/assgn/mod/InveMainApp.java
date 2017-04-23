package assgn.mod;



public class InveMainApp
{
	public static void main (String[] args)
	{
		
		InveView theView = new InveView();
		InveModel theModel = new InveModel();
		InveController theController = new InveController(theView, theModel);
		theView.setVisible(true);

	}
}