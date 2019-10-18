
public abstract class Shape {
	int width;
	int height;
	
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	//도형마다 넓이를 구현하는 방식이 다르므로 추상메서드로 구현
	abstract double area();
}

class Triangle extends Shape {

	public Triangle(int width, int height) {
		super(width, height);
	}
	//Shape 클래스의 area 메서드 재정의
	@Override
	double area() {
		return width * height * 0.5;
	}
	
}

class Rectangle extends Shape {

	public Rectangle(int width, int height) {
		super(width, height);
	}
	//Shape 클래스의 area 메서드 재정의
	@Override
	double area() {
		return width * height;
	}
	
}

class Circle extends Shape {

	//넓이 계산을 위한 리터럴 상수 PI 정의
	static final double PI = 3.1415;
	double r;
	
	public Circle(double r) {
		super(-1, -1);
		this.r = r;
	}

	@Override //Shape 클래스의 area 메서드 재정의
	double area() {
		return r * r * PI;
	}
}
