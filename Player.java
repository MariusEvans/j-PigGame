/**
 * Program Title: Player |
 * Created: 29/02/2020 |
 * This class creates a Player that has a turn status and score
 * @author Marius Evans
 * @version 1
 */
public class Player{
	private int score; //The Player's score
	private boolean turnOver; //The player's turn status
	
	 /**
	  * This constructor makes a Player with a specified score, their turn is not over by default.
	  * @param initialScore the initial score for the Player
	  */
	 public Player(int initialScore)
	 {
		 score = initialScore;
		 turnOver = false;
	 }
	
	 /**
	  * This method increases the score of the Player by the specified amount
	  * @param points the points to increase the score by
	  */
	 public void setScore(int points)
	 {
		 score += points;
	 }
	 
	 /**
	  * This method returns the score of the Player
	  * @return the score of the Player
	  */
	 public int getScore()
	 {
		 return score;
	 }
}