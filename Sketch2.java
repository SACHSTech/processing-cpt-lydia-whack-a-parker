import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Sketch2 extends PApplet {
  
	/**
   * Assignment: 6.1 Processing in Java CPT
   * Author: Lydia He, Parker Yang
   * Due Jun 13, 11:59 PM
   * Description: Prison Escape is a 2-player minigame where the police officer tries 
   * to stop the prisoner from escaping. You can play as either the prisoner (using WASD) 
   * or the prison guard (arrow keys). The prisoner must collect all 5 keys and escape to 
   * win, while the prison guard must tag the prisoner to win. Whichever role, prisoner 
   * or prisoin guard, wins the best out of three, wins the game. 
   */
   
  // Variables
  PImage imgBackground;
  PImage imgOfficerFront1;
  PImage imgOfficerFront2;
  PImage imgOfficerBack1;
  PImage imgOfficerBack2;
  PImage imgOfficerLeft1;
  PImage imgOfficerLeft2;
  PImage imgOfficerRight1;
  PImage imgOfficerRight2;
  PImage imgOfficerStill;
  PImage imgPrisonerFront1;
  PImage imgPrisonerBack1;
  PImage imgPrisonerStill;
  PImage imgCrates;
  PImage imgMenu;
  PImage imgGrass;
  PImage imgKey;
  PFont font;
  float officerX = 650;
  float officerY = 350;
  float prisonerX = height/2;
  float prisonerY = width/2;
  float officerXspeed = 3;
  float officerYspeed = 3;
  int intGCount;
  int intPCount;
  int SCREEN_WIDTH = 1408;
  int SCREEN_HEIGHT = 850;
  int[][] intArray;
  int intArrayValue;
  boolean blnStart = false;
  boolean blnGuardWin = false;
  boolean blnPrisonerWin = false;

  // Make array
  PImage[] officer_frames;
  int intOfficer_frames = 8;

  public void settings() {
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
    intArray = arrayGame();
  }

  public void setup() {
    // Import images
    imgBackground = loadImage("ground_04.png");
    imgOfficerBack1 = loadImage("player_01.png");
    imgOfficerFront1 = loadImage("player_04.png");
    imgOfficerStill = loadImage("player_03.png");
    imgPrisonerFront1 = loadImage("prisoner_04.png");
    imgPrisonerBack1 = loadImage("prisoner_01.png");
    imgPrisonerStill = loadImage("prisoner_03.png");
    imgGrass = loadImage("ground_03.png");
    imgCrates = loadImage("crate_19.png");
    imgKey = loadImage("key_on_tile.png");
    imgMenu = loadImage("menu.png");

    // Load frames
    officer_frames = new PImage[intOfficer_frames];

    // Resize images
    imgGrass.resize(SCREEN_WIDTH / 22, SCREEN_HEIGHT / 17);
    imgCrates.resize(SCREEN_WIDTH / 22, SCREEN_HEIGHT / 17);
    imgBackground.resize(SCREEN_WIDTH / 22, SCREEN_HEIGHT / 17);
    imgKey.resize(SCREEN_WIDTH / 22, SCREEN_HEIGHT / 17);
    imgOfficerBack1.resize(imgOfficerBack1.width/2, imgOfficerBack1.height/2);
    imgOfficerFront1.resize(imgOfficerFront1.width/2, imgOfficerFront1.height/2);
    imgOfficerStill.resize(imgOfficerStill.width/2, imgOfficerStill.height/2);
    imgPrisonerBack1.resize(imgPrisonerBack1.width/2, imgPrisonerBack1.height/2);
    imgPrisonerFront1.resize(imgPrisonerFront1.width/2, imgPrisonerFront1.height/2);
    imgPrisonerStill.resize(imgPrisonerStill.width/2, imgPrisonerStill.height/2);
    imgMenu.resize(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  public void draw() {
    // Start screen
    image(imgMenu, 0, 0);
    fill(0);
    rect(200, 210, 1000, 400);
    fill(255);
    font = createFont("Peepo.ttf", 140);
    textFont(font);
    text("Prison Escape", 255, 430);
    fill(255);
    textSize(60);
    text("Press P to start", 470, 520);
    fill(255);
    textSize(25);
    text("By: Lydia & Parker", 620, 580);

    if (keyPressed){
      if (key == 'p'){
        blnStart = true;
      }
    }
    if (blnStart == true){
    drawGame();

     // Officer image based on which way hes talking 
     if(intGCount == 1) {
      image(imgOfficerBack1, officerX, officerY);
    } else if (intGCount == 2) {
      image(imgOfficerFront1, officerX, officerY);
    } else if (intGCount == 3) {
      image(imgOfficerLeft1, officerX, officerY);
    } else if (intGCount == 4) {
      image(imgOfficerRight1, officerX, officerY);
    } else {
      image(imgOfficerStill, officerX, officerY);
    }
    
    // Prisoner image based on which way hes talking 
    if(intPCount == 1) {
      image(imgPrisonerBack1, prisonerX, prisonerY);
    } else if (intPCount == 2) {
      image(imgPrisonerFront1, prisonerX, prisonerY);
    } else {
      image(imgPrisonerStill, prisonerX, prisonerY);
    }

    // Officer movement
    if (keyPressed) {
      moveOfficer("UP", 1, 3);
      moveOfficer("DOWN", 2, 3);
      moveOfficer("LEFT", 3, 3);
      moveOfficer("RIGHT", 4, 3);
    }

    // Prisoner movement
    if (keyPressed) {
      movePrisoner("w", 1, 4);
      movePrisoner("s", 2, 4);
      movePrisoner("a", 3, 4);
      movePrisoner("d", 4, 4);
    }
  }
  
  if((officerY <= prisonerY + 40) && (officerX <= prisonerX + 40)){
    blnPrisonerWin = true;
  }

  if (blnPrisonerWin == true){
    image(imgMenu, 0, 0);
    fill(0);
    rect(200, 210, 1000, 400);
    textFont(font);
    fill(255);
    textSize(150);
    text("GAME OVER", 340, 460);
    fill(255);
    textSize(60);
    text("The Guard Won!", 490, 550);
   }
  }

  /**
   * Method to create grass
   * @param grassX is a float that reads the x-value of the grass image
   * @param grassY is a float that reads the y-value of the grass image
   */
  public void grass(float grassX, float grassY) {
    image(imgGrass, grassX, grassY);
  }

  /**
   * Method to create crates (aka, walls)
   * @param crateX is a float that reads the x-value of the crate image
   * @param crateY is a float that reads the y-value of the crate image
   */
  public void crates(float crateX, float crateY) {
    image(imgCrates, crateX, crateY);
  }
  
  /**
   * Method to create tiles (aka, background)
   * @param tileX is a float that reads the x-value of the tile image
   * @param tileY is a float that reads the y-value of the tile image
   */
  public void tiles(float tileX, float tileY) {
    image(imgBackground, tileX, tileY);
  }

  /**
   * Method to create a key 
   * @param keyX is a float that reads the x-value of the key image
   * @param keyY is a float that reads the y-value of the key image
   */
  public void keys(float keyX, float keyY){
    image(imgKey, keyX, keyY);
  }
  
  /**
   * Method to make officer move
   * @param strOfficerDirection is a string that reads the direction of the officer (UP, DOWN, LEFT, RIGHT)
   * @param intOfficerGCount is a integer that assigns an image to the officer
   * @param intOfficerSpeed is an integer that assigns a speed to the officer
   */
  public void moveOfficer(String strOfficerDirection, int intOfficerGCount, int intOfficerSpeed) {
    // Move up
    if (strOfficerDirection == "UP") {
      if (keyCode == UP) {
        officerY -= intOfficerSpeed;
        intGCount = intOfficerGCount;
      }
    }
    // Move down
    if (strOfficerDirection == "DOWN") {
      if (keyCode == DOWN) {
        officerY += intOfficerSpeed;
        intGCount = intOfficerGCount;
      }
    }
    // Move left
    if (strOfficerDirection == "LEFT") {
      if (keyCode == LEFT) {
        officerX -= intOfficerSpeed;
      }
    }
    // Move right
    if (strOfficerDirection == "RIGHT") {
      if (keyCode == RIGHT) {
        officerX += intOfficerSpeed;
      }
    }
  }

  /**
   * Method to make prisoner move
   * @param strPrisonerDirection is a string that reads the direction of the prisoner (w, s, a, d)
   * @param intPrisonerPCount is a integer that assigns an image to the prisoner
   * @param intPrisonerSpeed is an integer that assigns a speed to the prisoner
   */
  public void movePrisoner(String strPrisonerDirection, int intPrisonerPCount, int intPrisonerSpeed) {
    // Move up
    if (strPrisonerDirection == "w") {
      if (key == 'w') {
        prisonerY -= intPrisonerSpeed;
        intPCount = intPrisonerPCount;
       }
      }
    // Move down
    if (strPrisonerDirection == "s") {
      if (key == 's') {
        prisonerY += intPrisonerSpeed;
        intPCount = intPrisonerPCount;
       }
      }
    // Move left
    if (strPrisonerDirection == "a") {
      if (key == 'a') {
        prisonerX -= intPrisonerSpeed; 
       }
      }
    // Move right
    if (strPrisonerDirection == "d") {
      if (key == 'd') {
        prisonerX += intPrisonerSpeed; 
      }
    }
  }

  // Method for 2d array
  public void drawGame() {
    for (int y = 0; y < intArray.length; y++) {
      for (int x = 0; x < intArray[0].length; x++) {
        // If the array value is 0, draw tiles
        if (intArray[y][x] == 0) {
          tiles((SCREEN_WIDTH / 22) * x, (SCREEN_HEIGHT / 17) * y);
        // If the array value is 1, draw grass
        } else if (intArray[y][x] == 1) {
          grass((SCREEN_WIDTH / 22) * x, (SCREEN_HEIGHT / 17) * y);
        // If the array value is 2, draw wall
        } else if (intArray[y][x] == 2) {
          crates((SCREEN_WIDTH / 22) * x, (SCREEN_HEIGHT / 17) * y);
        // If the array value is 3, draw key
        } else if (intArray[y][x] == 3) {
          keys((SCREEN_WIDTH / 22) * x, (SCREEN_HEIGHT / 17) * y);
        }
      }
    }
  }
  // Array for drawing everything
  public int[][] arrayGame() {
    return new int[][] {
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
      {1,2,0,0,0,0,0,2,0,0,0,0,0,0,2,0,0,0,0,0,2,1},
      {1,2,0,2,2,2,0,0,0,2,3,0,2,0,2,0,2,2,2,0,2,1},
      {1,2,0,0,3,0,0,2,0,2,2,2,2,0,0,0,2,3,2,0,2,1},
      {1,2,0,2,2,0,2,2,0,0,0,0,0,0,2,0,2,0,2,0,2,1},
      {1,0,0,0,0,0,0,2,0,2,2,2,2,0,2,0,0,0,0,0,2,1},
      {1,2,2,0,2,2,0,2,0,2,0,0,2,0,0,0,2,2,2,2,2,1},
      {1,2,0,0,0,0,0,2,0,0,0,0,0,0,2,0,0,0,0,0,0,1},
      {1,2,0,2,2,2,0,2,0,2,0,0,2,0,2,0,2,2,0,2,2,1},
      {1,2,0,0,0,0,0,0,0,2,2,2,2,0,2,0,0,0,0,0,2,1},
      {1,2,0,2,3,2,0,2,0,0,0,0,0,0,2,2,0,2,2,0,2,1},
      {1,2,0,0,0,2,0,2,0,2,2,2,2,0,2,0,0,0,3,0,2,1},
      {1,2,2,2,0,2,0,0,0,2,0,3,2,0,0,0,2,2,2,0,2,1},
      {1,1,1,2,0,0,0,2,0,0,0,0,0,0,2,0,0,0,0,0,2,1},
      {1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
  }
}