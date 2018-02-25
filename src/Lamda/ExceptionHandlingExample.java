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

		process(someNumbers, key1, wrapperLambda((v, k) -> System.out.println(v / k)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}
	}

	// 再用一層LAMBDA包起來PASS到另一個LAMBDA
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		// return (v, k) -> System.out.println(v + k);
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			} catch (ArithmeticException e) {
				System.out.println("Exception caught in wrapper lambda");

			}
		};
	}

}
