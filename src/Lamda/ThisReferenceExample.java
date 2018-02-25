package Lamda;

public class ThisReferenceExample {

	public void doProcess(int i, Process p) {
		p.process(i);
	}

	public void execute() {
		// this === ? 已經製造出來object了
		doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			System.out.println(this); // lambda沒有reference

		});
	}

	public static void main(String[] args) {

		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, new Process() {

			@Override
			public void process(int i) {
				System.out.println("Value of i is " + i);
				System.out.println(this);
			}

			public String toString() {
				return "This is the anonymous inner class";
			}
		});
		thisReferenceExample.doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			// System.out.println(this); //lambda沒有reference

		});
		thisReferenceExample.execute();

	}

	public String toString() {
		return "This is main class instance";
	}

}
