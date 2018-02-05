package LeetCodeExercise;

public class reversetheword {

	public static void main(String[] args) {

		String hello = "hello";
		char[] g = hello.toCharArray();
		System.out.println(reversetheword.revers(g, 0, g.length - 1));
	}

	public static char[] revers(char[] s, int i, int j) {
		System.out.println(s.length);
		while (i < j) {
			System.out.println("s[j] :" + s[j] + ",s[i] :" + s[i]);
			char temp = s[i];
			s[i++] = s[j];
			s[j--] = temp;
		}
		return s;
	}
}
