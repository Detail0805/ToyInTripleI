package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenDataTest {
	private static final String MY_URL = "http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=b087af42-2c54-4dbf-86c8-427d788779e5";
	
	
	public static void main(String[] args) throws IOException {
		URL url = new URL(MY_URL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setConnectTimeout(10000);
		con.setDoInput(true);
		con.setRequestMethod("GET");
		
		InputStream is = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		StringBuilder sb = new StringBuilder();
		String str;
		while((str = br.readLine()) != null) {
			sb.append(str);
		}
		
		System.out.println(sb.toString());
		
		br.close();
		isr.close();
		is.close();
		
	}

}
