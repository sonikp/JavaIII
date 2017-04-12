package week1;
// Fig 20.11: RawTypeTest.java; 
public class RawTypeTest
{
	public static void main (String[] args)
	{
		Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
		Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// Stack of raw types assigned to Stack of raw type variable
		Stack rawTypeStack1 = new Stack(5);
		
		// Stack<Double> assigned to Stack of raw type variables
		Stack rawTypeStack2 = new Stack<Double>(5);
		
		// Stack of raw types assigned to Stack<Integer> variable
		Stack<Integer> integerStack = new Stack(10);
		
		testPush("rawTypeStack1", rawTypeStack1, doubleElements);
		testPop("rawTypeStack1", rawTypeStack1);
		testPush("rawTypeStack2", rawTypeStack2, doubleElements);
		testPop("rawTypeStack2", rawTypeStack2);
		testPush("integerStack", integerStack, integerElements);
		testPop("integerStack", integerStack);
		
		// generic method pushes elements onto stack
		public static <T> void testPush(String name, Stack<T> stack, T[] elements)
		{
			System.out.printf("%nPushing elements onto %s%n", name);
			
			// push elements onto Stack
			for (T element : elements)
			{
				System.out.printf("%s ", elements);
				stack.push(element);
			}
		}
		
		// generic method testPop pops element from Stack
		public static <T> void testPop(String name, Stack<T> stack)
		{
			// pop elements from stack
			try
			{
				System.out.printf("%nPopping elements from %s%n", name);
				T popValue;		// store element removed from stack
				
				while (true)
				{
					popValue = stack.pop();	// pop value from stack
					System.out.printf("%s ", popValue);
				}
			}
			catch(EmptyStackExceptio emptyStackException)
			{
				System.out.println();
				emptyStackException.printStackTrack();
			}

		}
		
	}
}