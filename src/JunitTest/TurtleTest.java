package JunitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import Actor.Turtle;
import javafx.embed.swing.JFXPanel;

/**
 * 1 test case for turtle.class
 * @author Amber Jong
 */
public class TurtleTest {

	JFXPanel jfxPanel = new JFXPanel() ;
	
	/**
	 * Test initial position of turtle
	 */
	@Test
	public void TEST_turtle_InitialPosition() {
		System.out.println("\nTest case : The Initial position of turtle");
		
		Turtle TESTturtle = new Turtle(500, 329, -1, 130, 130) ;
		
		assertEquals(500.0 , TESTturtle.getX(), 0.0) ;
		assertEquals(329.0 ,  TESTturtle.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of turtle: " +  TESTturtle.getX()) ;
		System.out.println("Initial Y-coordinate of turtle: " +  TESTturtle.getY()) ;
	}


}
