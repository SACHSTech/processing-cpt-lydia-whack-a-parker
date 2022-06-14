import javax.swing.plaf.basic.BasicComboPopup.InvocationKeyHandler;

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
  float officerX = 130;
  float officerY = 110;
  float prisonerX = 640;
  float prisonerY = 350;
  float officerXspeed = 3;
  float officerYspeed = 3;
  int intGCount;
  int intPCount;
  int SCREEN_WIDTH = 1408;
  int SCREEN_HEIGHT = 850;
  int ROW_COUNT = 22;
  int COLUMN_COUNT = 17;
  int TILE_HEIGHT = 25;
  int TILE_WIDTH = 32;
  int intCrateX;
  int intCrateY;
  int intOfficer_frames = 8;
  int[][] intArray;
  int intArrayValue;
  int intKeyCount = 0;
  boolean blnStart = false;
  boolean blnGuardWin = false;
  boolean blnPrisonerWin = false;
  boolean blnKey1 = true; 
  boolean blnKey2 = true;
  boolean blnKey3 = true;
  boolean blnKey4 = true;
  boolean blnKey5 = true;
  boolean blnKey6 = true;
  PImage[] officer_frames;

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
    imgOfficerBack1.resize(SCREEN_WIDTH / 25, SCREEN_HEIGHT / 18);
    imgOfficerFront1.resize(SCREEN_WIDTH / 25, SCREEN_HEIGHT / 18);
    imgOfficerStill.resize(SCREEN_WIDTH / 25, SCREEN_HEIGHT / 18);
    imgPrisonerBack1.resize(SCREEN_WIDTH / 25, SCREEN_HEIGHT / 18);
    imgPrisonerFront1.resize(SCREEN_WIDTH / 25, SCREEN_HEIGHT / 18);
    imgPrisonerStill.resize(SCREEN_WIDTH / 25, SCREEN_HEIGHT / 18);
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

    fill(0);
    textFont(font);
    textSize(35);
    text("Key Count: " + intKeyCount + "/6", 15, 36);

    // Key pick up (bottom left)
    if(blnKey1 == true){
    if(prisonerX >= (TILE_WIDTH * 7) && prisonerX <= (TILE_WIDTH * 9) && prisonerY >= (TILE_HEIGHT * 22) && prisonerY <= (TILE_HEIGHT * 25)){
      intKeyCount = intKeyCount + 1; 
      blnKey1 = false;
      }
      keys(TILE_WIDTH * 8, TILE_HEIGHT * 22);
    }
    
    // Key pick up (top left)
    if(blnKey2 == true){
    if(prisonerX >= (TILE_WIDTH * 7) && prisonerX <= (TILE_WIDTH * 9) && prisonerY >= (TILE_HEIGHT * 6) && prisonerY <= (TILE_HEIGHT * 9)){
      intKeyCount = intKeyCount + 1; 
      blnKey2 = false;
      }
      keys(TILE_WIDTH * 8, TILE_HEIGHT * 8); 
    }

    // Key pick up (top middle)
    if(blnKey3 == true){
    if(prisonerX >= (TILE_WIDTH * 18) && prisonerX <= (TILE_WIDTH * 21) && prisonerY >= (TILE_HEIGHT * 5) && prisonerY <= (TILE_HEIGHT * 8)){
      intKeyCount = intKeyCount + 1; 
      blnKey3 = false;
      }
      keys(TILE_WIDTH * 20, TILE_HEIGHT * 6); 
    }

    // Key pick up (bottom middle)
    if(blnKey4 == true){
    if(prisonerX >= (TILE_WIDTH * 22) && prisonerX <= (TILE_WIDTH * 25) && prisonerY >= (TILE_HEIGHT * 25) && prisonerY <= (TILE_HEIGHT * 28)){
      intKeyCount = intKeyCount + 1;  
      blnKey4 = false;
      }
      keys(TILE_WIDTH * 22, TILE_HEIGHT * 26);
    }

    // Key pick up (top right)
    if(blnKey5 == true){
    if(prisonerX >= (TILE_WIDTH * 33) && prisonerX <= (TILE_WIDTH * 36) && prisonerY >= (TILE_HEIGHT * 6) && prisonerY <= (TILE_HEIGHT * 9)){
      intKeyCount = intKeyCount + 1; 
      blnKey5 = false;
      }
      keys(TILE_WIDTH * 34, TILE_HEIGHT * 8); 
    }
    // Key pick up (bottom right)
    if(blnKey6 == true){
    if(prisonerX >= (TILE_WIDTH * 35) && prisonerX <= (TILE_WIDTH * 38) && prisonerY >= (TILE_HEIGHT * 22) && prisonerY <= (TILE_HEIGHT * 25)){
      intKeyCount = intKeyCount + 1; 
      blnKey6 = false;
      }
      keys(TILE_WIDTH * 36, TILE_HEIGHT * 24); 
    } 

    // Officer image based on which way hes walking 
      // Going up
    if(intGCount == 1) {
      image(imgOfficerBack1, officerX, officerY);
      // Going down
    } else if (intGCount == 2) {
      image(imgOfficerFront1, officerX, officerY);
      // Going left
    } else if (intGCount == 3) {
      image(imgOfficerLeft1, officerX, officerY);
      // Going right
    } else if (intGCount == 4) {
      image(imgOfficerRight1, officerX, officerY);
      // Standing still
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
  
  // Guard win screen
  if (blnGuardWin == true){
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
   // Prisoner win screen 
   if (intKeyCount == 6 && (prisonerX < 32 || prisonerX > 1366)){
    image(imgMenu, 0, 0);
    fill(0);
    rect(200, 210, 1000, 400);
    textFont(font);
    fill(255);
    textSize(150);
    text("GAME OVER", 340, 460);
    fill(255);
    textSize(60);
    text("The Prisoner Won!", 460, 550);
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
        intGCount = intOfficerGCount;
        officerY -= intOfficerSpeed;
        // Collision under the prisoner
        if((officerY <= prisonerY + TILE_HEIGHT) && officerY >= prisonerY && ((officerX + TILE_WIDTH >= prisonerX && officerX + TILE_WIDTH <= prisonerX + TILE_WIDTH) || (officerX >= prisonerX && officerX <= prisonerX + TILE_WIDTH))) {
          blnGuardWin = true;
        }
      }
    }
    
    // Move down
    if (strOfficerDirection == "DOWN") {
      if (keyCode == DOWN) {
        officerY += intOfficerSpeed;
        intGCount = intOfficerGCount;
        // Collision above the prisoner
        if((officerY + TILE_HEIGHT >= prisonerY) && officerY <= prisonerY + TILE_HEIGHT && ((officerX + TILE_WIDTH >= prisonerX && officerX + TILE_WIDTH <= prisonerX + TILE_WIDTH) || (officerX >= prisonerX && officerX <= prisonerX + TILE_WIDTH))) {
          blnGuardWin = true;
      }
    }
  }

    // Move left
    if (strOfficerDirection == "LEFT") {
      if (keyCode == LEFT) {
        officerX -= intOfficerSpeed;
        // Collision on the right side of the prisoner
        if((officerX <= prisonerX + TILE_WIDTH) && officerX >= prisonerX && ((officerY >= prisonerY && officerY <= prisonerY + TILE_HEIGHT) || (officerY + TILE_HEIGHT >= prisonerY && officerY + TILE_HEIGHT <= prisonerY + TILE_HEIGHT))) {
          blnGuardWin = true;
        }
      }
    }

    // Move right
    if (strOfficerDirection == "RIGHT") {
      if (keyCode == RIGHT) {
        officerX += intOfficerSpeed;
        // Collision on the left side of the prisoner
        if((officerX + TILE_WIDTH >= prisonerX) && officerX <= prisonerX + TILE_WIDTH && ((officerY >= prisonerY && officerY <= prisonerY + TILE_HEIGHT) || (officerY + TILE_HEIGHT >= prisonerY && officerY + TILE_HEIGHT <= prisonerY + TILE_HEIGHT))) {
          blnGuardWin = true;
      }
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
          tiles((SCREEN_WIDTH / ROW_COUNT) * x, (SCREEN_HEIGHT / COLUMN_COUNT) * y);
        // If the array value is 1, draw grass
        } else if (intArray[y][x] == 1) {
          grass((SCREEN_WIDTH / ROW_COUNT) * x, (SCREEN_HEIGHT / COLUMN_COUNT) * y);
        // If the array value is 2, draw wall
        } else if (intArray[y][x] == 2) {
          crates((SCREEN_WIDTH / ROW_COUNT) * x, (SCREEN_HEIGHT / COLUMN_COUNT) * y);
          intCrateX = (SCREEN_WIDTH / ROW_COUNT) * x;
          intCrateY = (SCREEN_HEIGHT / COLUMN_COUNT) * y;
        // If the array value is 3, draw key
        } else if (intArray[y][x] == 3) {
          keys((SCREEN_WIDTH / ROW_COUNT) * x, (SCREEN_HEIGHT / COLUMN_COUNT) * y);
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
      {1,2,0,2,2,2,0,0,0,2,0,0,2,0,2,0,2,2,2,0,2,1},
      {1,2,0,0,0,0,0,2,0,2,2,2,2,0,0,0,2,0,2,0,2,1},
      {1,2,0,2,2,0,2,2,0,0,0,0,0,0,2,0,2,0,2,0,2,1},
      {1,0,0,0,0,0,0,2,0,2,2,2,2,0,2,0,0,0,0,0,2,1},
      {1,2,2,0,2,2,0,2,0,2,0,0,2,0,0,0,2,2,2,2,2,1},
      {1,2,0,0,0,0,0,2,0,0,0,0,0,0,2,0,0,0,0,0,0,1},
      {1,2,0,2,2,2,0,2,0,2,0,0,2,0,2,0,2,2,0,2,2,1},
      {1,2,0,0,0,0,0,0,0,2,2,2,2,0,2,0,0,0,0,0,2,1},
      {1,2,0,2,0,2,0,2,0,0,0,0,0,0,2,2,0,2,2,0,2,1}, 
      {1,2,0,0,0,2,0,2,0,2,2,2,2,0,2,0,0,0,0,0,2,1},
      {1,2,2,2,0,2,0,0,0,2,0,0,2,0,0,0,2,2,2,0,2,1},
      {1,1,1,2,0,0,0,2,0,0,0,0,0,0,2,0,0,0,0,0,2,1},
      {1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };         
  }
}