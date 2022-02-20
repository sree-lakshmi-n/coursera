package practice;

// Familiarising with memory models of objects
public class LocationTester {
	public static void main(String[] args) {
		double d = -77.0;
		SimpleLocation lima = new SimpleLocation(-12.0,d);
		SimpleLocation washDC = new SimpleLocation(38.9,lima.longitude);
		lima.longitude = -12.04;
		System.out.println("lima \n latitude: "+lima.latitude+"\n longitude: "+lima.longitude);
		System.out.println("washDC \n latitude: "+washDC.latitude+"\n longitude: "+washDC.longitude);
		lima = washDC;
		lima.latitude = -8.3;
		System.out.println("lima \n latitude: "+lima.latitude+"\n longitude: "+lima.longitude);
		System.out.println("washDC \n latitude: "+washDC.latitude+"\n longitude: "+washDC.longitude);
	}
}