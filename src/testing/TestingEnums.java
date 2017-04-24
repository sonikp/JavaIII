package testing;

public class TestingEnums
{
	public enum UserStatus {
	    PENDING,
	    ACTIVE,
	    INACTIVE,
	    DELETED;
	}
	
	public enum ItemType {
	    CD,
	    DVD,
	    BOOKS;
	}
	
	
	public static void main(String[] args)
	{
		//ACTIVE
        System.out.println(ItemType.CD);
	}
}