/**
 * 
 * A class that serves as the test driver for the LinkedQueue class
 * The class utilizes the LinkedQueue class for storing employee and
 * displaying employee object information. It illustrates the usage of 
 * implemented QueueInterface methods from the LinkedQueue class.
 * 
 * @author felixyu00
 *
 */

public class Employment {
   
	public static void main(String[] args) throws EmptyQueueException {

	  //initiating variables and creating a LinkedQueue object 
	  QueueInterface<Employee> eList;
      eList = new LinkedQueue<>();
      int num = 1;
      
      //adding employee objects into the queue
      eList.enqueue(new Employee("Gary", "Thai"));
      eList.enqueue(new Employee("Felix", "Yu"));
      eList.enqueue(new Employee("LeBron", "James"));
      eList.enqueue(new Employee("Bill", "Gates"));
      //eList.enqueue(new Employee("Leo", "Messi"));
      //eList.enqueue(new Employee("Billie", "Eilish"));
      
      //example of the getFront() validating: displaying the first object in the queue
      System.out.println("The first employee of the company is " + eList.getFront().toString());
      System.out.println("");
      
      //example of size() method: validating the size of the queue
      System.out.println("Currently, the company has " + eList.size() + " employee(s).");
      System.out.println("");
      
      //using dequeue to remove the object at the front of the queue and display the original
      //order of employee addition into the company
      System.out.println("Here are the employees:");
      while (!eList.isEmpty()) {
         Employee emp = eList.dequeue();
         System.out.println("Employee #" + num + ": " + emp.getFirstName() + " " + emp.getLastName());
         num ++;
      }
      System.out.println("");
      
      //after dequeue of the entire queue, the size() will return zero as the queue is empty
      System.out.println("After the company was sold, it has " + eList.size() + " employee.");
   }
}