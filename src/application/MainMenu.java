package application;
/**
* a base class for game application
 *@author Amber Jong
 *Jong Yen Shuang @ Ye Xian (Amber)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Actor.Animal;
import Actor.Log;
import Actor.Obstacle;
import Actor.Turtle;
import Actor.WetTurtle;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;


public class MainMenu extends Application {

    public mainMenu mainMenu;
    public gameMenu gameMenu;
    AnimationTimer timer;
    MyStage background;
	Animal animal,level,end;
    public  Stage pStage,sStage;
	public Scene scene,scene1,scene2;
	public Stage secondaryStage; 
   MediaPlayer mediaPlayer;
   File myObj;
  FileWriter myWriter;
  public ArrayList<End> endlist = new ArrayList<End>();

  /**
   * create stage for main menu
   */
  //MAIN 
    @Override
    public void start(Stage primaryStage ) throws Exception {
    	//scene of main menu
    	pStage = primaryStage;
    	pStage.sizeToScene();
    	
    	//title  of game
		  primaryStage.setTitle("Froggy Jump!");
        Pane root = new Pane();
        root.setPrefSize(600, 800);
        mainMenu = new mainMenu();
        mainMenu.setVisible(true);
        
        //Set image to main menu page
        Image img = new Image("file:src/application/png.doc/5f94cb19b11d893057e23798fc8d3271.gif");
        ImageView imgView = new ImageView(img);
        imgView.setImage(img);
        imgView.setStyle("-fx-background-color: BLACK");
        imgView.setFitWidth(600);
        imgView.setFitHeight(800);
        imgView.setPreserveRatio(true);
        imgView.setSmooth(true);
        imgView.setCache(true);
        root.getChildren().addAll(imgView, mainMenu);
        Scene scene = new Scene(root,Color.BLACK);
        
        //play music when the stage show 
        playMusic();
       primaryStage.setScene(scene);
       //primaryStage.setMaximized(false);
       primaryStage.setResizable(false);
       primaryStage.show();  
    }
     
    /**
     * create a game background and set up all the animation object
     * @return actor , obstacles, logs, turtles, wet turtles and end
     */
    //GAME
	public MyStage background() {
		//Stage for  game background
		Stage secondaryStage = new Stage();
        background = new MyStage();
        Scene scene1  = new Scene(background,550,800);
        
        //import game menu into the game
        gameMenu = new gameMenu();
        gameMenu.setVisible(false);
        
        //set image for the game menu
        Image img = new Image("file:src/application/png.doc/frogger.png");
        ImageView imgView = new ImageView(img);
        imgView.setImage(img);
        imgView.setFitWidth(600);
        imgView.setFitHeight(800);
        imgView.setPreserveRatio(true);
        imgView.setSmooth(true);
        imgView.setCache(true);
        
        //set new scene for game background
        Pane root1 = new Pane();
        root1.setPrefSize(600, 800);
        Scene scene2 = new Scene(root1,600,800);
		secondaryStage.setScene(scene2);
		
		//set title of game
		secondaryStage.setTitle("Froggy Jump!");
		root1.getChildren().addAll(imgView,gameMenu);
		
		//set game background image
		BackgroundImage froggerback = new BackgroundImage("file:src/application/png.doc/iKogsKW.png");
		background.add(froggerback);
		
		//add Logs animation  
		background.add(new Log("file:src/application/png.doc/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/application/png.doc/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/application/png.doc/log3.png", 150, 440, 166, 0.75));
		background.add(new Log("file:src/application/png.doc/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/application/png.doc/logs.png", 300, 400, 276, -2));

		//add turtles and wet turtles
		background.add(new Turtle(500, 329, -1, 130, 130));
		background.add(new Turtle(300, 329, -1, 130, 130));
		background.add(new WetTurtle(700, 329, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		
		//add river banks (home) for frog
		background.add(new End(13,96));
		background.add(new End(135,96));
		background.add(new End(135 + 135-18,96));
		background.add(new End(135 + 135-18+135-18+1,96));
		background.add(new End(135 + 135-18+135-18+135-18+3,96));
		
		//add frog
		animal = new Animal("file:src/application/png.doc/froggerUp.png");
		background.add(animal);
		
		//add all trucks and cars 
		background.add(new Obstacle("file:src/application/png.doc/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/application/png.doc/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/application/png.doc/truck1"+"Right.png", 600, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/application/png.doc/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/application/png.doc/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/application/png.doc/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/application/png.doc/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/application/png.doc/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/application/png.doc/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/application/png.doc/car1Left.png", 500, 490, -5, 50, 50));
	
		//start the background and show
		background.start();
		createTimer();
		timer.start();
		secondaryStage.setScene(scene1);
		secondaryStage.setResizable(false);
		secondaryStage.show(); 
     
		//when game started, if user press escape button on keyboard
		scene1.setOnKeyPressed(event -> {
         if (event.getCode() == KeyCode.ESCAPE) {
        	 //set the visibility of game menu scene 
             if (!gameMenu.isVisible()) {
            	 sStage = secondaryStage;
            	 sStage.sizeToScene();
            	 secondaryStage.setScene(scene2);
            
                 FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                 ft.setFromValue(0);
                 ft.setToValue(1);

                 gameMenu.setVisible(true);
                 ft.play();
             }
             else {
                 FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                 ft.setFromValue(1);
                 ft.setToValue(0);
                 ft.setOnFinished(evt -> gameMenu.setVisible(false));
                 ft.play();
             }            
         }          
     });
			return background;		 
    }
	
	
	/**
	 *  add buttons to game menu
	 * @author Amber Jong
	 */
//GAME MENU INSIDE THE GAME BACKGROUND
public class gameMenu extends Parent{
	public gameMenu() {
		
		//set the scene of game menu page
	    Label label1 = new Label("Do you want to continue?");
        VBox menu = new VBox(10,label1); 
        label1.setFont(Font.loadFont("file:src/application/png.doc/game_over.ttf", 100));
        label1.setTextFill(Color.BLACK);  
        menu.setTranslateX(100);
        menu.setTranslateY(550);
        final int offset = 10;
        menu.setTranslateX(offset);
        
        //resume button in game menu to resume game
        MenuButton btnResume = new MenuButton("RESUME");
         btnResume.setOnMouseClicked(event -> {  
         FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
         ft.setFromValue(1);
         ft.setToValue(0);
         ft.setOnFinished(evt -> setVisible(false));
         ft.play();
         background();
         sStage.close();
         }); 
         
         //exit button in game menu to exit game 
         MenuButton btnExit1 = new MenuButton("EXIT");
         btnExit1.setOnMouseClicked(event -> {
            System.exit(0);
         });
         menu.getChildren().addAll( btnResume,btnExit1);
         Rectangle bg1 = new Rectangle(600, 800);
         bg1.setFill(Color.WHITE);
         bg1.setOpacity(0.65);
        getChildren().addAll(bg1, menu);
			}
	
		}


/**
 * add buttons to the main menu
 * @author Amber Jong
 */
//MAIN MENU OF THE GAME (before game start)
public class mainMenu extends Parent {
        public mainMenu() {
        
        	//set welcome title of game
        	Label label = new Label("Welcome To Froggy World!");
        	
        	//main menu page
        	VBox menu0 = new VBox(5,label);
        	 label.setFont(Font.loadFont("file:src/application/png.doc/game_over.ttf", 105));
            label.setTextFill(Color.BLACK);  
            
            //leader board page
            VBox menu1 = new VBox(10);
            Image img = new Image("file:src/application/png.doc/frogger.png");
            ImageView imgView = new ImageView(img);
            imgView.setImage(img);
            imgView.setStyle("-fx-background-color: BLACK");
            imgView.setFitWidth(600);
            imgView.setFitHeight(800);
            imgView.setPreserveRatio(true);
            imgView.setSmooth(true);
            imgView.setCache(true);
            Rectangle bg = new Rectangle(600, 800);
            bg.setFill(Color.WHITE);
            bg.setOpacity(0.65);   
     	
           //how to play (instruction) 
            VBox menu2 = new VBox(10);          
            final int offset = 400;
            
            //main menu page
            menu0.setTranslateX(50);
            menu0.setTranslateY(585);
            //leader board page
            menu1.setTranslateX(offset);
            menu1.setTranslateY(460);
            //how to play (instruction)       
            menu2.setTranslateX(offset);
            menu2.setTranslateY(100);
             
        
 //start game button
           		   MenuButton btnStart = new MenuButton("START GAME");
           		   btnStart.setOnMouseClicked(event -> {
            	   FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                   ft.setFromValue(1);
                   ft.setToValue(0);
                   ft.setOnFinished(evt -> setVisible(false));
                   ft.play();
                  
                   background();
                   pStage.close();
            });  
           		   
 //how to play button
            MenuButton btnHTP = new MenuButton("HOW TO PLAY");
            btnHTP.setOnMouseClicked(event -> {
            	
            	Text text = new Text ("How To Play");
            	Text text2 = new Text("To control the frog movement,\n"
            			+ "press 'W' to move up,"
            			+ "\npress 'A' to move left,"
            			+ "\npress 'S' to move down,"
            			+ "\npress 'D' to move right."
            			+ "\nOn the bottom half of the screen, you must "
            			+ "\nsuccessfully guide the frog between opposing"
            			+ "\nlanes of trucks, cars, and other vehicles, "
            			+ "\nto avoid becoming roadkill."
            			+ "\nOn the top half of the screen, you must "
            			+ "\nlet the frog lane on logs or turtles. Turtles are"
            			+ "\nuseful 'stepping stones,' but they also come "
            			+ "\nwith risks when it dive beneath the surface"
            			+ "\nIf you killed by vehicles or water tutles for 5  "
            			+ "\ntimes, the game will be over in this state. "
            			+ "\nEach level up when all 5 frogs reach the riverbank. "
            			+"\nPress the 'esc' button to exit or resume game."
            		);
            	 text.setFont(Font.loadFont("file:src/application/png.doc/game_over.ttf", 100));
            	 text2.setFont(Font.loadFont("file:src/application/png.doc/game_over.ttf",60));
            	text.setStroke(Color.BLACK);
            	menu2.getChildren().addAll(text,text2);
            	
            	getChildren().addAll(imgView, bg,menu2);
           
            	 TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                 tt.setToX(menu0.getTranslateX() - offset);

                 TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
                 tt1.setToX(menu0.getTranslateX());

                 tt.play();
                 tt1.play();
                   
                 tt.setOnFinished(evt -> {
                 getChildren().remove(menu0);
                  });  
            });  
            
//leader board button
            MenuButton btnLB= new MenuButton("LEADERBOARD");
            btnLB.setOnMouseClicked(event -> {
            	Text text = new Text ("   LEADERBOARD");
            	 text.setFont(Font.loadFont("file:src/application/png.doc/game_over.ttf", 150));
            	text.setFill(Color.BLACK); 
            	text.setStroke(Color.BLACK);
            	menu1.getChildren().addAll(text);
                getChildren().add(menu1);
             
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX() - offset);
                
                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu0.getTranslateX());
                
                tt.play();
                tt1.play();
                
                tt.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                });
            });
            
//exit main menu
            MenuButton btnExit = new MenuButton("EXIT");
            btnExit.setOnMouseClicked(event -> {
                System.exit(0);
            });

      
//back to main menu from how to play 
            MenuButton btnBack = new MenuButton("BACK");
            btnBack.setOnMouseClicked(event -> {
                getChildren().add(menu0);
               
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
                tt.setToX(menu2.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu2.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().removeAll(imgView,bg,menu2);
                });
            });
            
//back to main menu from leader board
            MenuButton btnBack1 = new MenuButton("BACK");
            btnBack1.setOnMouseClicked(event -> {
                getChildren().add(menu0);
               
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());

          
                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu1);
                });
            });

