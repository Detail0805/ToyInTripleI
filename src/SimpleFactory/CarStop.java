package SimpleFactory;

public class CarStop {

	public static void main(String[] args) {
		
		
		//我想要獲取CAR物件
		CarFactory carFactory=new CarFactory();
		Audi audi=(Audi)carFactory.creatCar("audi");
		Bmw bmw=(Bmw)carFactory.creatCar("bmw");
		audi.makeString();//介面方法
		audi.run();
		bmw.makeString();//介面方法
		bmw.run();
		System.out.println("---------------------------");
		Audi audi2=(Audi)carFactory.creatAudi();
		Bmw bmw2=(Bmw)carFactory.creatBmw();
		audi2.run();
		bmw2.run();
	}

}
