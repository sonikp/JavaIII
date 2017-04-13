package week1;
// Fig 14.8 String methods, replace, toLowerCase, toUpperCase, trim & toCharArray
public class StringMiscellaneous2
{
	public static void main(String[] args)
	{
		String s1 = "hello";
		String s2 = "GOODBYE";
		String s3 = "	spaces	";
		
		System.out.printf("s1 = %s%ns2 = %s%ns3 = %s%n%n", s1, s2, s3);
		
		// test replace
		System.out.printf("Replace 'l' with 'L' in s1: %s%n%n", s1.replace('l', 'L'));
		
		// test toLowerCase & toUpperCase
		System.out.printf("s1.toLowerCase() = %s%n", s1.toLowerCase());
		System.out.printf("s2.toUpperCase() = %s%n", s2.toUpperCase());
		
		// test trim method
		System.out.printf("s3 after trim = \"%s\"%n%n", s3.trim());
		
		// test toCharArray
		char[] charArray = s1.toCharArray();
		System.out.print("s1 as a character array = ");
		for (char character : charArray)
		{
			System.out.print(character);
		}
		System.out.println();
		
		
		
		
	}
}