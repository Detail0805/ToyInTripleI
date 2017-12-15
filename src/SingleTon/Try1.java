package SingleTon;

public class Try1 {
	public static void main(String args[]) {
		CB obj = new CB();
		obj.show();
		System.out.println("obj.var1 ::"+obj.var1);
		CA ca=new CA();
		System.out.println("CA.var1::"+ca.var1);
	}
}
class CA {
	public int var1;

	public CA() {
		System.out.println("父類別建構子建構中");
		var1 = 10;
	}
}
class CB extends CA // 子類別CB繼承自類別CA
{
	public long var1;
	public CB() {
		System.out.println("子類別建構子建構中");
		var1 = 20;
//		super.var1 = 30;
	}
	public void show() {
		System.out.println("show() var1=" + var1);
		System.out.println("show() super.var1=" + super.var1);
		System.out.println("show() new CA().var1=" + new CA().var1);
	}
}