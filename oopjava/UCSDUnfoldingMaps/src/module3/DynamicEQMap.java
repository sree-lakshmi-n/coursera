// Customising markers according to the year in which earthquake occured
// Author: Sree lakshmi
// Source: UC San Diego Intermediate Software Development MOOC team

package module3;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class DynamicEQMap extends PApplet{
	private UnfoldingMap map;
	public void setup() {
		size(1050,600,OPENGL);	// canvas size
		// Create a new UnfoldingMap to be displayed in this window. 
		// The 2nd-5th arguments give the map's x, y, width and height
		// The 6th argument specifies the map provider.
		map = new UnfoldingMap(this,25,50,1000,500,new Google.GoogleMapProvider());
		// To zoom into the map
		map.zoomToLevel(2);
		//  This line makes the map interactive
		MapUtils.createDefaultEventDispatcher(this, map);
		
		// Location: Valdivia, Chile
		Location valLoc = new Location(-38.14f,-73.03f);
		// Adding features to given location
		Feature valEq = new PointFeature(valLoc);
		valEq.addProperty("title", "Valdivia, Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22, 1960");
		valEq.addProperty("year", "1960");
		
		// Location: Alaska
		Location alaskaLoc = new Location(61.02f,-147.65f);
		// Adding features to given location
		Feature alaskaEq = new PointFeature(alaskaLoc);
		alaskaEq.addProperty("title", "Great Alaska Earthquake");
		alaskaEq.addProperty("magnitude", "9.2");
		alaskaEq.addProperty("date", "Mar 28, 1964");
		alaskaEq.addProperty("year", "1964");
		
		// Location: Sumatra
		Location sumatraLoc = new Location(3.30f,95.78f);
		// Adding features to given location
		Feature sumatraEq = new PointFeature(sumatraLoc);
		sumatraEq.addProperty("title", "Off the west coast of Sumatra");
		sumatraEq.addProperty("magnitude", "9.1");
		sumatraEq.addProperty("date", "Dec 26, 2004");
		sumatraEq.addProperty("year", "2004");
		
		// Location: Honshu, Japan
		Location japanLoc = new Location(38.322f,142.369f);
		// Adding features to given location
		Feature japanEq = new PointFeature(japanLoc);
		japanEq.addProperty("title", "Near the East Coast of Honshu, Japan");
		japanEq.addProperty("magnitude", "9.0");
		japanEq.addProperty("date", "Mar 11, 2011");
		japanEq.addProperty("year", "2011");
		
		// Location: Kamchatka
		Location kamchatkaLoc = new Location(52.76f,160.06f);
		// Adding features to given location
		Feature kamchatkaEq = new PointFeature(kamchatkaLoc);
		kamchatkaEq.addProperty("title", "Kamchatka");
		kamchatkaEq.addProperty("magnitude", "9.0");
		kamchatkaEq.addProperty("date", "nov 04, 1952");
		kamchatkaEq.addProperty("year", "1952");
		
		// Adding location features to a list
		List<PointFeature> bigEqs = new ArrayList<PointFeature>();
		bigEqs.add((PointFeature) valEq);
		bigEqs.add((PointFeature) alaskaEq);
		bigEqs.add((PointFeature) sumatraEq);
		bigEqs.add((PointFeature) japanEq);
		bigEqs.add((PointFeature) kamchatkaEq);
		
		// Creating markers for each locations and properties
		List<Marker> markers = new ArrayList<Marker>();
		for(PointFeature eq: bigEqs) {
			Marker mk = new SimplePointMarker(eq.getLocation(),eq.getProperties());
			markers.add(mk);
		}
		
		// Customising EQ Markers
		int yellow = color(255,255,0);
		int gray = color(150,150,150);
		for(Marker mk: markers) {
			if(Integer.parseInt((String) mk.getProperty("year"))> 2000)
				mk.setColor(yellow);
			else
				mk.setColor(gray);
		}
		map.addMarkers(markers);
	}
	public void draw() {
		background(200);
		map.draw();
		addKey();
	}
	private void addKey() {
		// TODO Auto-generated method stub
		
	}
}