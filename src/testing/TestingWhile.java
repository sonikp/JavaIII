package testing;

// http://www.overclock.net/a/java-how-to-loop-a-program-to-keep-running

import java.util.Scanner;

public class TestingWhile
{
	static private int choice = 0;
	static private boolean exit = false;
	static private boolean anotherChoice = true;
	

	static Scanner sc;
	
	public void startMainMenu()
	{
//		exit = false;
//		anotherChoice = true;
//		
//		System.out.println("hello, welcome to inventory system");
		
		do 
		{
//			System.out.println("1 = Create, 2 = Retrieve (List), 3 = Update, 4 = Delete, 5 = Quit\n");
			
			if (anotherChoice == true)
			{
				this.menuPanel();
				System.out.print("Enter Selection: ");
				choice = sc.nextInt();
//				System.out.print("You entered : " + choice + " exit status " + exit);
				
				if (choice < 0 || choice > 5) 
				{
					System.out.println(choice + " ...not an option, try again\n");
					anotherChoice = true;
				}
				else
				{
					
					
					switch(choice)	// choose for main menu
					{
						case 1:
						{
							System.out.println("\nCreate " + choice);
							
							break;
						}
						case 2:
						{
							System.out.println("\nRetireve (List) " + choice);
							
							break;
						}
						case 3:
						{
							System.out.println("\nUpdate " + choice);
							
							break;
						}
						case 4:
						{
							System.out.println("\nDelete " + choice);
							
							break;
						}
						case 5:
						{
							System.out.println("\nQuit " + choice);
							exit = true;
							break;
						}
					
					}
					
					
				}

			}
			
		} while ( exit == false);

		
	}

	
		
		



	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
        TestingWhile tw = new TestingWhile();
        tw.startMainMenu();
       
    }
		
	
	public void menuPanel()
	{
		 System.out.println("\n\n------------------------------------");
	        System.out.println("|    Inventory CRUD System     !    |");
	        System.out.println("|-----------------------------------|");
	        System.out.println("|                                   |");
	        System.out.println("| Main Menu:                        |");
	        System.out.println("| ----------                        |");
	        System.out.println("|                                   |");
	        System.out.println("| 1.) Create a record!              |");
	        System.out.println("| 2.) Retrieve(List) all items!     |");
	        System.out.println("| 3.) Update a record!              |");
	        System.out.println("| 4.) Delete a record!              |");
	        System.out.println("| 5.) Exit!                         |");
	        System.out.println("|                             v 1.0 |");
	        System.out.println("-------------------------------------");
	}
	

	
	

		
		
		
}

