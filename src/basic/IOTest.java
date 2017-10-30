package basic;

import java.io.*;

public class IOTest {

	public static void main(String[] args) throws IOException {
//		File myFile = new File("C:\\JavaTest\\Hello.txt");
//		File outAgain = new File("C:\\JavaTest\\HelloAgain.txt");
		
		long startTime = System.currentTimeMillis();
		
		File myFile = new File("C:\\Users\\Java\\Downloads\\jdk-8u131-docs-all.zip");
		
		FileInputStream fis = new FileInputStream(myFile);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int data;
		while ((data = bis.read()) != -1) {
			System.out.print((char)data);
		}
		
		bis.close();
		fis.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println();
		System.out.println("It spent: " + (endTime - startTime) / 1000 + " seconds.");
		
		
	}

}
