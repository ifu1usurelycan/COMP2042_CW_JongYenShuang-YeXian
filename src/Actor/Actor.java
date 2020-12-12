package Actor;

import javafx.scene.image.ImageView;
import java.util.ArrayList;
import application.World;

/**
 * A base class of Actor handling all actors
 * @author Amber Jong
 */
public abstract class Actor extends ImageView{

/**
 * movement of actors
 * @param dx is the x coordinates of actors
 * @param dy is the y coordinates of actors
 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * @return coordinates of actors from World class from its parent
     */
    public World getWorld() {
        return (World) getParent();
    }


    /**
     * return the intersection of actors 
     * @param <A> from java.util.List
     * @param cls of objects
     * @return ArrayList from cls 
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    
/**
 * 
 * @param now The timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
 */
    public abstract void act(long now);

	
}
