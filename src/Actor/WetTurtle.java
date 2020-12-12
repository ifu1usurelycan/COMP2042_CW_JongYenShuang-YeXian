package Actor;

import javafx.scene.image.Image;

/**
 *  A base class of Wet Turtle  handling its speed and image 
 * @author Amber Jong
 */
public class WetTurtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	/**
	 * @param xpos is the movement of wet turtles in horizontal 
	 * @param ypos is the movement of wet turtles in vertical
	 * @param s is the speed of wet turtles
	 * @param w is the width of wet turtles
	 * @param h is the height of wet turtles
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/application/png.doc/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/application/png.doc/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/application/png.doc/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/application/png.doc/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	/**
	 * return the turtle sunk becoming wet turtle
	 * @return sunk 
	 */
	public boolean isSunk() {
		return sunk;
	}
}
