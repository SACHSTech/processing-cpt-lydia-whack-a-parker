import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {

	/**
   * Assignment: 6.1 Processing in Java CPT
   * Author: Lydia He, Parker Yang
   * Due Jun 13, 11:59 PM
   * Description: WHACK-A-MOLE
   */

  PImage imgBackground;
  PImage imgOfficer1;
  PImage imgOfficer2;
  PImage imgOfficer3;
  PImage imgOfficer4;
  float officerX = 350;
  float officerY = 600;
  float officerXspeed = 3;
  float officerYspeed = 3;

  public void settings() {
	// put your size call here
    size(1300, 700);

  }

  public void setup() {
    // Import bg
    imgBackground = loadImage("ground_04.png");
    imgOfficer1 = loadImage("player_01.png");
    imgOfficer2 = loadImage("player_03.png");
    imgOfficer3 = loadImage("player_09.png");
    imgOfficer4 = loadImage("player_012.png");

  }

  public void draw() {
    // Draws background
    for(int intRow = 0; intRow < 1300; intRow+=125){
      for(int intColumn = 0; intColumn <= 700; intColumn+=125){
        image(imgBackground, intRow, intColumn);
      }
    }
     // Officer
     image(imgOfficer1, officerX, officerY);

     // Move up
     if (keyPressed) {
       if (keyCode == UP) {
         image(imgOfficer1, officerX, officerY);
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