package String;

public class Finbo {

	public static void main(String[] args) {
		System.out.println(Finbo.qq(1));
		System.out.println(Finbo.qq(2));
		System.out.println(Finbo.qq(3));
		System.out.println(Finbo.qq(4));
		System.out.println(Finbo.qq(5));
		System.out.println(Finbo.qq(20));
	}
	
	public  static int qq(int i) {
		if(i==0) {
			return 0;
		}else if (i==2||i==1) {
			return 1;
		}
		return qq(i-1)+qq(i-2);
	}

}
