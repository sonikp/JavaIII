package assignmentobserver;




public class InvMainApp
{
	public static void main (String[] args) throws Exception
	{

		
		
		
		InvModel theModel = new InvModel();
		InvController theController = new InvController(theModel);
		InvView theView = new InvView();	//theController, theModel
		
		theController.setTheView(theView);
		
		theModel.setView(theView);
		theModel.setTheController(theController);
		
		// view done
		theView.setModel(theModel);
		theView.setTheController(theController);
		
		theView.start();
		
		
		/*
		 * Notes, clean up the connections with setters and getters
		 */
		
		/*
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
		model.setView(view);

		view.setModel(model);
		view.setctr(model);
		view.setctr();

		view.start();
		*/
		
		// I want to initialize this from the theModel constuctor
//		InvPersistance thePersistance = new InvPersistance();
//		thePersistance.datastoreInitialization();



		
		
		
		
		//==========================Old Shit=============================
		/*
		System.out.println("package assgn;");
		// I can populate the datastore from main, I would like to do it from model layer
//		InvPersistance db = new InvPersistance();
//		db.populateDataTable();
//		db.readDataTable();
//		db.populateSmallTable();
//		db.readSmallTable();
		
		
		
		InvView theView = new InvView();
		InvModel theModel = new InvModel();
		InvController theController = new InvController(theView, theModel);
		theView.setVisible(true);
		*/
		/*
		// wiring together these modules for observers
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
		model.setView(view);

		view.setModel(model);

		view.start();
		*/
		

	}
}