//Create a high score list file to store the scores
            try {
                File txt = new File("HighScoreList.txt");
                
                if (txt.createNewFile()) {
                  System.out.println("File created: " + txt.getName());
                  
                  try {
  	                FileWriter W = new FileWriter("HighScoreList.txt");
  	                W.write("1000\n520\n880");
  	                W.close();
  	              } 
                  
                  catch (IOException e) {
  	                System.out.println("Failed to create  HighScoreList.txt");
  	                e.printStackTrace();
  	              }
                } 
                
                else {
                  System.out.println("HighScoreList.txt already exists.");
                }
            } 
            
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
                    
            int[] hSArray = new int[100];
    		int n = 0 ;
    		
    		try {
    	        BufferedReader R = new BufferedReader(new FileReader("HighScoreList.txt"));
    	        String data = R.readLine();
    	        
    	        while (data != null) {
    	            try {
    	                int score = Integer.parseInt(data.trim());
    	                hSArray[n] = score ;
    	                n++ ;
    	            } 
    	            catch (NumberFormatException e1) {
    	            }
    	            data = R.readLine();
    	        }
    	        R.close();
    	    } 
    		
    		catch (IOException e1) {
    	        System.err.println("Can't reading scores from file");
    	    }
            
    		for (int i = 1; i < n; i++) {
    	        int Score = hSArray[i];
    	        int j = i - 1;
    	        while(j >= 0 && Score < hSArray[j]) {
    	            hSArray[j+1] = hSArray[j];
    	            j--;
    	        }
    	        hSArray[j+1] = Score;
    	    }
    		
    		int hS1 = hSArray[n-1] ;
    		int hS2 = hSArray[n-2] ;
    		int hS3 = hSArray[n-3] ;
            HighScore h1 = new HighScore("1st : " + hS1);
            HighScore h2 = new HighScore("2nd : " +hS2);
            HighScore h3 = new HighScore("3rd : " + hS3);

