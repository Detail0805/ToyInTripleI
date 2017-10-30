package LeetCodeExercise;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		
		 if (strs == null || strs.length == 0) {
	            return "";
	        }
		 
	        String prefix = strs[0];
	        System.out.println("prefix = strs[0] :"+prefix);
	        System.out.println("strs.length :"+strs.length);
	        for(int i = 1; i < strs.length; i++) {
	     //"abcdefg", "abcdefghijk", "abcdfghijk", "abcef"
	     //   0              1            2           3	
	            int j = 0;
	            while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
	            	//        1                         0
	                j++;
	            }
	            if( j == 0) {
	                return "";
		    }
	            prefix = prefix.substring(0, j);
	        }
	        
	        return prefix;
	    }

	}