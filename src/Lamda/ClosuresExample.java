package Lamda;

public class ClosuresExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;// 自動幫這個值加上final所以後面無法改變
		doProcess(a, new Process() {
			@Override
			public void process(int i) {
				System.out.println(i + b);
			}

		});
		a = 16;
		// b = 17; //無法變更因為他已是final
		// System.out.println(b);
		doProcess(a, i -> System.out.println(i + b));

	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}
