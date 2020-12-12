package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Digit;
import javafx.embed.swing.JFXPanel;

/**
 * 1 test case for Digit.class
 * @author Amber Jong
 */
public class DigitTest {
	JFXPanel jfxPanel = new JFXPanel() ;
	
	/**
	 * Test the position of score board in the game
	 */
	@Test
	public void TEST_DigitPosition() {

		System.out.println("\nTest case : Position of score board");
		
		Digit TESTscore = new Digit(0, 30, 570, 25) ;
		
		assertEquals(570.0 , TESTscore.getX(), 0.0) ;
		assertEquals(25.0 , TESTscore.getY(), 0.0) ;
		
		System.out.println("Initial  X-coordinate of log : " + TESTscore.getX());
		System.out.println("Initial  Y-coordinate of log : " + TESTscore.getY());
	}

}
