import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

	/**
   * Assignment: 6.1 Processing in Java CPT
   * Author: Lydia He, Parker Yang
   * Due Jun 13, 11:59 PM
   * Description: 
   */

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
  PImage imgCrates;
  PImage imgGrass;
  float officerX = 650;
  float officerY = 350;
  float officerXspeed = 3;
  float officerYspeed = 3;
  int intCount;

  // Make array
  PImage[] officer_frames;
  int intOfficer_frames = 8;

  public void settings() {
	// put your size call here
    size(1400, 820);

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
    imgGrass = loadImage("ground_03.png");
    imgCrates = loadImage("crate_04.png");

    // Load frames
    officer_frames = new PImage[intOfficer_frames];

    // Resize images
    imgGrass.resize(imgGrass.width/2, imgGrass.height/2);
    imgCrates.resize(imgCrates.width/2, imgCrates.height/2);

    /*
    imgOfficerBack1.resize(imgOfficerBack1.width/2, imgOfficerBack1.height/2);
    imgOfficerBack2.resize(imgOfficerBack2.width/2, imgOfficerBack2.height/2);
    imgOfficerFront1.resize(imgOfficerFront1.width/2, imgOfficerFront1.height/2);
    imgOfficerFront2.resize(imgOfficerFront2.width/2, imgOfficerFront2.height/2);
    imgOfficerLeft1.resize(imgOfficerLeft1.width/2, imgOfficerLeft1.height/2);
    imgOfficerLeft2.resize(imgOfficerLeft2.width/2, imgOfficerLeft2.height/2);
    imgOfficerRight1.resize(imgOfficerRight1.width/2, imgOfficerRight1.height/2);
    imgOfficerRight2.resize(imgOfficerRight2.width/2, imgOfficerRight2.height/2);
    imgOfficerStill.resize(imgOfficerStill.width/2, imgOfficerStill.height/2);
    */

  }

  public void draw() {
    // Draws background
    for(int intRow = 0; intRow < 1500; intRow+=125){
      for(int intColumn = 0; intColumn <= 900; intColumn+=125){
        image(imgBackground, intRow, intColumn);
      }
    }

     // Officer image based on which way hes talking 
     if(intCount == 1){
       image(imgOfficerBack1, officerX, officerY);
     } else if (intCount == 2){
       image(imgOfficerFront1, officerX, officerY);
     } else if (intCount == 3){
       image(imgOfficerLeft1, officerX, officerY);
     } else if (intCount == 4){
       image(imgOfficerRight1, officerX, officerY);
     } else if (intCount == 0){
       image(imgOfficerStill, officerX, officerY);
     }
    
    /**
     * Draws Grass (Outer Border Grass is 63 x 63)
     * grass(grassX, grassY);
     * Top row (23) Grass
     */
    for (int i = 0; i < 23; i++) {
      grass(63*i, 0);
    }
    // Left Column Grass
    for (int i = 0; i < 19; i++) {
      grass(0, 63*i);
    }
    // Right Column Grass
    for (int i = 0; i < 19; i++) {
      grass(1323, 63*i);
      grass(1386, 63*i);
    }
    // Bottom Row ✋ Grass (starts at 780)
    for (int i = 0; i < 23; i++) {
      grass(63*i, 780);
    }

    /** 
     * Draws Crates (Crates are 63 x 63, top of crate is 40, side is 23)
     * crates(crateX, crateY);
     * Top Row (20 Crates)
     * */
    for (int i = 0; i < 20; i++) {
      crates(63 + 63*i, 40);
    }
    // Left Column Pt1 (7 Crates) 
    for (int i = 0; i < 7; i++) {
      crates(63, 40 + 40*i);
    }
    // Left Column Pt2 (8 Crates) (40*8 + 63 + 57 = 400)
    for (int i = 0; i < 8; i++) {
      crates(63, 400 + 40*i);
    }
    // Right Column Pt1 (9 Crates) 
    for (int i = 0; i < 9; i++) {
      crates(1260, 40 + 40*i);
    }
    // Right Column Pt2 (6 Crates) (40*9 + 63 + 57 = 480)
    for (int i = 0; i < 6; i++) {
      crates(1260, 480 + 40*i);
    }
    // Bottom Row (20 Crates)
    for (int i = 0; i < 20; i++) {
      crates(63 + 63*i, 720);
    }

    // Move up
    if (keyPressed) {
      if (keyCode == UP) {
        officerY -= 3;
        intCount = 1;
      }
    }
    // Move down
    if (keyPressed) {
      if (keyCode == DOWN) {
        officerY += 3;
        intCount = 2;
      }
    }
    // Move left
    if (keyPressed) {
      if (keyCode == LEFT) {
        officerX -= 3; 
      }
    }
    // Move right
    if (keyPressed) {
      if (keyCode == RIGHT) {
        officerX += 3;
      }
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

  }

  // Method to create grass
  public void grass(float grassX, float grassY){
    image(imgGrass, grassX, grassY);
  }

  // Method to create crates (aka, walls)
  public void crates(float crateX, float crateY){
    image(imgCrates, crateX, crateY);
  }
}