package LeetCodeExercise;

import java.util.HashMap;
import java.util.Map;

class RomantoInteger {
	public static int romanToInt(String s) {

		if (s == null || s.length() == 0)
			return 0;

		Map<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);
		// "M CM XC VI"
		//  0 12 34 56
		int length = s.length();// 7 index =7-1 =6
		int result = m.get(s.charAt(length - 1));
		for (int i = length - 2; i >= 0; i--) {
			if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i)))
				result += m.get(s.charAt(i));
			else
				result -= m.get(s.charAt(i));

			System.out.println("²Ä" + i + "ªºresult :" + result);

		}
		return result;

	}
}
