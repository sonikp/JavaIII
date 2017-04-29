package testing;

// http://www.overclock.net/a/java-how-to-loop-a-program-to-keep-running

import java.util.Scanner;

public class TestingWhile
{
	static private String choice;
	static private boolean exit = false;
	static private boolean anotherChoice = true;
	

	static Scanner sc;
	
	public void start()
	{
		System.out.println("hello, welcome to inventory system");
		while (exit == false)
		{
			System.out.println("Q = Quit, L = List\n");
			if (anotherChoice = true)
			{
				choice = sc.nextLine().toString().toUpperCase();
				System.out.print("You entered : " + choice + " exit status " + exit);
				if (choice != "Q" && choice != "L")
				{
					System.out.println(choice + " ...not an option, try again\n");
				}
				else if (choice == "L")
				{
					System.out.println("Do stuff with " + choice);
				}
				else if (choice == "Q")
				{
					System.out.println(choice + "you chose good bye");
					exit = true;
				}
			}
			
		}
		System.out.println("Finished");
	}
	
		
		
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
        TestingWhile tw = new TestingWhile();
        tw.start2();
       
    }
		
	
	public void start2()
	{
		char ch = 'd';
		if( ch!='y' && ch!='Y') 
		{
		    System.out.println("foo");
		}
	}
	
	
	/*
		
	 do {
        	
        	while (!Exit.equals(choice))
        	{
        		System.out.println("Do Not enter 'Q': \n");
                choice = sc.nextLine().toString().toUpperCase();
                System.out.println("you entered : " + choice);
        	}
        		
        		
        		
            
            
            
            
        } while (!Exit.equals("Q"));	// while this statement = true keep doing
        System.out.println("Fin!");
		
	*/
		
		
		
}