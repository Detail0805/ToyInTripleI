package LeetCodeExercise;

class ReversString{
		static int res(int x) {
		System.out.println("¿é¤J¤å¦r :"+x);
		String inputstring=Integer.toString(x);
		String s=new StringBuilder(inputstring).reverse().toString();
		
		int answer = Integer.parseInt(s);
		System.out.println(s);
		return answer;
}
		static int reverse(int i) {
			int answer=0;
			
			
			while(i !=0) {
				if(answer>214748364|| answer<214748364||
						(answer==214748364&&i%10>7)||
						(answer==-214748364&&i%10<-8)
						)
				
					answer= answer *10 + i%10;
				i/=10;
			}
			return answer;
		}
}