//add all button to all menu
            menu0.getChildren().addAll(btnStart, btnHTP,btnLB,btnExit);
            menu1.getChildren().addAll(btnBack1,h1,h2,h3);
            menu2.getChildren().addAll(btnBack);
            getChildren().addAll( menu0);
             }
        
  }


/**
 * Design the HighScore List
 * @author Amber Jong
 */
private static class HighScore extends StackPane {
	
    private Text text;

    /**
     * @param name Score being shown
     */
    public HighScore(String name) {
    	
    	setTranslateY(10) ;
    	
        text = new Text(name);
        text.setFont(Font.loadFont("file:src/application/png.doc/game_over.ttf", 50));
        text.setFill(Color.WHITE);

        Rectangle bg = new Rectangle(500, 50);
        bg.setOpacity(0.6);
        bg.setFill(Color.BLACK);
        bg.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER);
        setRotate(-0.5);
        getChildren().addAll(bg, text);

        setOnMouseEntered(event -> {
        	
           bg.setTranslateX(10);
            text.setTranslateX(10);
            bg.setFill(Color.WHITE);
            text.setFill(Color.BLACK);
        });

        setOnMouseExited(event -> {
        	
            bg.setTranslateX(0);
            text.setTranslateX(0);
            bg.setFill(Color.BLACK);
            text.setFill(Color.WHITE);
        });
    }
    
}

