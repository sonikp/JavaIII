package assgn.add;



public class InvMainApp
{
	public static void main (String[] args)
	{
		
		InvView theView = new InvView();
		InvModel theModel = new InvModel();
		InvController theController = new InvController(theView, theModel);
		theView.setVisible(true);

	}
}