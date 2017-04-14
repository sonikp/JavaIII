package week1;


public class foo
{
	public static void main(String[] args)
	{
		String string1 = "hello";
		String string2 = "BC";
		int value = 22;
		
		String s = string1 + string2 + value;
		System.out.printf("Adding results in %s%n", s);
		String t = new StringBuilder().append("hello").append("BC").append(22).toString();
		System.out.printf("Adding results in %s%n", t);
	}


}
