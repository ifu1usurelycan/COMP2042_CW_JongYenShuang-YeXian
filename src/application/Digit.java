package application;

import Actor.Actor;
import javafx.scene.image.Image;

/**
 * A base class of Digit to show the change of points and level images 
 * @author Amber Jong
 */
public class Digit extends Actor{
	int dim;
	Image im1;
	

	@Override
	public void act(long now) {
	}
	/*
	 * get images of numbers for the scores and levels of player
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/application/png.doc/"+n+".png", dim, dim, true, true);

		setImage(im1);
		setX(x);
		setY(y);
	}

}
