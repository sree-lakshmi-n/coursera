package practice;

// Familiarising with local and member variables
public class LocationScopeTester {
	public static void main(String[] args) {
		double latitude = -15.5;
		SimpleLocation lima = new SimpleLocation(latitude,-77.0);
		latitude = -12.0;
		System.out.println(lima.latitude);
	}
}