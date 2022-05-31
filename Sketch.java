import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

	/**
   * Assignment: 6.1 Processing in Java CPT
   * Author: Lydia He, Parker Yang
   * Due Jun 13, 11:59 PM
   * Description: WHACK-A-MOLE
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
  float officerX = 350;
  float officerY = 600;
  float officerXspeed = 3;
  float officerYspeed = 3;

  // Make array
  PImage[] officer_frames;
  int intOfficer_frames = 8;

  public void settings() {
	// put your size call here
    size(1300, 700);

  }

  public void setup() {
    // Import background
    imgBackground = loadImage("ground_04.png");
    imgOfficerBack1 = loadImage("player_01.png");
    imgOfficerBack2 = loadImage("player_02.png");
    imgOfficerFront1 = loadImage("player_04.png");
    imgOfficerFront2 = loadImage("player_05.png");
    imgOfficerLeft1 = loadImage("player_013.png");
    imgOfficerLeft2 = loadImage("player_014.png");
    imgOfficerRight1 = loadImage("player_010.png");
    imgOfficerRight2 = loadImage("player_011.png");

    // Load frames
    officer_frames = new PImage[intOfficer_frames];

  }

  public void draw() {
    // Draws background
    for(int intRow = 0; intRow < 1300; intRow+=125){
      for(int intColumn = 0; intColumn <= 700; intColumn+=125){
        image(imgBackground, intRow, intColumn);
      }
    }
     // Officer
     image(imgOfficerFront1, officerX, officerY);

     // Move up
     if (keyPressed) {
       if (keyCode == UP) {
         image(imgOfficerFront1, officerX, officerY);
         officerY -= 3;
     }
   }
 
     // Move down
     if (keyPressed) {
       if (keyCode == DOWN) {
         officerY += 3;
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

  // Collision Detection
  officerX += officerXspeed;
  officerY += officerYspeed;

  if (officerX < 0 || officerX > width) {
    officerXspeed *= -1;
  }

  if (officerY < 0 || officerY > height) {
    officerYspeed *= -1;
  }

  }
 }