package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class GroupAnagrams {

	public static void main(String[] args) {

		String[] hi = { "abc", "bac", "cba", "cab" };
		GroupAnagrams.groupAnagrams(hi);
	}

	// { "abc", "bac", "cba", "cab" };
	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> res = new ArrayList<>();
		if (strs.length == 0 || strs.equals(null))
			return res;
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = new String(ch);
			if (map.containsKey(s)) {
				List<String> list = res.get(map.get(s));
				list.add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, res.size());
				res.add(list);
			}
		}
		return res;

	}
}
