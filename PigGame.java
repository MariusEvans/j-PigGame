import java.util.Scanner;

/**
 * Program Title: PigGame |
 * Created: 29/02/2020 |
 * This class creates a PigGame, in which a Player can either roll a dice or hold
 * @author Marius Evans
 * @version 1
 */
public class PigGame {
	private int tempScore; //the running total of a Player's turn (before it is added to the score)
	private boolean gameOver; //whether the game is over
	private boolean turnOver; //whether the turn is over for the Player
	private Scanner inputScanner;
	Die die;
	
	/**
	 * This constructor makes a PigGame with a 6 sided die and sets the 
	 * temporary score to 0 and the game over state to false 
	 */
	public PigGame() {
		die = new Die(6);
		inputScanner = new Scanner(System.in);
		tempScore = 0;
		gameOver = false;
		turnOver = false;
	}
	
	/**
	 * This method rolls the dice, increasing the Player's turn score if they land a face value that is not 1, if they land 1 then
	 * their turn is over and their score is reset.
	 * @param player the Player making the move
	 * @param rolls the number of rolls the Player wishes to take
	 */
	public void rollDice(Player player, int rolls) {
		for(int i = 0; i<rolls; i++) { //loop through the specified number of rolls
			die.throwDie();
			int faceValue = die.getFaceValue();
			
			System.out.println(" | Roll no: "+(i+1)+"  |  Number rolled: "+faceValue);
			
			if(faceValue==1) {
				System.out.println(" * You rolled a 1, your turn is over.");
				turnOver = true;
				tempScore = 0; //reset tempScore
				return; //prevent the rest of rolls being done
			} else {
				turnOver = false;
				tempScore+=faceValue;
			}
		}
		System.out.println(" > Total turn score: "+tempScore);
	}
	
	/**
	 * This method adds the Player's running score for their turn to their total score, 
	 * ending their turn once this has been done.
	 * If the Player's score is more than or equal to 100, they win the game.
	 * @param player the Player making the move
	 */
	public void hold(Player player) {
		player.setScore(tempScore);
		System.out.println("You decided to hold, your score is now: "+player.getScore());
		tempScore = 0; //reset tempScore
		
		if(player.getScore()>=100) {
			System.out.println("##############################");
			System.out.println("Game over, you are the winner.");
			System.out.println("##############################");
			gameOver = true;
		} else {
			turnOver = true;
		}
	}
	
	/**
	 * This method is used to play the PigGame, it pits a specified number of Players against each-other
	 * and allows each of them to use their turn to either roll or hold
	 */
	public void play() {
		//Welcome message
		System.out.println("# ------ Welcome to Pig Game ------ #");
		System.out.print("Enter number of players: ");
		int noOfPlayers = inputScanner.nextInt();
	
		//Create the stated number of Players
		Player players[] = new Player[noOfPlayers];
		for(int i = 0; i<noOfPlayers; i++) {
			players[i] = new Player(0);
		}
		
		int playerNo = 0;
		while(gameOver==false) {
			System.out.println("\n-- Player "+(playerNo+1)+" (Score "+players[playerNo].getScore()+"), it is your turn");
			System.out.print("Roll Dice (R) or Hold (H)? ");
			String move = inputScanner.next();
			
			//only allow moves roll and hold
			while(move.equalsIgnoreCase("R")==false && move.equalsIgnoreCase("H")==false) {
				System.out.print("Invalid move, try again: ");
				move = inputScanner.next();
			}
			
			if(move.equalsIgnoreCase("r")) { //move: roll dice
				System.out.print("How many times do you want to roll? ");
				
				int rolls = inputScanner.nextInt();
				
				//do not allow a roll of 0
				while(rolls<=0) { 
					System.out.print("You cannot roll a 0 or less, try again: ");
					rolls = inputScanner.nextInt();
				}
				
				rollDice(players[playerNo], rolls); //roll dice
			} 
			else if(move.equalsIgnoreCase("h")) { //move: hold
				hold(players[playerNo]); //hold
			}
			
			if(turnOver) { //if turn is over, move to the next Player
				playerNo+=1;
				turnOver = false;
				if(playerNo==players.length) { playerNo = 0; } //go back to the first Player if all Players have had a turn
			}
		}
	}
}
