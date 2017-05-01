package zTBDobserverMVC;

import java.util.Scanner;

class Viewer extends Observer 
{
	


	public Viewer(Model subject) 
	{
        this.different = subject;	// this is a reference to the abstract observer class
        this.different.add(this);
    }
    

    public void update() 
    {
        System.out.print(" " + Integer.toHexString(different.getState()));
    }
    



}
