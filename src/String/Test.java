package String;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


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
		op.ifPresent(s -> System.out.print("我有東西s"));
	}

	public static void main(String[] args) {

		Test t = new Test();
		t.listAdd();

	}

}
