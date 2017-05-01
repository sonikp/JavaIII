package observerMVC;

import java.util.Scanner;



public class ObserverMainApp 
{
    public static void main( String[] args ) 
    {
        Model theModel = new Model();
        // Client configures the number and type of Observers
        new Viewer(theModel);
        
    	Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) 
        {
            System.out.print("\nEnter a number: ");
            theModel.setState(scan.nextInt());
           
        }
        scan.close();
       

        
    }
}