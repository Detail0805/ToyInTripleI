package LeetCodeExercise;

public class RemoveElement {

	
	static int removeElement(int[] nums, int val) {
		
		int index=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=val){
				nums[index++]=nums[i];
			}
			
		}
		
		return nums.length;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
