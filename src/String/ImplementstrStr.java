package String;

public class ImplementstrStr {
	public static void main(String[] args) {
		System.out.println(ImplementstrStr.strStrSubstring("a", "a"));

		// String hello = "hello";
		// System.out.println(hello.indexOf("ll", 0));

	}

	// indexOf解法6ms
	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		int h = -1;
		if (!(haystack.indexOf(needle, 0) == -1)) {
			return haystack.indexOf(needle, 0);
		}
		return h;
	}

	// subString解法 7ms
	public static int strStrSubstring(String haystack, String needle) {

		if (needle.length() == 0)
			return 0;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle))
				return i;
		}

		return -1;
	}
}
