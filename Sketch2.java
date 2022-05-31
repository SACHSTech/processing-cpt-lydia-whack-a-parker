import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
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
    // Import background`
    imgBackground = loadImage("ground_04.png");
    imgOfficerBack1 = loadImage("player_01.png");
    imgOfficerBack2 = loadImage("player_02.png");
    imgOfficerFront1 = loadImage("player_04.png");
    imgOfficerFront2 = loadImage("player_05.png");
    imgOfficerLeft1 = loadImage("player_013.png");
    imgOfficerLeft2 = loadImage("player_014.png");
    imgOfficerRight1 = loadImage("player_010.png");
    imgOfficerRight2 = loadImage("player_011.png");

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
    image(imgOfficerFront1, officerX, officerY);

    // Move up
    if (keyPressed) {
      if (keyCode == UP) {
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