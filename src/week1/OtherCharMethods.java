package week1;
// Fig 14.17: character class instance methods
public class OtherCharMethods
{
	public static void main(String[] args)
	{
		Character c1 = 'A';
		Character c2 = 'a';
		System.out.printf("c1 = %s%nc2 = %s%n%n", c1.charValue(), c2.toString());
		
		if (c1.equals(c2))
		{
			System.out.println("c1 and c2 are equal");
		}
		else
		{
			System.out.println("c1 and c2 are not equal");
		}
	}
}