package cracking_Coding_Interviews;

/*
 * Program to show Over-riding and Abstraction in JAVA
 */
public class Abstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shapes [] = new Shape[2];
		shapes[0]= new Circle();
		shapes[1]= new Ambigous();
		
		for(Shape shape : shapes){
			shape.printMe();
			System.out.println("My Area is "+shape.computeArea());
		}
	}
}

abstract class Shape {
	void printMe(){
		System.out.println("I am a Shape");
	}
	
	abstract double computeArea();
}

class Circle extends Shape{
	int radius = 5;
	void printMe(){
		System.out.println("I am a Circle");
	}
	
	double computeArea(){
		return radius*radius*(3.15);
	}
}

class Ambigous extends Shape{
	int width = 5;
	int length = 3;
	
	double computeArea(){
		return length*width;
	}
}
