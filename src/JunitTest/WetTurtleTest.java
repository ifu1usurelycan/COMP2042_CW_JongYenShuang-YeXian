package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Actor.WetTurtle;
import javafx.embed.swing.JFXPanel;

/**
 * 2 test cases for WetTurtle.class 
 * @author Amber Jong
 */
public class WetTurtleTest {
	JFXPanel jfxPanel = new JFXPanel() ;
	
	/**
	 * Test the initial position of wet turtle
	 */
	@Test
	public void TEST_wetTurtle_InitialPosition() {
System.out.println("\nTest case : The initial position of wet turtle");
		
		WetTurtle TESTwetTurtle = new WetTurtle(200, 217, -1, 130, 130) ;
		
		assertEquals(200.0 , TESTwetTurtle.getX(), 0.0) ;
		assertEquals(217.0 , TESTwetTurtle.getY(), 0.0) ;
		
		System.out.println("Starting position , X-coordinate : " + TESTwetTurtle.getX()) ;
		System.out.println("Starting position , Y-coordinate : " + TESTwetTurtle.getY()) ;
	}
	
	/**
	 * Test weather the wet turtle sunk or not
	 */
	@Test
public void TEST_wetTutleSunk() {
		
		System.out.println("\nTest case : Test wet turtle if it is sunk or float");

		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2000-01-01 00:00:00.0");
		
		WetTurtle TESTwetTurtle = new WetTurtle(400, 217, -1, 130, 130) ;

		assertEquals(false ,TESTwetTurtle.isSunk()) ;
		
		System.out.println("Wet turtle sunk when game start : " +TESTwetTurtle.isSunk()) ;
	
		TESTwetTurtle.act(timestamp.getTime());
		
		assertEquals(true , TESTwetTurtle.isSunk()) ;
		
		System.out.println("After some time wet turtle sunk : " +TESTwetTurtle.isSunk()) ;
	}
	
}
