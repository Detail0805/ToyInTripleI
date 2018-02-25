package String;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class invoke {
	public int add(int param1, int param2) {
		return param1 + param2;
	}

	public String echo(String meassage) {
		return "hello: " + meassage;
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		
		Class<?> classType= invoke.class;
		Object invokes=classType.newInstance();
		Method addMethod=classType.getMethod("add",  int.class,int.class);
		
		Object result=addMethod.invoke(invokes,1,2);
		System.out.println((Integer)result);
		System.out.println("--------------------");
		
		Method echoMethod =classType.getMethod("echo", new Class[] {String.class});
		Object message=echoMethod.invoke(invokes, "hello");
		
		System.out.println(message);
		
		
		
	}

}
