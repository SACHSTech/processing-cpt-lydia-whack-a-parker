import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
  PImage imgBackground;
  
	
	
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
  
  // define other methods down here.
 }
}
