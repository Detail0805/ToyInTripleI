package String;

class ClassA {

	private void say() {
		System.out.println("------");
	}
}

class ClassB extends ClassA { // 在另外的地方宣告class，並且繼承或是實作ClassA

	public void function1(int x, int y) {
		System.out.println(x + y);
	}

	public int function2(int x) {
		return x + 1;
	}
}

public class MainClass {

	public static void main(String[] args) {
		ClassA a = new ClassA() { // 實體化匿名類別
			public void function1(int x, int y) {
				System.out.println(x + y);
				System.out.println("---------------------");
			}

			public int function2(int x) {
				return x + 1;
			}
		};
		ClassB b = new ClassB();
		b.function1(2, 3);

	}

}
