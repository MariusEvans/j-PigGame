/**
 * Program Title: DieTester |
 * Created: 29/02/2020 |
 * This class tests the Die class and all of its methods.
 * @author Marius Evans
 * @version 1
 */
public class DieTester {
	/**
	 * This is the main method of the DieTester class, used as a test driver for the Die class
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Die die1 = new Die(6);
		
		System.out.println("DieTester running ...\n");
		
		//test constructor
		System.out.println("Test 1: Test Constructor using toString");
		System.out.println(die1);
		
		//test the getFaceValue method
		System.out.println("\nTest 2: Test getFaceValue");
		System.out.println("\nInspecting die face ...");
		System.out.println("Face value = "+die1.getFaceValue()+"\n");
		
		//test the throwDie method
		System.out.println("Test 3: Test throwDie");
		System.out.println("Die is being thrown ...");
		System.out.print("Face values generated ");
		
		for(int i = 0; i<36; i++) { //roll the dice 36 times
			die1.throwDie();
			if(i!=35) {
				System.out.print(die1.getFaceValue()+", ");
			} else {
				System.out.print(die1.getFaceValue()); //do not add comma to output if it is the last roll
			}
		}
		System.out.println("\n\nTest finished");
	}

}
