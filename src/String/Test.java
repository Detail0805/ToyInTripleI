package String;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Test {
	// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
	int a = 0;
	String count = "0";

	ChangeInteger ci = x -> {
		count = count + x;
		return 1;
	};
	Runnable runnbale = () -> System.out.println("run me!");

	public void listAdd() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		System.out.println("list to list :" + list);
		System.out.println(list.stream().filter(s -> Integer.valueOf(s) < 3).mapToInt(s -> Integer.valueOf(s)).average()
				.getAsDouble());
		System.out.println(list.stream().filter(s -> Integer.valueOf(s) < 3).mapToInt(s -> ci.changeNum(s)).average());
		IntStream is = list.stream().filter(s -> Integer.valueOf(s) > 6).mapToInt(s -> Integer.valueOf(s).parseInt(s));
		System.out.println("is :" + is);
		System.out.println(list.stream().filter(s -> Integer.valueOf(s) > 3).collect(Collectors.toList()));

		list.stream().collect(Collectors.toList());
	}

	public static void main(String[] args) {

		Test t = new Test();
		t.listAdd();
		// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		// List<String> liststring = new ArrayList<String>();
		// Optional<Integer> hi = list.stream().findFirst();
		// System.out.println("Optione get方法 :" + hi.get());
		// Stream stream = Stream.of("a", "b", "c");

		// 流的基本構造
		// IntStream.of(new int[] { 1, 2, 3 }).forEach(System.out::print);
		// System.out.println();
		// IntStream.range(1, 3).forEach(System.out::print);
		// System.out.println();
		// IntStream.rangeClosed(1, 3).forEach(System.out::print);
		// // 1. Array
		// String[] strArray1 = (String[]) stream.toArray(String[]::new);
		// // 2. Collection
		// List<String> list1 = (List<String>) stream.collect(Collectors.toList());
		// List<String> list2 = (List<String>)
		// stream.collect(Collectors.toCollection(ArrayList::new));
		// Set set1 = (Set) stream.collect(Collectors.toSet());
		// Stack stack1 = (Stack) stream.collect(Collectors.toCollection(Stack::new));
		// // 3. String
		// String str = stream.collect(Collectors.joining()).toString();

	}

}
