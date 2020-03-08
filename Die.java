import java.util.Random;

/**
 * Program Title: Die |
 * Created: 29/02/2020 |
 * This class simulates the behaviour of a Die
 * @author Marius Evans
 * @version 1
 */
public class Die
{
	private int faceValue; // Current face value of die
	private int sides; // Number of sides
	private Random generator;

	/**
	 * Constructs a Die with a specified number of sides.
	 * @param sides the number of sides of the die
	 */
	public Die(int sides){
		generator = new Random();
		this.sides = sides;
		faceValue = generator.nextInt(this.sides) + 1; //random integer value between 1 and sides inclusive
	}
	
	/**
	 * Throws a die, changing its faceValue to a random number between 1 and the number of sides of the die
	 */
	public void throwDie(){
		generator = new Random();
		faceValue = generator.nextInt(sides) + 1; //random integer value between 1 and sides inclusive
	}
	
	/**
	 * Returns the face value of the die
	 * @return faceValue the face value of the die
	 */
	public int getFaceValue(){
		return faceValue;
	}
	
	/**
	 * Returns a String representation of the Die object
	 * @return The face value of the Die and the number of sides it has
	 */
	public String toString() {
		return getClass().getName()+"[faceValue="+faceValue+", sides="+sides+"]";
	}
}