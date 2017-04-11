package week1;

public class Fig_20_1
{
	public static void main(String[] args)
	{
		// create arrays
		Integer[] integerArray = {1, 2, 3, 4, 5, 6};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
		
		System.out.printf("Array intArray contain:%n");
		printArray(integerArray);
		
		System.out.printf("Array dblArray contain:%n");
		printArray(doubleArray);
		
		System.out.printf("Array chrArray contain:%n");
		printArray(characterArray);
	}
	
	public static void printArray(Integer[] inputArray)
	{
		//display array elements
		for (Integer element : inputArray)
		{
			System.out.printf("%s, ", element);
		}
		System.out.println("\n");
	}
	
	public static void printArray(Double[] inputArray)
	{
		//display array elements
		for (Double element : inputArray)
		{
			System.out.printf("%s, ", element);
		}
		System.out.println("\n");
	}
	
	public static void printArray(Character[] inputArray)
	{
		//display array elements
		for (Character element : inputArray)
		{
			System.out.printf("%s ", element);
		}
		System.out.println("\n");
	}
}