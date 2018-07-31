package LeetCodeExercise;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

	/**
	 * 
	 * 
	 * @param nums
	 * @param k
	 * 
	 * array [1,2,3,4,5,6,7] n=7;
	 * k=3
	 * ->>   [5,6,7,1,2,3,4] 
	 * 
	 * 
	 */
	//time : O(n) space : O(n)
	public static void rotate(int[] nums ,int k){
		
		int[] temp = new int[nums.length];
		for (int i=0;i<nums.length;i++){
			temp[i+k%nums.length]=nums[i];
		}
		for(int i=0;i<nums.length;i++){
			nums[i]=temp[i];
		}
		
	}
	
	//time : O(n) space :O(1)
	public static void rotate2(int[] nums ,int k){
		k %=nums.length;  //¨ú
		revers(nums,0,nums.length-1);
		revers(nums,0,k-1);
		revers(nums,k,nums.length-1);
		
		
	}
	//simple rotate [1,2,3,4,5,6]
	//				[]
	public static void revers(int[] nums,int start,int end){
		while(end >start){
			int temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}
	
	
	
}
