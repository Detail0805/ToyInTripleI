package SimpleFactory;

public class CarFactory {
	
	public Car creatCar(String type) {
		
		if(type.equals("bmw")) {
			return new Bmw();
		}if(type.equals("audi")) {
			return new Audi();
		}else {
			return null;
		}
	}
}
