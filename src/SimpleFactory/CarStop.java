package SimpleFactory;

public class CarStop {

	public static void main(String[] args) {
		
		
		//�ڷQ�n���CAR����
		CarFactory carFactory=new CarFactory();
		Audi audi=(Audi)carFactory.creatCar("audi");
		Bmw bmw=(Bmw)carFactory.creatCar("bmw");
		audi.makeString();//������k
		audi.run();
		bmw.makeString();//������k
		bmw.run();
	}

}
