package JunitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import Actor.Obstacle;
import javafx.embed.swing.JFXPanel;

/**
 * 1 test case for Obstacle.class
 * @author Amber Jong
 */
public class ObstacleTest {
	JFXPanel jfxPanel = new JFXPanel() ;

	/**
	 * Test the initial position of obstacle 
	 */
	@Test
	public void TEST_obstacle_InitialPosition() {
		System.out.println("\nTest case : The initial position of obstacle");
		
		Obstacle TESTobstacle = new Obstacle("file:src/application/png.doc/car1Left.png", 100, 597, -1, 50, 50) ;
		
		assertEquals(100.0 , TESTobstacle.getX(), 0.0) ;
		assertEquals(597.0 ,  TESTobstacle.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of Obstacle: " +  TESTobstacle.getX()) ;
		System.out.println("Initial Y-coordinate of Obstacle: " +  TESTobstacle.getY()) ;
	}

}
