package Actor;

import application.End;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 * A base class for Animal
 * @author Amber Jong
 */
public class Animal extends Actor {
	//import images
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;

	//initialize starting score
	public static	int points = 0;
	
	//initialize end for frog to reach
	public static int end = 5;
	
	//initialize the the level 
	public static int level = 0;
	
	//initial number of die of frog
	public static int Die = 0;
	
	//initialize frog death animation
	int deathAnimation = 0;
	
	//initialize frog size
	int frogSize = 45;
	
	//set vertical jump distance of frog
	double movementY = 13.3333333*2;
	
	//set horizontal jump distance of frog
	double movementX = 10.666666*2;
	
	//true=death,false=not death (by car)
	private boolean carDeath = false;
	
	//true=death,false=not death (by water)
	private boolean waterDeath = false;
	
	//Initialize movement of frog
    private boolean noMove = false;
    
	//initialize jump of frog, false=unfold leg
	private boolean jump = false;
	
	//initialize change level when 5 frog reach end
	private boolean changeLevel = false;
	
	//initialize the change state (dead) of frog when frog hit car, truck or  wet turtle
	private boolean dead = false;
	
	//initialize scoreLine, will be added while frog passing it 
	double scoreline = 800;
	

	/**
	 * show the movement of frog
	 * @param imageLink of animation of frog 
	 */
	public Animal(String imageLink) {
		//frog image
		setImage(new Image(imageLink, frogSize, frogSize, true, true));
		//set starting point of frog
		setX(225);
		setY(680+ movementY);
		imgW1 = new Image("file:src/application/png.doc/froggerUp.png", frogSize,frogSize, true, true);
		imgA1 = new Image("file:src/application/png.doc/froggerLeft.png", frogSize,frogSize, true, true);
		imgS1 = new Image("file:src/application/png.doc/froggerDown.png", frogSize,frogSize, true, true);
		imgD1 = new Image("file:src/application/png.doc/froggerRight.png", frogSize,frogSize, true, true);
		imgW2 = new Image("file:src/application/png.doc/froggerUpJump.png", frogSize,frogSize, true, true);
		imgA2 = new Image("file:src/application/png.doc/froggerLeftJump.png",frogSize,frogSize, true, true);
		imgS2 = new Image("file:src/application/png.doc/froggerDownJump.png", frogSize,frogSize, true, true);
		imgD2 = new Image("file:src/application/png.doc/froggerRightJump.png", frogSize,frogSize, true, true);
		//movement of frog
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			//ways to handle the press keys
			public void handle(KeyEvent event){
				//current no movement of frog 
				if (noMove) {
					
				}
				else {
					//check if frog is jumping
					if (jump) {
						//check the which key is controlling the movement of frog
					if (event.getCode() == KeyCode.W) {	  //moving up
						//if frog moving
		                move(0, -movementY);
		                //set the image of moving frog 
		                setImage(imgW1);
		                //set frog jump
		                jump = false;
		            }
		            else if (event.getCode() == KeyCode.A) { //moving left    	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 jump = false;
		            }
		            else if (event.getCode() == KeyCode.S) { //moving down     	
		            	 move(0, movementY);
		            	 setImage(imgS1);
		            	 jump = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	//moving right            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 jump = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movementY);
	                setImage(imgW2);
	                jump = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 jump = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movementY);
	            	 setImage(imgS2);
	            	 jump = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 jump = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else { 
					if(event.getCode() == KeyCode.W) {	  
						//check whether the frog passing the score line or not 
					if (getY() < scoreline ) {
						scoreline = getY();
						points+=10;
					}
	                move(0, -movementY);
	                setImage(imgW1);
	                jump = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 jump = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movementY);
	            	 setImage(imgS1);
	            	 jump = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 jump = false;
	            }
	        }
			}
			
		});
	}
	
	/**
	 * show the result of collision of frog
	 */
	@Override
	public void act(long now) {


		//reset the frog position to starting point when it hit the boundary of top or bottom
		if (getY()<100 || getY()>800) {
			setX(225);
			setY(680+movementY);
		}
		//reset the frog position to starting point when it hit the boundary when moving left or right
		if (getX()<0) {
			move(movementY*2, 0);
		}
		 if (getX() > 600){
			move(-movementY*2, 0);
		}
		 
		if (getX()==240 && getY()==82) {
			noMove = true;
		}
	
		if (carDeath) { //when frog hit car
			noMove = true;
		
			if ((now)% 11 ==0) { //show the frog's death animation
				deathAnimation++;
				
			}
		
			if (deathAnimation==1) {
				setImage(new Image("file:src/application/png.doc/cardeath1.png", frogSize,frogSize, true, true));
			}
			if (deathAnimation==2) {
				setImage(new Image("file:src/application/png.doc/cardeath2.png", frogSize,frogSize, true, true));
			}
			if (deathAnimation==3) {
				setImage(new Image("file:src/application/png.doc/cardeath3.png",frogSize,frogSize, true, true));
			}
			if (deathAnimation == 4) { //reset frog's position to starting point
				//if frog intersect with car or truck more than 5 times, game over
				if(Die<=5) {
					Die++;
					if(Die==0) {
						dead=true;
					}
				setX(300);
				setY(680+movementY); 
				carDeath = false;//reset frog's death animation
				deathAnimation = 0; // reset reborn image of frog from death to alive
				setImage(new Image("file:src/application/png.doc/froggerUp.png",frogSize,frogSize, true, true));
				noMove = false;//reset movement of frog
				//if the frog die, 50 score will be deducted,if the plater got less than 50 score, it will remain 0 score
				if (points>50) {
					points-=50;
				
					}
				}//change the state of score
			}
	
		}
	
		if (waterDeath) { //when the frog met water then it will die too
			noMove = true; //set the movement of frog 
		
			if ((now)% 11 ==0) {//show the frog's death animation
				deathAnimation++;
			}
			if (deathAnimation==1) {
				setImage(new Image("file:src/application/png.doc/waterdeath1.png", frogSize,frogSize , true, true));
			}
			if (deathAnimation==2) {
				setImage(new Image("file:src/application/png.doc/waterdeath2.png", frogSize,frogSize , true, true));
			}
			if (deathAnimation==3) {
				setImage(new Image("file:src/application/png.doc/waterdeath3.png", frogSize,frogSize , true, true));
			}
			if (deathAnimation == 4) {
				setImage(new Image("file:src/application/png.doc/waterdeath4.png", frogSize,frogSize , true, true));
			}
			if (deathAnimation == 5) {
				//if frog intersect with water turtle more than 5 times, game over
				if(Die<=5) {
					Die++;
					if(Die==0) {
						dead=true;
					}
				setX(300);
				setY(680+movementY);
				waterDeath = false;
				deathAnimation = 0;
				setImage(new Image("file:src/application/png.doc/froggerUp.png", frogSize,frogSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
				}
				}
			}
		
		}
	
		//if the frog hit the car then it will die
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		
		//when the frog step on the stepping stones (turtle, log, wet turtle), the frog will move with it 
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) { //when the frog step on log
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) { //when the frog step on turtle
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) { //when the frog step on wet turtle it will float, it will fall when the wet turtle become red
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		} 
		
	//when the frog reach goal
		else  if (getIntersectingObjects(End.class).size() >= 1) {
	//LOOP the 10 level
			if(level <=10) {
		
			if (getIntersectingObjects(End.class).get(0).isActivated())
			{
				setX(300);
				setY(680+movementY);
			}
			else
			{
				//LOOP if 5 frog reach end then increase level
						if(end<=5) {
							//add 50 score when the frog complete a goal
							points+=50;
							//reset score line
							scoreline =800;
						//set goal image when the frog completed
				getIntersectingObjects(End.class).get(0).setEnd();
				//set the frog back to the starting point
				setX(300);
				setY(680+movementY);
						end--;
						}
						//when all 5 frog reach home (river bank)
						if(end == 0)
						{
							end = 5;
							//increase level
							level++;
							changeLevel = true;
						}
					}
				}
		}
		
		 //magnified water death which frog die if move to the half upper part area
		else if (getY()<370){
			waterDeath = true;
			setX(300);
			setY(680+movementY);
		}
}


	/* * 
	 * all 10 level must be completed to reach the end game or if frog die more than 5 times
	 * @return  the number of level completed and frog die
	 */
	public boolean getStop() {
		if (level==10) {
			return true;
		}
		else if(Die == 5) {
			return true;
		}
		else 
			return false;
	}

	/**
	 * get change level when 5 frog reach end
	 * @return level change when player complete a level
	 */
	public boolean getChangeLevel()
	{
		if(changeLevel)
		{
			changeLevel = false;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * if 5 frog killed by collision with car, trucks and wet turtles then game over
	 * @return dead if 5 frog die by collision with objects
	 */
	public boolean getDie()
	{
		if(dead)
		{
			dead=false;
			
		return true;
		}
		else return false;
	}
	
	/**
	 * get points gain by user
	 * @return  the score gain by player
	 */
	public int getPoints() {
		return points;
	}

/**
 *reset each frogs when all 5 frogs reach end
 * @return end reach by frog
 */
public static int end() {
	return end;
}

/**
 *only allow maximum 5 frog die
 * @return number of frog die
 */
public static int Die() {
	return Die;
}

/**
 * get the number of  level 
 * @return  level when each 5 frog reach end 
 */
public int level() {
return level;
}

}
