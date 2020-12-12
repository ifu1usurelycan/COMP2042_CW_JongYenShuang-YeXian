package application;

import Actor.Actor;
import javafx.scene.image.Image;

/**
 * A base class for End which handling the images of actors with and without collision
 * @author Amber Jong
 *
 */
public class End extends Actor{

MyStage background;
	boolean activated = false;
	@Override
	public void act(long now) {
		
	}
	
	/**
	 * @param x coordinate of actor
	 * @param y coordinate of actor
	 */
	//show the image of end block for frog
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/application/png.doc/End.png", 60, 60, true, true));

	}

/**
 * activated if the frog collide and set the image
 */
	//show the image of frog inside the end block 
	public  void setEnd() {
		setImage(new Image("file:src/application/png.doc/FrogEnd.png", 70,70, true, true));
		
		activated = true;

	}
	
	/**
	 * @return activated
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
