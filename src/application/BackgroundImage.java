package application;
/**
 * a base class for background image 
 * @author Amber Jong
 */
import Actor.Actor;
import javafx.scene.image.Image;

/**
 *  * a base class for background image
 * @author Amber Jong
 
 */
public final class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
	
	}
	/**
	 * set image of game background
	 * @param imageLink get image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
