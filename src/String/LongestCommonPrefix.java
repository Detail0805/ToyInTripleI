package String;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		// System.out.println(ImplementstrStr.strStrSubstring("a", "a"));

		// String hello = "hello";
		// System.out.println(hello.indexOf("ll", 0));

		String[] prefix = { "abcdefg", "abcdefghijk", "abcdfghijk", "abcef" };
		System.out.println(LongestCommonPrefix.longestCommonPrefix2(prefix));
	}

	// 從前面去判斷累加16ms
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		System.out.println("prefix = strs[0] :" + prefix);
		System.out.println("strs.length :" + strs.length);
		for (int i = 1; i < strs.length; i++) {
			// "abcdefg", "abcdefghijk", "abcdfghijk", "abcef"
			// 0 1 2 3
			int j = 0;
			while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
				// 1 0s
				j++;
			}
			if (j == 0) {
				return "";
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}

	// String[] prefix = { "abcdefg", "abcdefghijk", "abcdfghijk", "abcef" };
	// 從後面去判斷 10ms
	public static String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];

		for (int i = 1; i < strs.length; i++) {

			while (strs[i].indexOf(prefix) != 0) {
				System.out.println("  prefixsubstrin前  :" + prefix);
				prefix = prefix.substring(0, prefix.length() - 1);
				System.out.println("  prefix  :" + prefix);
			}
		}
		return prefix;

	}
}