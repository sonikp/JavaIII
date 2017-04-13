package week1;
// Fig 14.5 String search methods indexOf and lastIndexOf
public class StringIndexMethods
{
	public static void main(String[] args)
	{
		String letters = "abcdefghijklmabcdefghijklm";
		
		// test indexOf to locate a character in a string
		System.out.printf("'c' is located at index %d%n", letters.indexOf('c'));
		System.out.printf("'a' is located at index %d%n", letters.indexOf('a', 1));
		System.out.printf("'$' is located at index %d%n%n", letters.indexOf('$'));
		
		// test lastIndexOf to find a character in a string
		System.out.printf("'c' is located at index %d%n", letters.lastIndexOf('c'));
		System.out.printf("'a' is located at index %d%n", letters.lastIndexOf('a', 25));
		System.out.printf("'$' is located at index %d%n%n", letters.lastIndexOf('$'));
		
		// test indexOf to locate a substring in a string
		System.out.printf("\"def\" is located at index %d%n", letters.lastIndexOf("def"));
		System.out.printf("\"def\" is located at index %d%n", letters.lastIndexOf("def", 27));
		System.out.printf("\"hello\" is located at index %d%n%n", letters.lastIndexOf("hello"));
		
		// test lastIndexOf to find a substring in a string
		System.out.printf("\"def\" is located at index %d%n", letters.lastIndexOf("def"));
		System.out.printf("\"def\" is located at index %d%n", letters.lastIndexOf("def", 25));
		System.out.printf("\"hello\" is located at index %d%n%n", letters.lastIndexOf("hello"));
		
	}
}