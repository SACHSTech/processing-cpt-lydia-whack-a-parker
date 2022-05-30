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
    imgBackground = loadImage("floor.jpg");

    imgBackground.resize(width, height);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  image(imgBackground, 0, 0);

  }
  
  // define other methods down here.
}
