package week1;

public class Fig_20_3
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
	
	
	
	
	/*
	 // print array elements using generic method "type-parameter selection" 
	public static <T> void printArray(T[] inputArray)
	{
		//generic method printArray
		for (T element : inputArray)
		{
			System.out.printf("%s, ", element);
		}
		System.out.println("\n");
	}
	*/
	
	
	// generic method after the compiler performs erasure
	public static void printArray(Object[] inputArray)
	{
		//generic method printArray
		for (Object element : inputArray)
		{
			System.out.printf("%s, ", element);
		}
		System.out.println("\n");
	}
	

}