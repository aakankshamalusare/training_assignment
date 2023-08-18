package shape;

public class Reactangle implements Shape{
	
	private double length;
	private double breadth;
	
	public Reactangle(double length,double breadth) {
		
		if(length>0 && breadth>0) {
			
			this.length = length;
			this.breadth = breadth;
		}else {
			
			System.out.println("Invalid length or breadth");
		}
	}

	@Override
	public void calculateArea() {
		
		System.out.println("Area of Reactangle: "+(length*breadth));
		
	}

	@Override
	public void calculatePerimeter() {
		 
		System.out.println("Perimeter of Reactangle: "+(2*(length+breadth)));
		
	}

}
