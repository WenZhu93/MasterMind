package controller;
import model.MastermindModel;

/**
 * This class is to construct the controller of this game.
 * It will check if the player's guess is match the answer, it will 
 * also count the colors in right or wrong positions.
 * 
 * @author Wen Zhu
 *
 */
public class MastermindController {

	// Declare some instance variables to help us keep track of the game processing.
	private MastermindModel model;
	private String answer = "";
	public MastermindController(MastermindModel model) {
		this.model = model;
		answer = getAnswer();
	}

	/** This method is to check if the guess is correct or not.
	 * 
	 * @param guess The player's guess
	 * @return The result
	 */
	public boolean isCorrect(String guess) {
		for(int i = 0; i < 4; i ++) {
			if(guess.charAt(i) != model.getColorAt(i)) {
				return false;
			}
		}
		return true;
	}


	/** This method is to get the right color in the right place.
	 * 
	 * @param guess The player's guess
	 * @return The result
	 */
	public int getRightColorRightPlace(String guess) { 
		int result = 0;
		for(int i = 0; i < 4; i ++) {
			if(guess.charAt(i) == model.getColorAt(i)) {
				result ++;
			}
		}
		return result;
	}


	/** This method is to get the right color in the wrong place.
	 * 
	 * @param guess The player's guess
	 * @return The result
	 */
	public int getRightColorWrongPlace(String guess) {
		int result = 0;
		// replace the right ones, so we don't count them in.
		answer = "";
		answer = getAnswer();
		for(int i = 0; i < 4; i ++) {
			if(guess.charAt(i) == model.getColorAt(i)) {
				guess = replace(guess, i);
				answer = replace(answer, i);
			}
		}
		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < 4; j ++) {
				if(answer.charAt(i) == ' ') {
					continue;
				}
				if((i != j) && (answer.charAt(i) == guess.charAt(j))) {
					result ++;
					guess = replace(guess, j);
					break;
				}
			}
		}
		return result; 
	}

	/**
	 * This method will replace the string with an empty space,
	 * So we do not count it again.
	 * 
	 * @param str The given string
	 * @param i The index
	 * @return
	 */
	private String replace(String str, int i) {
		str = str.substring(0, i) 
				+ ' '
				+ str.substring(i + 1);
		return str;
	}


	/** This method is to get the answer which the model generates.
	 * 
	 * @return The answer of the game.
	 */
	private String getAnswer() {
		for(int i = 0; i < 4; i ++) {
			answer += model.getColorAt(i);
		}
		return answer;
	}

}
