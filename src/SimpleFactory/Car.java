package SimpleFactory;

public interface Car {

	void run();
	default void makeString() { //常識java8.0寫法
		System.out.println("你好我是界面原生方法");
	}
	
}
