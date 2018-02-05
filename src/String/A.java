package String;

public class A {

	public A() {
		B b = this::printOnce;
		b.doStringWork("hello!!");
	}

	public static void main(String[] args) {
		B b = A::printTwice;
		System.out.println("B b = A::printTwice ");
		b.doStringWork("嗨");

		System.out.println("-------new A----------");
		new A();
		System.out.println("-------After new A--------");

		C c = Math::pow;
		b.doStringWork(String.valueOf(c.doComputeWork(2.5f, 2)));

	}

	public static void printTwice(String s) {
		System.out.println(" static :" + s);
	}

	public void printOnce(String one) {

		System.out.println(" one :" + one);
	}

}
