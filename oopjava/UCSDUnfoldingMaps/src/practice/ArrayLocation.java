package practice;

// Object types as private variable
public class ArrayLocation {
	private double coords[];
	public ArrayLocation(double[] coords) {
		this.coords = coords;
	}
	public static void main(String[] args) {
		double[] coords = {5.0,0.0};
		ArrayLocation accra = new ArrayLocation(coords);
		coords[0] = 32.9;
		coords[1] = -117.2;
		System.out.println(accra.coords[0]);
	}
}
/* Even though coords was a private variable, we were able to change it without any setter methods or
 * without going into variables of that object. 
 * When we use object types, we need to worry about what is allowed to refer to that object.
 * Its value may change in unintended ways.
 * */