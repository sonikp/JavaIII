package testing;

/*
 * http://javarevisited.blogspot.com/2011/08/enum-in-java-example-tutorial.html
 */

import java.util.Scanner;

import assignmentobserver.InvView.ItemType;

public class TestingEnums
{
	String searchDB;
	String cd[] = {"cd1","cd2","cd3"};
	String dvd[] = {"dvd1","dvd2","dvd3"};
	String book[] = {"book1","book2","book3"};
	
	int loc = 1;
	
	public enum ItemType { CD,DVD,BOOKS,ALL };
	
	public void chooseType(ItemType item)
	{
        switch (item)
        {
        	case CD : System.out.println("Chose: CD: \t");
        	break;
        	case DVD : System.out.println("Chose: DVD: \t");
        	break;
        	case BOOKS : System.out.println("Chose: Books: \t");
        	break;
        	case ALL : System.out.println("Chose: ALL: \t");
        }
        
	}
	
	
	public static void main(String[] args)
	{
		
		TestingEnums tester = new TestingEnums();
		ItemType item = ItemType.ALL;
		
		System.out.println("Choose option");
		Scanner input = new Scanner(System.in);
		
		ItemType value = ItemType.valueOf(input.next().toUpperCase());
		System.out.println("value: " + value);
		

		
		

		tester.chooseType(value);
		
        

        

	}
}