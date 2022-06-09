import processing.core.PApplet;
import processing.core.PImage;

public class Sketch3 extends PApplet {
  
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
  PImage imgGrass;
  float officerX = 650;
  float officerY = 350;
  float prisonerX = height/2;
  float prisonerY = width/2;
  float officerXspeed = 3;
  float officerYspeed = 3;
  int intGCount;
  int intPCount;
  int intHeight = 1400;
  int intWidth = 820;
  int[][] intArray;

  // Make array
  PImage[] officer_frames;
  int intOfficer_frames = 8;

  public void settings() {
	// put your size call here
    size(intHeight, intWidth);
    intArray = arrayGame();

  }

  public void setup() {
    // Import images
    imgBackground = loadImage("ground_04.png");
    imgOfficerBack1 = loadImage("player_01.png");
    imgOfficerBack2 = loadImage("player_02.png");
    imgOfficerFront1 = loadImage("player_04.png");
    imgOfficerFront2 = loadImage("player_05.png");
    imgOfficerLeft1 = loadImage("player_013.png");
    imgOfficerLeft2 = loadImage("player_014.png");
    imgOfficerRight1 = loadImage("player_010.png");
    imgOfficerRight2 = loadImage("player_011.png");
    imgOfficerStill = loadImage("player_03.png");
    imgPrisonerFront1 = loadImage("prisoner_04.png");
    imgPrisonerBack1 = loadImage("prisoner_01.png");
    imgPrisonerStill = loadImage("prisoner_03.png");
    imgGrass = loadImage("ground_03.png");
    imgCrates = loadImage("crate_04.png");

    // Load frames
    officer_frames = new PImage[intOfficer_frames];

    // Resize images
    imgGrass.resize(imgGrass.width/2, imgGrass.height/2);
    imgCrates.resize(imgCrates.width/2, imgCrates.height/2);

    
    // Resize officer (red and green guy)
    imgOfficerBack1.resize(imgOfficerBack1.width/2, imgOfficerBack1.height/2);
    //imgOfficerBack2.resize(imgOfficerBack2.width/2, imgOfficerBack2.height/2);
    imgOfficerFront1.resize(imgOfficerFront1.width/2, imgOfficerFront1.height/2);
    /* 
    imgOfficerFront2.resize(imgOfficerFront2.width/2, imgOfficerFront2.height/2);
    imgOfficerLeft1.resize(imgOfficerLeft1.width/2, imgOfficerLeft1.height/2);
    imgOfficerLeft2.resize(imgOfficerLeft2.width/2, imgOfficerLeft2.height/2);
    imgOfficerRight1.resize(imgOfficerRight1.width/2, imgOfficerRight1.height/2);
    imgOfficerRight2.resize(imgOfficerRight2.width/2, imgOfficerRight2.height/2);
    */
    imgOfficerStill.resize(imgOfficerStill.width/2, imgOfficerStill.height/2);
    
    // Resize prisoner (orange guy)
    imgPrisonerBack1.resize(imgPrisonerBack1.width/2, imgPrisonerBack1.height/2);
    imgPrisonerFront1.resize(imgPrisonerFront1.width/2, imgPrisonerFront1.height/2);
    imgPrisonerStill.resize(imgPrisonerStill.width/2, imgPrisonerStill.height/2);
  }

  public void draw() {

    // Draws background
    for(int intRow = 0; intRow < 1500; intRow+=125){
      for(int intColumn = 0; intColumn <= 900; intColumn+=125){
        image(imgBackground, intRow, intColumn);
      }
    }

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
      moveOfficer("LEFT", 0, 3);
      moveOfficer("RIGHT", 0, 3);
    }

    // Prisoner movement
    if (keyPressed) {
      movePrisoner("w", 1, 4);
      movePrisoner("s", 2, 4);
      movePrisoner("a", 0, 4);
      movePrisoner("d", 0, 4);
    }

   // Border 
   if (officerY > 684) {
     officerY = 684;
   } else if (officerY < 114) {
     officerY = 114;
   } else if (officerX > 1289) {
     officerX = 1289;
   } else if (officerX < 111) {
     officerX = 111;
   }
   
   // Border for prisoner
   if (prisonerY > 674){
     prisonerY = 674;
   } else if (prisonerY < 112){
     prisonerY = 112;
   } else if (prisonerX > 1272){
     prisonerX = 1272;
   } else if (prisonerX < 128){
     prisonerX = 128;
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
   * Method to create a key 
   * @param keyX is a float that reads the x-value of the key image
   * @param keyY is a float that reads the y-value of the key image
   */
  public void keys(float keyX, float keyY){
    //image(imgKeys, keyX, keyY);
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

  // Array for drawing everything
  public int[][] arrayGame() {
      return new int[][] {
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