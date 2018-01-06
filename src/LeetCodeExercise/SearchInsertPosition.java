package LeetCodeExercise;

public class SearchInsertPosition {

	public static void main(int[] nums, int target) {
		int[] sss = { 1, 3, 5, 6 };
		SearchInsertPosition.fofo(sss, 5);
	}

	public static int fofo(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] >= target) {

				return i;
			}
		}

		return nums.length;
	}
}
