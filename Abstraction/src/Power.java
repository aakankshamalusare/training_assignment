import java.math.BigInteger;

public class Power {
	
	BigInteger egg;



	public Power() {
		
		egg =  BigInteger.valueOf(1);
	}
	

	public void power(int num) {
		
		for(int i=1;i<=num;i++) {
			
			egg = egg.add(egg.pow(i+1));
			String numDigits = egg.toString();
			System.out.println("Person " + i + " : "+numDigits);
			
		}
	}

	public static void main(String[] args) {
	
		Power p =  new Power();
		p.power(37);

	}

}
