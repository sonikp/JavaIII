package testing;

/*
 * http://javarevisited.blogspot.com/2011/08/enum-in-java-example-tutorial.html
 */

public class TestingEnums
{
	String searchDB;
	String cd[] = {"cd1","cd2","cd3"};
	String dvd[] = {"dvd1","dvd2","dvd3"};
	String book[] = {"book1","book2","book3"};
	
	int loc = 1;
	
	public enum ItemType { CD,DVD,BOOKS };
	
	public void chooseType(ItemType item, int loc)
	{
        switch (item)
        {
        	case CD : System.out.println("Chose: CD: \t" + cd[loc]);
        	break;
        	case DVD : System.out.println("Chose: DVD: \t" + dvd[loc]);
        	break;
        	case BOOKS : System.out.println("Chose: Books: \t" + book[loc]);
        	break;
        }
        
	}
	
	
	public static void main(String[] args)
	{
		
		TestingEnums tester = new TestingEnums();
		ItemType item = ItemType.BOOKS;
		
		tester.chooseType(ItemType.DVD, 2);
		tester.chooseType(item,1);
		
        

        

	}
}