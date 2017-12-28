package LeetCodeExercise;

public class MaximumSubarray {

	public static void main(String[] args) {

		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(MaximumSubarray.maxSubArray(array));

	}
	/*
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has
	 * the largest sum = 6.
	 */

	public static int maxSubArray(int[] nums) {
		int big = nums[0];
		int sum;
		for (int start = 0; start < nums.length; ++start) {

			for (int end = 0; end < nums.length; ++end) {

				sum = 0;
				for (int i = start; i <= end; ++i) {

					sum += nums[i];
					if (sum > big) {
						big = sum;
					}
				}
			}

		}
		return big;
	}
}
