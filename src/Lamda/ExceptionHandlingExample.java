package Lamda;

import java.util.function.BiConsumer;


public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int[] someNumbers = { 1, 2, 3, 4 };

		int key = 2;

		process(someNumbers, key, (v, k) -> System.out.println(v + k));
		System.out.println("=====/======");
		process(someNumbers, key, (v, k) -> System.out.println(v / k));

		int key1 = 0;

		process(someNumbers, key1, (v, k) -> {
			try {
				System.out.println(v / k);
			} catch (ArithmeticException e) {
				System.out.println("Exception happened");
			}
		});
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}
	}

}
