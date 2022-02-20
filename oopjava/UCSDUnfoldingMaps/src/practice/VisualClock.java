package practice;

import processing.core.*;

public class VisualClock extends PApplet{
	private String url = "https://i.insider.com/5bfec49248eb12058423acf7";
	private PImage backgroundImg;
	public void setup() {
		// Setup code for PApplet
		size(800,600);				// set canvas size
		background(255,255,255);	// set background color for canvas
		stroke(0);					// set pen color
		backgroundImg = loadImage(url,"jpg");
	}
	public void draw() {
		image(backgroundImg,0,0);
		backgroundImg.resize(0, height);				// resize image to full height of canvas
		int[] color = sunColorSec(second());			// array for rgb code of sun
		fill(color[0],color[1],color[2]);				// rgb color for sun
		ellipse(width/4,height/5,width/5,height/5);		// setting coordinates, width, and height of sun
	}
	public int[] sunColorSec(float seconds) {
		int[] rgb = new int[3];
		float diffFrom30 = Math.abs(30-seconds);		// Scaling brightness of yellow based on the seconds
		float ratio = diffFrom30/30;					// 0 seconds is bright yellow. 30s is black.
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;
		return rgb;
	}
}