package practice;

// Familiarising with memory models and variable assignment for primitive data
public class IntAssignTester {
	public static void main(String[] args) {
		int var1 = 17;
		int var2 = var1 + 1;
		var1 = var2 + 1;
		System.out.println("var1: "+var1+", var2: "+var2);
		var1 = 52;
		var2 = var1;
		var1 = 127;
		System.out.println("var1: "+var1 +", var2: "+var2);
	}
}