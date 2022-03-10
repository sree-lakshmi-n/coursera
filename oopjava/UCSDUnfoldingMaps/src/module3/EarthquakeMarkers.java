// Marks the location of Chile on World Map
// Author: Sree lakshmi
package module3;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;
public class EarthquakeMarkers extends PApplet{
	private UnfoldingMap map;
	public void setup() {
		size(950,600,OPENGL);		// set canvas size
		map = new UnfoldingMap(this,125,50,700,500,new Google.GoogleMapProvider());	
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);	// makes map interactive
		Location valLoc = new Location(-38.14f,-73.03f);	// Earthquake location: Chile
		SimplePointMarker val = new SimplePointMarker(valLoc); // marker on Chile
		map.addMarker(val);			// makes the mark visible
		
	}
	public void draw() {
		background(200);		//set canvas size
		map.draw();				// takes map object and whatever is associated with it and refresh view of map object
		addKey();				// private helper method
	}
	private void addKey() {
		// TODO Auto-generated method stub
		
	}
}