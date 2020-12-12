# FROGGY JUMP GAME!
 **COMP2042_CW_JongYenShuang-YeXian**


# Key Changes in the maintenance and extension of Game
**Files organization and contribution** 
   * Files are distributed into 2 packages which are Actor and application.
   * Package Actor including Actor.java, Log.java, Obstacle.java.Turtle.java and WetTurtle.java.
   * Package application including BackgroungImage.java, Digit.java, End.java, MainMenu.java, MyStage.java and World.java.  
   * Comments on java file to improve the understanding of codes.
   * Generate Javadoc documentation of all packages, classes and Junit test cases.
   * Implementation of 12 Junit test cases.
   * Create an Ant build file to produce executable FroggerJump.jar file. 
   * 2 class diagrams are drawn.
      - One is generated by Eclipse Object Aider class diagram with details. 
      - Another class diagram is sketched by using draw.io.
   * An mp4 for a brief explanation about the operation of FroggyJump game.
  
  
**A new Main Menu page for the game**
  * Self- made Main.java file is changed to MainMenu.java which adding new stages, scenes, background images (including .GIF file) and button for the game.
  * Including Start button at main menu, how to play (instructions) page, leaderboard page and exit button to exit the game platform.
  * The buttons are designed to be more animation with the transformation.
  * **How To Play page**
      - Instructions are given to the player to guide them in controlling the frog and useful directions on how to play.
  * **Leaderboard page**
      - Scores will be recorded and write into a txt. file automatically after the player win or lose each time game end.
      - Leaderboard will be showing the top 3 scores of the player.
  * **Game Menu page**
      - A new Game Menu page is created to let player resume or exit game when `ESCAPE` key is pressed.
  
  
**New game mode**
  * Adding scores and set levels for the game to make it more interesting.
  * 5 chances are given to players to reborn in the game after the frog killed by roadkill (cars and trucks) or step into the river (including stepping on the wet turtle).
  * No time limit but if you die for 5 times, the game will be over on this state.
  * The game has maximum 10 levels, the level up each time when 5 frogs reached the riverbanks (homes).
  
  
  
  # Modification of names used in the java files
  
 **Rename:**
  * Animal.java
    - imgSize -> frogSize
    - carD -> deathAnimation
    - movement -> movementY
    - second -> jump
    - w -> scoreline
    
    
  **New create:**
  * Main.java -> MainMenu.java
    - public class gameMenu
    - scene1, scene2
    - secondaryStage
    - myObj
    - myWriter
    
  * Animal.java
    - int level
    - int Die
    - boolean changeLevel
    - boolean dead
    
    
**Remove unused methods and vairables:**
 * Animal.java
    - changeScore
    - inter
    
 * Actor.java
    - getWidth()
    - getHeight()
    - manageInput()
    - getOneIntersectingObject()
   
   
   
# User Guide to launching the game application

**Follow the instructions to launch the game application in your desktop**

1. Download the whole `master` COMP2042_CW_JongYenShuang-YeXian repository zip file into your desktop.
2. Save your zip file into a new folder and right-click select `Extract Here`.
3. Open FroggerJump file folder and copy the path.
4. Open build file with right-click and select `Edit`.
5. Replace by pasting your path to all `${dir.workspace}` in the build.xml file which the path is the location of the downloaded file in your desktop.
6. Open Window -> Command Prompt 
7. Input 
```
cd C: ${dir.workspace}\COMP2042_CW_JongYenShuang-YeXian-master
```
8. press `ENTER` then you will see 
```
C:\ ${dir.workspace}\COMP2042_CW_JongYenShuang-YeXian-master>
```
9. Then input `ant` after it and press `ENTER` key.
10. Open javafx-sdk-11.0.2\lib in your downloaded file and copy the path.
11. If the ant build file `BUILD SUCCESSFUL`, copy the code below and replace `${dir.workspace}` to the path of the location where you download the file.
```
java --module-path "${dir.workspace}\COMP2042_CW_JongYenShuang-YeXian-master\javafx-sdk-11.0.2\lib" --add-modules=ALL-MODULE-PATH -jar FroggyJump.jar
```
12.Press the `ENTER` key and you can successfully launch the game application.

  
