package application;


import javafx.scene.media.MediaPlayer;
/**
 * a base class for MyStage which held background of the game
 * @author Amber Jong
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	
	/**
	 * The timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
	}
	
	public MyStage() {
	}

}
