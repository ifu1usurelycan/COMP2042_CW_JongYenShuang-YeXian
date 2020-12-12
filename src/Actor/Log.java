package Actor;

import javafx.scene.image.Image;

/**
 * A base class Log handling its speed and image 
 * @author Amber Jong
 */
public class Log extends Actor {

	private double speed;

	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	/**
	 * @param imageLink handle the image of logs
	 * @param size of the log
	 * @param xpos is the movement of log in horizontal 
	 * @param ypos is the movement of log in vertical
	 * @param s is the speed of log
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	/**
	 * @return if speed of log's movement less than 0  
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
