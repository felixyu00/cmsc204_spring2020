public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		ArraySum arraySum = new ArraySum();
		
		myArray[index++] = 3;
		myArray[index++] = 5;
		myArray[index++] = 2;
		myArray[index++] = 6;
		
		//sumOfArray use case - should yield 3+5+2 = 10
		int sum = arraySum.sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		//sumOfArray use case - should yield 3+5+2+6+7 = 23
		sum = arraySum.sumOfArray(myArray, 5);
		System.out.println(sum);
		
		//fibonacci use case - 12 position should yield number 144
		System.out.println(arraySum.fibonacci(12));
		
	}

}