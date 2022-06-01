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
  PImage imgOfficerBack1;
  PImage imgOfficerLeft1;
  PImage imgOfficerRight1;
  PImage imgOfficerStill;
  PImage imgCrates;
  PImage imgGrass;
  float officerX = 650;
  float officerY = 350;
  int intCount;

  // Make array
  PImage[] officer_frames;
  int intOfficer_frames = 8;

  public void settings() {
	// put your size call here
    size(1400, 800);

  }

  public void setup() {
    // Import images
    imgBackground = loadImage("ground_04.png");
    imgOfficerBack1 = loadImage("player_01.png");
    imgOfficerFront1 = loadImage("player_04.png");
    imgOfficerLeft1 = loadImage("player_013.png");
    imgOfficerRight1 = loadImage("player_010.png");
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
    imgOfficerFront1.resize(imgOfficerFront1.width/2, imgOfficerFront1.height/2);
    imgOfficerLeft1.resize(imgOfficerLeft1.width/2, imgOfficerLeft1.height/2);
    imgOfficerRight1.resize(imgOfficerRight1.width/2, imgOfficerRight1.height/2);
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

    // Draws Crates (Crates are 63x63)
    // crates(crateX, crateY);
    // Top Row (21 Crates)
    for (int i = 0; i < 21; i++) {
      crates(63*i, 63);
    }
    // Left Column (17 Crates) 
    for (int i = 0; i < 17; i++) {
      crates(63, 63 + 40*i);
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
        //intCount = 3; 
  }
 }
     // Move right
     if (keyPressed) {
      if (keyCode == RIGHT) {
       officerX += 3;
       //intCount = 4;
       
    }
   }
   // intCount = 0;

   // Border 
   if (officerY > 682){
     officerY = 682;
   } else if (officerY < 112){
     officerY = 112;
   } else if (officerX > 1288){
     officerX = 1288;
   } else if (officerX < 110){
     officerX = 110;
   }
   // Loop to draw grass on the border
   for(int intRow = 0; intRow < width; intRow+=62.5){
      image(imgGrass, intRow, 0);
      image(imgGrass, intRow, 737);
   }
   for(int intColumn = 0; intColumn < height; intColumn+=63){
    image(imgGrass, 0, intColumn);
    image(imgGrass, 1336, intColumn);
   }
  }
  
  // Method to create crates (aka, walls)
  public void crates(float crateX, float crateY){
    image(imgCrates, crateX, crateY);
  }
}