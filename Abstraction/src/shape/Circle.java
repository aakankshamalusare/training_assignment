package shape;

public class Circle implements Shape{
	
	private double radius;
	
	public Circle(double radius) {
		
		if(radius>0) {
			this.radius = radius;
		}else {
			
			System.out.println("Invalid value");
		}
	}

	@Override
	public void calculateArea() {
	
		System.out.println("Area of Circle: "+(Math.PI*radius*radius));
		
	}

	@Override
	public void calculatePerimeter() {
		
		System.out.println("Perimeter of Circle: "+(2*Math.PI*radius));
		
	}
	

}
