package Lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class MethodReferenceExample2 {

	public static void main(String[] args) {
		// MethodReferenceExample1::printMessage===()->printMessage()
		// Thread t = new Thread(MethodReferenceExample1::printMessage);
		// t.start();

		List<Person> people = Arrays.asList(new Person("David", "Taiwan", 26), new Person("David2", "naito", 27),
				new Person("Paul", "bato", 28), new Person("Mary", "taipei", 29), new Person("Sunny", "taoyaun", 20),
				new Person("Peter", "Taiwan6", 21));
		System.out.println("people :" + people);

		System.out.println("----------------consumer interface-----------------------------");
		System.out.println("false :");
		performCondition(people, p1 -> false, p -> System.out.println(p));
		System.out.println("=================");
		System.out.println("true :");
		performCondition(people, p1 -> true, p -> System.out.println(p));
		// 測試傳入不同condition
		System.out.println("傳入不同條件測試 P: ");
		performCondition(people, p1 -> p1.getName().startsWith("P"), p -> System.out.println(p));
		System.out.println("傳入不同條件測試 D: ");
		performCondition(people, p1 -> p1.getName().startsWith("D"), p -> System.out.println(p.name));

	}

	// public static void printMessage() {
	// System.out.println("Hello");
	// }

	public static void performCondition(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
		list.forEach(p -> {
			if (predicate.test(p))
				consumer.accept(p);
		});
	}
}
