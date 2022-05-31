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

  public void settings() {
	// put your size call here
    size(1300, 700);

  }

  public void setup() {
    imgBackground = loadImage("floor.jpg");

    imgBackground.resize(width, height);

  }

  public void draw() {
	  
  }
  
}