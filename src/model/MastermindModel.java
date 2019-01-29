package model;
import java.util.Random;
/**
 * This method constructs a secrete answer for the game.
 * @author Wen Zhu
 *
 */
public class MastermindModel {
	//private variable(s) to store the answer
	private String answer = "";
	private int max = 6;
	private int min = 1;
	
    public MastermindModel() {
    	// generate a string with four random letters.
    	Random rand = new Random();
    	for(int i = 0; i < 4; i ++) {
    		int random = rand.nextInt(max)+min;
    		if(random == 1) {
    			answer += "r";
    		}else if(random == 2) {
    			answer += "o";
    		}else if(random == 3) {
    			answer += "y";
    		}else if(random == 4) {
    			answer += "g";
    		}else if(random == 5) {
    			answer += "b";
    		}else if(random == 6) {
    			answer += "p";
    		}
    	}
    }
    
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	this.answer = answer;
    }


    /**
     * This method returns the color at specific index in the answer.
     * 
     * @param index The position in the answer.
     * @return
     */
    public char getColorAt(int index) {
    	char colorAt = answer.charAt(index);
    	return colorAt;
    }
    

}
