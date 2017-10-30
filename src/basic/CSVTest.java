package basic;

import java.io.*;

public class CSVTest {

	public static void main(String[] args) throws IOException {
//		FileReader fr = new FileReader("C:\\JavaTest\\Student.csv");
//		BufferedReader br = new BufferedReader(fr);
//		
//		String data;
//		while((data = br.readLine()) != null) {
//			System.out.println(data);
//		}
//	
//		br.close();
//		fr.close();
		
		FileInputStream fis = new FileInputStream("C:\\JavaTest\\Student.csv");
		InputStreamReader isr = new InputStreamReader(fis, "MS950");
		BufferedReader br = new BufferedReader(isr);
		
		String data;
		while((data = br.readLine()) != null) {
			System.out.println(data);
			String[] person = data.split(",");
			
		}
	
		br.close();
		isr.close();
		fis.close();
	}

}
