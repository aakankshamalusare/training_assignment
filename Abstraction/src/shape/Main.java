package shape;

public class Main {

	public static void main(String[] args) {
	
		Shape circle =  new Circle(4.54);
		circle.calculateArea();
		circle.calculatePerimeter();
		
		System.out.println("-------------------");
		
		Shape reactangle = new Reactangle(2,3);
		reactangle.calculateArea();
		reactangle.calculatePerimeter();
		
		System.out.println("-------------------");
		
		Shape triangle = new Triangle(6,4,3,2);
		triangle.calculateArea();
		triangle.calculatePerimeter();

		System.out.println("-------------------");
	}

}
