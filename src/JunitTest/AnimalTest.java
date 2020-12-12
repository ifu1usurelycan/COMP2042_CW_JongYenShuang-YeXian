package JunitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import Actor.Animal;
import javafx.embed.swing.JFXPanel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 5 test cases for Animal.class
 * @author Amber Jong
 */
public class AnimalTest {

	JFXPanel newPanel = new JFXPanel() ;
	
	/**
	 * Test the initial position of frog when game start
	 */
	@Test
	public void initialPosition() {
		System.out.println("\nTest case : The initial position of frog") ;
		
		Animal TestFrog = new Animal("file:src/application/png.doc/froggerUp.png") ;
		
		assertEquals(225 , TestFrog.getX() , 0.0) ;
		assertEquals(706.6666666, TestFrog.getY() , 0.0) ;
		
		System.out.println("Starting X-coordinate : " + TestFrog.getX()) ;
		System.out.println("Starting Y-coordinate : " + TestFrog.getY()) ;
	}

	/**
	 * Test the Up movement of frog when key pressed or released
	 */
	@Test
	public void TESTfrogUp() {
		
		System.out.println("\nTest case : The UP movement of frog") ;
		
		Animal TestFrog = new Animal("file:src/application/png.doc/froggerUp.png") ;
		
		System.out.println("Before (KEY_PRESSED) move up ,frog's X-coordinate : " + TestFrog.getX()) ;
		System.out.println("Before (KEY_PRESSED) move up ,frog's Y-coordinate : " + TestFrog.getY()) ;
		
		TestFrog.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.UP.toString(), KeyCode.UP.toString(), KeyCode.UP, false, false, false, false));
		assertEquals(706.6666666 , TestFrog.getY() , 0.0) ;
		
		TestFrog.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.UP.toString(), KeyCode.UP.toString(), KeyCode.UP, false, false, false, false));
		assertEquals(706.6666666 , TestFrog.getY() , 0.0) ;
		
		System.out.println("After (KEY_RELEASED) move up ,frog's  X-coordinate : " + TestFrog.getX()) ;
		System.out.println("After (KEY_RELEASED) move up ,frog's  Y-coordinate : " + TestFrog.getY()) ;
	}
	
	/**
	 * Test the DOWN movement of frog when key pressed or released
	 */
	@Test
	public void TESTfrogDown() {
		
		System.out.println("\nTest case : The DOWN movement of frog") ;

		Animal TestFrog = new Animal("file:src/application/png.doc/froggerUp.png") ;
		TestFrog.setY(703.3333334);
		
		System.out.println("Before (KEY_PRESSED) move down ,frog's X-coordinate:" + TestFrog.getX()) ;
		System.out.println("Before (KEY_PRESSED) move down ,frog's Y-coordinate : " + TestFrog.getY()) ;
		
		TestFrog.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.DOWN.toString(), KeyCode.DOWN.toString(), KeyCode.DOWN, false, false, false, false));
		assertEquals(703.3333334  , TestFrog.getY() , 0.0) ;
		
		TestFrog.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.DOWN.toString(), KeyCode.DOWN.toString(), KeyCode.DOWN, false, false, false, false));
		assertEquals(703.3333334 , TestFrog.getY() , 0.0) ;
		
		System.out.println("After (KEY_RELEASED) move down ,frog's  X-coordinate : " + TestFrog.getX()) ;
		System.out.println("After (KEY_RELEASED) move down ,frog's  Y-coordinate : " + TestFrog.getY()) ;
	}
	
	/**
	 *  Test the LEFT movement of frog when key pressed or released
	 */
	@Test
	public void TESTfrogLeft() {
		
		System.out.println("\nTest case : The LEFT movement of frog") ;

		Animal TestFrog = new Animal("file:src/application/png.doc/froggerUp.png") ;
		TestFrog.setY(703.3333334);
		
		System.out.println("Before (KEY_PRESSED) move left ,frog's X-coordinate:" + TestFrog.getX()) ;
		System.out.println("Before (KEY_PRESSED) move left ,frog's Y-coordinate : " + TestFrog.getY()) ;
		
		TestFrog.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.DOWN.toString(), KeyCode.DOWN.toString(), KeyCode.DOWN, false, false, false, false));
		assertEquals(703.3333334  , TestFrog.getY() , 0.0) ;
		
		TestFrog.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.DOWN.toString(), KeyCode.DOWN.toString(), KeyCode.DOWN, false, false, false, false));
		assertEquals(703.3333334 , TestFrog.getY() , 0.0) ;
		
		System.out.println("After (KEY_RELEASED) move left ,frog's  X-coordinate : " + TestFrog.getX()) ;
		System.out.println("After (KEY_RELEASED) move left ,frog's  Y-coordinate : " + TestFrog.getY()) ;
	}
	
	/**
	 *  Test the RIGHT movement of frog when key pressed or released
	 */
	@Test
	public void TESTfrogRight() {
		
		System.out.println("\nTest case : The RIGHT movement of frog") ;

		Animal TestFrog = new Animal("file:src/application/png.doc/froggerUp.png") ;
		TestFrog.setY(703.3333334);
		
		System.out.println("Before (KEY_PRESSED) move right ,frog's X-coordinate:" + TestFrog.getX()) ;
		System.out.println("Before (KEY_PRESSED) move right ,frog's Y-coordinate : " + TestFrog.getY()) ;
		
		TestFrog.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED,KeyCode.DOWN.toString(), KeyCode.DOWN.toString(), KeyCode.DOWN, false, false, false, false));
		assertEquals(703.3333334  , TestFrog.getY() , 0.0) ;
		
		TestFrog.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.DOWN.toString(), KeyCode.DOWN.toString(), KeyCode.DOWN, false, false, false, false));
		assertEquals(703.3333334 , TestFrog.getY() , 0.0) ;
		
		System.out.println("After (KEY_RELEASED) move right ,frog's  X-coordinate : " + TestFrog.getX()) ;
		System.out.println("After (KEY_RELEASED) move right ,frog's  Y-coordinate : " + TestFrog.getY()) ;
	}
	
	
}
