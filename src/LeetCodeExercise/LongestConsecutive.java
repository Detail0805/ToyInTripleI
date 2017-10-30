package LeetCodeExercise;
import java.util.HashSet;

// Longest Consecutive Sequence
// Time Complexity: O(n)�ASpace Complexity: O(n)
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        final HashSet<Integer> mySet = new HashSet<Integer>();
        for (int i : nums) mySet.add(i);

        int longest = 0;
        for (int i : nums) {
            int length = 1;
            for (int j = i - 1; mySet.contains(j); --j) {
                mySet.remove(j);
                ++length;
            }
            for (int j = i + 1; mySet.contains(j); ++j) {
                mySet.remove(j);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}