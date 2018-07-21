package NiuKe.Base;

public class Power {

	public static void main(String[] args) {
		System.out.println(power(2.0,-3));
		
	}
	
	 public static double power(double base, int exponent) {
		double result = 1.0;
		for(int i=0;i<exponent;i++) {
			result = base * result;
		}
		return result;
	        
	        
	  }

}
