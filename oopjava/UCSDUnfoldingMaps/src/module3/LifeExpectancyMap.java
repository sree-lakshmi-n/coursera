// Visualising Life Expectancy in different countries
package module3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancyMap extends PApplet{
	UnfoldingMap map;
	Map<String,Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup() {
		size(800,600,OPENGL);	// size of canvas
		map = new UnfoldingMap(this,50,50,700,700,new Google.GoogleMapProvider());	// setting up map
		MapUtils.createDefaultEventDispatcher(this, map); // allows user to interact with map
		
		lifeExpByCountry = loadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
		// 1 Feature and 1 Marker per country
		
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers); // add markers to map
		
		shadeCountries(); // shade countries based on life expectancy
	}
	public void draw() {
		map.draw();
	}
	private void shadeCountries() {			// colouring of countries depend on their life expectancy
		for(Marker marker:countryMarkers) {
			String countryId = marker.getId();
			
			if(lifeExpByCountry.containsKey(countryId)) {
				float lifeExp = lifeExpByCountry.get(countryId);
				int colorLevel = (int)map(lifeExp,40,90,10,255);
				// map -> inbuilt method in processing library that take a number in predefined range and map it to its comparable location in a diff range of values
				// casted to int -> since in rgb, we deal with integers
				marker.setColor(color(255-colorLevel,100,colorLevel));
				// Countries with lower life expectancy will have lower colorLevel, hence bigger value of red and thus they would be shaded bright red.
				// Countries with higher life expectancy will have higher colorLevel,hence lower value of red and thus they would be shaded bright blue.
			}
			else {
				marker.setColor(color(150,150,150));
				// If a countryId doesn't have life expectancy info associated with it, it'll be shaded gray.
			}
		}
	}
	private Map<String,Float> loadLifeExpectancyFromCSV(String fileName){
		Map<String,Float> lifeExpMap = new HashMap<String,Float>();
		String[] rows = loadStrings(fileName); // read files one row at a time
		
		for(String row : rows) {
			String[] columns = row.split(",");	// take a row and split it at ,. As in CSV file, everytime ther's a comma, there's a new field.
			if(columns.length == 6 &&!columns[5].equals("..")) {
				// columns[5] -> lifeExp. Casting String to float
				lifeExpMap.put(columns[4],Float.parseFloat(columns[5])); //countryID -> columns[4]
			}
		}
		
		return lifeExpMap;
	}
}
/*
 * String countryID -> key
 * float lifeExp -> value
 * 
 * Abstract data type: Map
 * 
 * good practice to make helper methods private, wherever possible
 * 
 * 
 * */