package JunitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import Actor.Log;
import javafx.embed.swing.JFXPanel;

/**
 * 2 test cases for Log,class
 * @author Amber Jong
 */
public class LogTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	/**
	 * Test the initial position of Log
	 */
	@Test
	public void TEST_log_InitialPosition() {
System.out.println("\nTest case : The initial position of Log");
		
		Log TestLog = new Log("file:src/application/png.doc/log3.png", 150, 0, 166, 0.75) ;
		
		assertEquals(0.0 , TestLog.getX(), 0.0) ;
		assertEquals(166.0 , TestLog.getY(), 0.0) ;
		
		System.out.println("Initial  X-coordinate of log : " + TestLog.getX()) ;
		System.out.println("Initial  Y-coordinate of log : " + TestLog.getY()) ;
	}

	
	/**
	 * Test the position of Log
	 */
	@Test
	public void TESTlogSpeed() {
		
		System.out.println("\nTest case : The speed of log");
		
		Log TestLog = new Log("file:src/application/png.doc/logs.png", 300, 400, 276, -2) ;
	
		assertEquals(true , TestLog.getLeft()) ;
	
		System.out.println("If the speed of log  < 0 : " + TestLog.getLeft());
	}
}
