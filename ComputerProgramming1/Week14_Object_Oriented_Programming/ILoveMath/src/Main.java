
public class Main {
	public static void main(String[] args) {
		
		//도형 객체들을 가리킬 참조변수의 배열 선언
		//이 때, 각각의 도형은 Shape클래스의 자식클래스이므로 상향형변환되어 배열에 저장된다.
		Shape[] shapes = new Shape[3];
		shapes[0] = new Triangle(2,1);
		shapes[1] = new Rectangle(2,2);
		shapes[2] = new Circle(4);
		
		//각각의 넓이 출력
		for(Shape shape : shapes) {
			System.out.println(shape.getClass().getName() + "의 넓이 : " + shape.area());
		}
	}
}
 