package Lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import String.ChangeInteger;


public class Test {
	// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
	int a = 0;
	String count = "0";

	ChangeInteger ci = x -> {
		count = count + x;
		return 1;
	};
	Runnable runnbale = () -> System.out.println("run me!");

	int i = 0;

	public void listAdd() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("5");
		list.add("2");
		list.add("4");
		list.add("3");
		System.out.println("list to list :" + list);
		List<Double> hihi = new ArrayList<Double>();
		hihi.add(1.0);
		hihi.add(2.0);
		hihi.add(3.0);
		hihi.add(4.0);
		hihi.add(5.0);
		list.forEach(s -> {
			System.out.println("每次都會做這件事情" + i++);
			System.out.println("第二次ㄏㄏ 爽");
		});

		List<Double> total = list.stream().map(a -> Double.valueOf(a)).collect(() -> new ArrayList<>(),
				(newList, resource) -> newList.add(resource), (totalList, newList) -> totalList.addAll(newList));
		System.out.println("total :" + total);

		System.out.println("filter :" + list.stream().filter(s -> Integer.valueOf(s) < 3)
				.mapToInt(s -> Integer.valueOf(s)).average().getAsDouble());
		OptionalDouble op = list.stream().filter(s -> Integer.valueOf(s) > 0).mapToInt(s -> ci.changeNum(s)).average();
		List op2 = (List) list.stream().filter(s -> Integer.valueOf(s) > 0).sorted().collect(Collectors.toList());
		System.out.println("op :" + op);
		System.out.println("op2 :" + op2);
		System.out.println("op.getAsDouble() :" + op.getAsDouble());
		System.out.println("op.isPresent()" + op.isPresent());
		System.out.println("op.isPresent()" + op.orElse(0.0));
		System.out.println("===============");
		op.ifPresent(s -> {
			System.out.print("我有東西 s :" + s);
			System.out.println();
		});

		ArrayList hihis = hihi.stream().filter(s -> s > 0).mapToDouble(s -> s + 1.0).collect(() -> new ArrayList<>(),
				(newList, resource) -> newList.add(resource), (totalList, newList) -> totalList.addAll(newList));

		System.out.println("hihis :" + hihis);
	}

	public static void main(String[] args) {

		Test t = new Test();
		// t.listAdd();

		List<Person> people = Arrays.asList(new Person("David", "Taiwan", 26), new Person("David2", "naito", 27),
				new Person("Paul", "bato", 28), new Person("Mary", "taipei", 29), new Person("Sunny", "taoyaun", 20),
				new Person("Peter", "Taiwan6", 21));
		System.out.println("people :" + people);
		// lamda實作方法局限於MAS
		Collections.sort(people, (p1, p2) -> p1.getAddress().compareTo(p2.getAddress()));
		System.out.println("people :" + people);

		// 使用介面Predicate介面方法test去測試差異
		System.out.println("false :");
		printCondition(people, p1 -> false);
		System.out.println("=================");
		System.out.println("true :");
		printCondition(people, p1 -> true);
		// 測試傳入不同condition
		System.out.println("傳入不同條件測試 P: ");
		printCondition(people, p1 -> p1.getName().startsWith("P"));
		System.out.println("傳入不同條件測試 D: ");
		printCondition(people, p1 -> p1.getName().startsWith("D"));

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

	public static void printCondition(List<Person> list, Predicate<Person> predicate) {
		list.forEach(result -> {
			if (predicate.test(result))
				System.out.println(" p:" + result);
		});
	}

	public static void performCondition(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
		list.forEach(p -> {
			if (predicate.test(p))
				consumer.accept(p);
		});
	}

	interface oneFunction {
		void onefunction();
	}
}
