package LeetCodeExercise;

public class FirstMissingPositive {

	
	
	
	
	/**
	 * Input: [1,2,0] Output: 3
	 * Input: [3,4,-1,1] Output: 2
	 * O(n)
	 * leetcode41
	 * bucket sort : 對應的數就存進去
	 */
	
	public static int first(int[] nums){
		if (nums == null || nums.length == 0)
			return 1;
		for (int i = 0; i < nums.length; i++) {
			//i>0,裏頭數字需要小於數組長度,  [1,99,3,4]大於一定不是解
			while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
				//把對應的數字放入應該放入的index
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		//判斷目前的數組 [1,2,-1,4]
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		//如果是放[1,2,3,4]
		return nums.length + 1;
	}
	/**
	 * leetcode no1 solution
	 * 
	 */
	public static int no1(int[] nums){
		int missing = 1;
        int prev_missing = 0;
        while(prev_missing != missing) {
            prev_missing = missing;
            int i = 0;
            while(i < nums.length) {
                if(nums[i] == missing) {
                    missing++;
                }
                i++;
            }
        }
        return missing;
	}
	
}