/**
 * Design of the menu button
 * @author Amber Jong
 */
//DESIGN OF THE MENU BUTTON
    private static class MenuButton extends StackPane {
        private Text text;

        public MenuButton(String name) {
            text = new Text(name);
            text.getFont();
            text.setFont(Font.loadFont("file:src/application/png.doc/game_over.ttf", 50));
            text.setFill(Color.BLACK);
            Rectangle bg = new Rectangle(230, 30);
            bg.setOpacity(0.1);
            bg.setFill(Color.WHITE);
            bg.setEffect(new GaussianBlur(3.5));
            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });

            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            DropShadow drop = new DropShadow(50, Color.BLACK);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }
    
/**
 * create new animation timer
 * points and scores of player to print out the result
 */
 //SET ANIMATION TIMER 
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	//start timer
            	timer.start();
            		
            	//get user points gain and score
                setNumber(animal.getPoints());     
                setScore(animal.level());
            	
            	//change level	
            	if(animal.getChangeLevel())
            	{
            		reset();
            	}
            	
            	//get number of frog die
            	setDie(Animal.Die());
            	
            	//if user finish all 10 level or die by car or water turtle more than 5 times stop the game
            	if (animal.getStop()) {
            		System.out.print("STOPP!");
            		stopMusic();
            		stop();
            		timer.stop();
            		background.stop();
            	
            		//Show alert when user won game or lose game
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setHeaderText("Your Score: "+animal.getPoints()+"!");
       
            		 int highScore = 0;
            		 
            		//save scores to file and arrange the high scores
                 	try {
                			
                	        BufferedReader R = new BufferedReader(new FileReader("HighScoreList.txt"));
                	        String data = R.readLine();

                	        while ( data != null) {
                	            try {
                	                int score = Integer.parseInt(data.trim());
                	                if (score > highScore) { 
                	                    highScore = score; 
                	                }
                	            } 
                	            
                	            catch (NumberFormatException e1) {
                	                System.err.println("Ignoring invalid score: " +  data);
                	            }
                	            data = R.readLine();
                	        }
                	        R.close();
                	    } 
                 	
                 	catch (IOException ex) {
                	        System.err.println("Error reading high score from HighScoreList.txt");
                	    }
                		
                		try {
                	        BufferedWriter output = new BufferedWriter(new FileWriter("HighScoreList.txt", true));
                	        output.newLine();
                	        output.append("" + animal.getPoints());
                	        output.close();
                	    } 
                		
                		catch (IOException e) {
                	        System.out.printf("Error writing score to file: %s\n", e);
                	    }
                		
                		Alert EndGame = new Alert(AlertType.INFORMATION) ;
                		
                		//previous < current
                	    if (animal.getPoints() > highScore) {
                	    	EndGame.setTitle("You Have Won The Game!") ;
                	    	EndGame.setHeaderText("Your High Score: "+ animal.getPoints() +"!") ;
                	    	EndGame.setContentText("You have won the game and beat the highest score! " + highScore) ;
                	    	EndGame.show() ;
                	    } 
                	    
                	  //previous = current
                	    else if (animal.getPoints() == highScore) {
                	    	EndGame.setTitle("You Have Won The Game!") ;
                	    	EndGame.setHeaderText("Your High Score: "+animal.getPoints()+"!") ;
                	    	EndGame.setContentText(" You tied the high score!") ;
                	    	EndGame.show() ;
                	    } 
                	    
                	  //previous > current
                	    else {
                	    	EndGame.setTitle("GAME OVER!") ;
                	    	EndGame.setHeaderText("Your High Score: "+animal.getPoints()+"!") ;
                	    	EndGame.setContentText("Your all time high score was " + highScore) ;
                	    	EndGame.show() ;
                	    }
                	
                	    EndGame.setOnCloseRequest(event -> {
                	    	System.exit(0) ;
    	                });
                	}
            		
            }
        };
    
    }
    
    /**
     * play background music since primary stage open
     */
 //PLAY MUSIC
    public  void playMusic() {
		String musicFile = "src/application/png.doc/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
    
    /**
     * stop music when game end
     */
 //STOP MUSIC
    public void stopMusic() {
		mediaPlayer.stop();
	}
    
    
    /**
     * calculate the points gain by player
     * @param n get from player's point gain
     */
 //CALCULATE PLAYER'S POINTS
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
    
    /**
     * calculate the level change
     * @param m get change of level by player
     */
//CALCULATE PLAYER'S LEVEL
    public void setScore(int m) {
    
    	int shift = 0;
    	while (m > 0) {
    		  int d =m / 10;
    		  int k = m- d * 10;
    		  m= d;
    		  background.add(new Digit(k, 30, 500 - shift, 25));
    		  shift+=30;
    		}
    }
    
    
    /**
     * show how many times the frog die (max 5)
     * @param p get number of frog die 
     */
//CALCULATE TIMES OF FROG DIE (MAX 5)
    public void setDie(int p) {
        
    	int shift = 0;
    	while (p > 0) {
    		  int d =p / 10;
    		  int k = p- d * 10;
    		  p= d;
    		  background.add(new Digit(k, 30, 100 - shift, 25));
    		  shift+=30;
    		}
    }

    /**
     * reset all 5 frog when user complete a level
     */
    //REMOVE ALL 5 FROGS IN  EACH ROUND WHEN USER COMPLETE A LEVEL
   public void reset() {
	   endlist = background.getEnd(End.class);
	   for(int i = 0; i < 5; i++)
	   {
		   background.remove(endlist.get(i));
	   }
	   background.add(new End(13,96));
		background.add(new End(135,96));
		background.add(new End(135 + 135-18,96));
		background.add(new End(135 + 135-18+135-18+1,96));
		background.add(new End(135 + 135-18+135-18+135-18+3,96));
	   }
  /**
   * launch the application
   * @param args launch game
   */
// LAUNCH THE APPLICATION
    public static void main(String[] args) {
        launch(args);
    }


}