package practice;

import processing.core.*;

public class HappyFace extends PApplet{
	public void setup() {
		size(400,400);				// set canvas size
		background(200,200,200);	// set background color for canvas
		stroke(0);					// set pen color
	}
	public void draw() {
		fill(255,209,0);			// bright yellow color for happy face
		ellipse(200,200,390,390);	// the face circle
		fill(0);					// black color for eyes and mouth
		ellipse(100,150,50,50);		// left eye
		ellipse(300,150,50,50);		// right eye
//		noFill();					// if you just want the smile outline
		arc(200,250,70,70,0,PI);	// smiling mouth
	}
}