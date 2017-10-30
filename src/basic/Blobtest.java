package basic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Blobtest {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "JDBCSTUDENT";
	private static final String CODE = "JDBCSTUDENT";

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("上帝請輸入網址");		
		JPGHero hero = new JPGHero(sc.next());
		System.out.println("親愛的上帝,下賤的勞工們收到您的請求");
		long startTime = System.currentTimeMillis();
		File file = new File("D:/IOtest/bigneinei");
		if (!file.exists()) {
			file.mkdirs();
		}
		File realFile = new File(file, "neinei.txt");
		if (!realFile.exists()) {
			realFile.createNewFile();
		}
		hero.makeDatabase();
		Thread thread1 = new Thread(hero, "一號");
		Thread thread2 = new Thread(hero, "二號");
		Thread thread3 = new Thread(hero, "三號");
		thread1.start();
		thread2.start();
		thread3.start();
		thread1.join();
		thread2.join();
		thread3.join();
		long endTime = System.currentTimeMillis();
		System.out.println("親愛的上帝，下賤的勞工們浪費了" + (endTime - startTime) / 1000 + "秒載完您的資料");

	}
}