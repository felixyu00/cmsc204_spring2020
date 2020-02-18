/**
 * ArraySum class that contains methods for calls from ArraySumDriver
 * The two methods are sumOfArray and fibonacci for calculing
 * the sum of Integers within an Array and a fibonacci number
 * respectively.
 * @author felixyu00
 *
 */
public class ArraySum {

	private int result;

	public int sumOfArray(Integer[] myArray, int i) {
		//recursive method to calculate sum of an array
	     if (i == 0) {  // base case
	         result = 0;
	     }
	     else {
	    	 result = myArray[i-1] + sumOfArray(myArray,(i-1));
	     }
	     return result;
	}//end of sumOfArray
	
	 public int fibonacci(int n) {
		 //recursive method to determine fibonacci sequence
		 if ((n == 0) || (n == 1)) { //base case
	         return n; 
		 }
		 else {
			 return fibonacci(n- 1) + fibonacci(n - 2);
		 }
	 }//end of fibonacci
}//end of ArraySum class
