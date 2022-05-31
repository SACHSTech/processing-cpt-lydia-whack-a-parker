import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
  PImage imgBackground;
  PImage imgOfficer1;
  PImage imgOfficer2;
  PImage imgOfficer3;
  PImage imgOfficer4;
  float officerX = 350;
  float officerY = 600;
  
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1300, 700);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    // Import background
    imgBackground = loadImage("ground_04.png");
    imgOfficer1 = loadImage("player_01.png");
    imgOfficer2 = loadImage("player_03.png");
    imgOfficer3 = loadImage("player_09.png");
    imgOfficer4 = loadImage("player_012.png");

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // Draws background (grid)
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
        officerY-=3;
    }
  }

    // Move down
    if (keyPressed) {
      if (keyCode == DOWN) {
        officerY+=3;
  }
 }
   // Move left
   if (keyPressed) {
    if (keyCode == LEFT) {
      officerX-=3;
 }
}
    // Move right
    if (keyPressed) {
     if (keyCode == RIGHT) {
      officerX+=3;
   }
  } 
 }
}