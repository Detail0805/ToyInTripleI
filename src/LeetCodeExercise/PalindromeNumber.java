package LeetCodeExercise;

public class PalindromeNumber {
//404 353 393
	
	public static boolean PalindromeNumber(int target) {

		if(target<0) {
		return false;
		}
		
		System.out.println(target);
		String target2= new Integer(target).toString();
		int left=0;
		int right=target2.length()-1;
		
		System.out.println("right :"+right);
		
		while(left<right) {
			System.out.println("target2.charAt(left) :"+target2.charAt(left));
			if(target2.charAt(left)!=target2.charAt(right))return false;
			else{left++;right--;};
		}
		return true;
	}
	
}
