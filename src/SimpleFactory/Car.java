package SimpleFactory;

public interface Car {

	void run();
	default void makeString() { //�`��java8.0�g�k
		System.out.println("�A�n�ڬO�ɭ���ͤ�k");
	}
	
}
