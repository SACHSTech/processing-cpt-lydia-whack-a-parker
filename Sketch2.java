import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {

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
    size(1300, 700);

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
    imgCrates = loadImage("crate_04.png");

    // Load frames
    officer_frames = new PImage[intOfficer_frames];

    // Resize images
    imgCrates.resize(imgCrates.width/2, imgCrates.height/2);

  }

  public void draw() {
    // Draws background
    for(int intRow = 0; intRow < 1300; intRow+=125){
      for(int intColumn = 0; intColumn <= 700; intColumn+=125){
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
        intCount = 3; 
  }
 }
     // Move right
     if (keyPressed) {
      if (keyCode == RIGHT) {
       officerX += 3;
       intCount = 4;
       
    }
   }
   // intCount = 0;

   // Border 
   if (officerY > 537){
     officerY = 537;
   } else if (officerY < 62){
     officerY = 62;
   } else if (officerX > 1138){
     officerX = 1138;
   } else if (officerX < 62){
     officerX = 62;
   }
   // Loop to draw crates in the border
   for(int intRow = 0; intRow < width; intRow+=62.5){
      image(imgCrates, intRow, 0);
      image(imgCrates, intRow, 637);
   }
   for(int intColumn = 0; intColumn < height; intColumn+=64){
    image(imgCrates, 0, intColumn);
    image(imgCrates, 1238, intColumn);
   }
  }
  
  // Method to create crates (aka, walls)
  public void crates(float crateX, float crateY){
    image(imgCrates, crateX, crateY);
  }
 }