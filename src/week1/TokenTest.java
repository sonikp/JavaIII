package week1;
// Fig 14.18: StringTokenizer object used to tokenize strings
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenTest
{
	public static void main(String[] args)
	{
		// execute application
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence and press enter");
		String sentence = scanner.nextLine();
		
		// process user sentence
		String[] tokens = sentence.split(" ");
		System.out.printf("Number of elements: %d%nThe Tokens are:%n",tokens.length);
		
		for (String token : tokens)
		{
			System.out.println(token);
		}
	}
}