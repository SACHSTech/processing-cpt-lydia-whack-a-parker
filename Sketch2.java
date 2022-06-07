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
  PImage imgPrisonerFront1;
  PImage imgPrisonerBack1;
  PImage imgPrisonerStill;
  float officerX = 650;
  float officerY = 350;
  float prisonerX = 150;
  float prisonerY = 350;
  int intGCount;
  int intPCount;

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
    imgPrisonerFront1 = loadImage("prisoner_04.png");
    imgPrisonerBack1 = loadImage("prisoner_01.png");
    imgPrisonerStill = loadImage("prisoner_03.png");
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
     if(intGCount == 1){
       image(imgOfficerBack1, officerX, officerY);
     } else if (intGCount == 2){
       image(imgOfficerFront1, officerX, officerY);
     } else if (intGCount == 3){
       image(imgOfficerLeft1, officerX, officerY);
     } else if (intGCount == 4){
       image(imgOfficerRight1, officerX, officerY);
     } else {
       image(imgOfficerStill, officerX, officerY);
     }

      // Prisoner image based on which way hes talking 
      if(intPCount == 1){
        image(imgPrisonerBack1, prisonerX, prisonerY);
      } else if (intPCount == 2){
        image(imgPrisonerFront1, prisonerX, prisonerY);
      } else {
        image(imgPrisonerStill, prisonerX, prisonerY);
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

     // Officer move up
     if (keyPressed) {
       if (keyCode == UP) {
         officerY -= 3;
         intGCount = 1;
   }
  }
     // Officer move down
     if (keyPressed) {
       if (keyCode == DOWN) {
         officerY += 3;
         intGCount = 2;
   }
  }
     // Officer move left
     if (keyPressed) {
      if (keyCode == LEFT) {
        officerX -= 3; 
   }
  }
     // Officer move right
     if (keyPressed) {
      if (keyCode == RIGHT) {
        officerX += 4;
       
   }
  }
       // Prisoner move up
       if (keyPressed) {
        if (keyCode == 'w') {
          prisonerY -= 4;
          intPCount = 1;
   }
  }
       // Prisoner move down
       if (keyPressed) {
        if (keyCode == 's') {
          prisonerY += 4;
          intPCount = 2;
   }
  }
       // Prisoner move left
       if (keyPressed) {
        if (keyCode == 'a') {
          prisonerX -= 4; 
   }
  }
       // Prisoner move right
       if (keyPressed) {
        if (keyCode == 'd') {
          prisonerX += 4; 
   }
  }

   // Border for guard
   if (officerY > 674){
     officerY = 674;
   } else if (officerY < 112){
     officerY = 112;
   } else if (officerX > 1272){
     officerX = 1272;
   } else if (officerX < 128){
     officerX = 128;
   }

   // Border for prisoner
   if (prisonerY > 674){
     prisonerY = 674;
   } else if (prisonerY < 112){
     prisonerY = 112;
   } else if (prisonerX > 1272){
     prisonerX = 1272;
   } else if (prisonerX < 128){
     prisonerX = 128;
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