import java.util.Scanner;

import controller.MastermindController;
import model.MastermindModel;

/**
 * This is a game which players need to guess a four letter answer.
 * Below is some simple rules of this game:
 * 
 * 1. Guess and enter four letters.
 * 2. Each of the character represent a color.
 * 3. Players have ten chances to guess the answer.
 *
 * @author Wen Zhu
 *
 */
public class Mastermind {
	
	// Declare some instance variables to help us keep track of the game processing.
	private static int count = 1;
	private static boolean win = false;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// This class represents the view, it should be how uses play the game
		System.out.print(menu());
		String start = input.next();
		start = start.toLowerCase();
		
		while(start.equals("yes")) {
			MastermindModel model = new MastermindModel();
			String answer = getAnswer(model);
			MastermindController controller = new MastermindController(model);
			
			while(!win) {
				System.out.print("Enter guess number "+count+ ": ");
				count++;
				String guess = input.next();
				guess = guess.toLowerCase();
				
				// Check every guesses that the player entered.
				while(isNotValid(guess)) {
					System.out.print("You must enter a valid input, please try again: ");
					guess = input.next();
					guess = guess.toLowerCase();
				}
				
				if(controller.isCorrect(guess)) {
					win = true;
					System.out.println("Congratulations! You win!");
					continue;
				}
				
				// Printing the statistics of each guesses.
				int statistics1 = controller.getRightColorRightPlace(guess);
				System.out.println("Colors in the correct place: " + statistics1);
				int statistics2 = controller.getRightColorWrongPlace(guess);
				System.out.println("Colors correct but in wrong position: " + statistics2);

				if(count > 10) {
					System.out.println("You have used all of your ten chances. The answer is: "+ answer);
					break;
				}
					
			}
			// Reset the game.
			System.out.print("Would you like to play again? Enter \"yes\" to start: ");
			start = input.next();
			start = start.toLowerCase();
			win = false;
			count = 1;
		}

	}
	
	
	/**
	 * This method will check if the given input is valid or not.
	 * 
	 * @param input
	 * @return
	 */
	private static boolean isNotValid(String input) {
		if(input.length() != 4) {
			return true;
		}
		for(int i = 0; i < 4; i ++) {
			if(input.charAt(i) == 'r') {
				continue;
			}else if(input.charAt(i) == 'o') {
				continue;
			}else if(input.charAt(i) == 'y') {
				continue;
			}else if(input.charAt(i) == 'g') {
				continue;
			}else if(input.charAt(i) == 'b') {
				continue;
			}else if(input.charAt(i) == 'p') {
				continue;
			}else {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * This method generates a menu object.
	 * @return the menu of the game.
	 */
	private static String menu() {
		String menu = "Welcome to Mastermind!\n";
		menu += "There are the colors: \n";
		menu += "r for red\n";
		menu += "o for orange\n";
		menu += "y for yellow\n";
		menu += "g for  green\n";
		menu += "b for blue\n";
		menu += "p for purple\n";
		menu += "Would you like to play? Enter \"yes\" to start: ";
		return menu;
	}
	

	/** This method is to get the answer which the model generates.
	 * 
	 * @return The answer of the game.
	 */
	private static String getAnswer(MastermindModel model) {
		String answer = "";
		for(int i = 0; i < 4; i ++) {
			answer += model.getColorAt(i);
		}
		return answer;
	}

}
