package application;


import java.util.ArrayList;
import java.util.List;
import Actor.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * a base class of World which handle the general setting
 * @author Amber Jong
 */
public abstract class World extends Pane {
    private AnimationTimer timer;
    
    /**
     * create a general setting of whole game
     */
    public World() {

    	sceneProperty().addListener(new ChangeListener<Scene>() {
    		/**
    		 * changes in the game 
    		 */
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
     * create timer for all actors
     */
    public void createTimer() {
   
        timer = new AnimationTimer() {

            @Override
            
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
              	long lastUpdate = 0;
            	if(now - lastUpdate>= 200_000_000) {
            		lastUpdate = now;
            		
            	}
              for (Actor anActor: actors) {
                	anActor.act(now);
                	
                }
              setCache(true);
              setCacheShape(true);
              setCacheHint(CacheHint.SPEED);
            }  
        };
    }
    
/**
 * Start world timer
 */
    public void start() {
    	createTimer();
        timer.start();
    }
    
/**
 * Stop world timer
 */
    public void stop() {
        timer.stop();
    }
    
  /**
   * 
   * @param actor added to background
   */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * @param actor removed from background
     */
    public void remove(Actor actor) {
      getChildren().remove(actor);
    }
    
    /**
     * @param <A> from java.util.List
     * @param cls of objects 
     * @return ArrayList from cls
     * record objects that available in game
     */
//get array list of Actor class
    @SuppressWarnings("unchecked")
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
    
    /**
     * @param  <E> from java.util.List
     * @param cls of objects
     * @return ArrayList from cls
     * record Ends that available in game
     */
    //get array list of End class
    @SuppressWarnings("unchecked")
    public <E extends End> ArrayList<E> getEnd(Class<E> cls) {
        ArrayList<E> someArray = new ArrayList<E>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((E)n);
            }
        }

        	return someArray;
    }
/**
 * To set the action for actors
 * @param now The timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
 */
    public abstract void act(long now);

}
