package Actor;

import javafx.scene.image.Image;

/**
 * A base class of Obstacle handling its speed and image 
 * @author Amber Jong
 */
public class Obstacle extends Actor {
	private int speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	/**
	 * @param imageLink  handle the image of cars and trucks
	 * @param xpos is the movement of obstacles in horizontal 
	 * @param ypos is the movement of obstacles in vertical
	 * @param s is the speed of obstacles
	 * @param w is the width of obstacles
	 * @param h is height of obstacles
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	
}
