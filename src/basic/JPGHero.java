package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JPGHero implements Runnable {
	String website = "https://ck101.com/thread-3879839-1-1.html";
	String resultString;
	HashSet<String> websitesDatabase;
	public static Vector<String> missions = new Vector<>();
	
	public JPGHero() {
		//拿卡提諾開刀
		this.website = "https://ck101.com/thread-3879839-1-1.html";
		System.out.println("親愛的上帝你沒給我資料我就要自己來了");
	}

	public JPGHero(String website) {
		this.website = website;
	}

	public void getJPG() throws MalformedURLException, IOException {

		File dir = new File("D:/IOtest");
		InputStream jizzstream;
		String finaljizz;
		int i = 1;
		int bbb;
		while (missions.size() > 0) {
			finaljizz = missions.get(0);
			missions.remove(0);
			
			jizzstream = new URL(finaljizz).openConnection().getInputStream();
			byte[] bb = new byte[4096];
			//拿檔案名字
			String name = finaljizz.substring(finaljizz.lastIndexOf("/") + 1);
			//建路徑
			File jpgPath = new File(dir, name);			
			FileOutputStream fos = new FileOutputStream(jpgPath);
			System.out.println(i + "號圖片" + name + "的" + "網址為" + finaljizz);
			while ((bbb = jizzstream.read(bb)) != -1) {
				fos.write(bb, 0, bbb);
			}
			i++;
			System.out.println(Thread.currentThread().getName() + "載完了第" + i + "張圖片!");
			fos.flush();
			fos.close();
		}
		System.out.println("刻苦的勞工朋友" + Thread.currentThread().getName() + "載完了" + i + "張圖片後已經下班");
	}

	public void makeDatabase() {
		websitesDatabase = new HashSet<>();
		String tempStr;
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(website);
			// HttpURLConnection才能設定安全性Method="get",還有User-Agent
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, likeGecko) Chrome/60.0.3112.101 Safari/537.36");

			// 讀取網頁程式碼&列印
			InputStream fis = url.openConnection().getInputStream();
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			while ((tempStr = br.readLine()) != null) {
				result.append(tempStr + "\r\n");
			}
			resultString = result.toString();
			System.out.println(resultString);
			// 尋找符合的條件的圖片網址by正規化，並增進資料庫
			Pattern p = Pattern.compile("http[s]?:[a-zA-Z0-9\\./_=?]*.(jpg|gif|png)");
			Matcher m = p.matcher(resultString);
			// hashset
			while (m.find()) {
				websitesDatabase.add(resultString.substring(m.start(), m.end()));
			}
			System.out.println(websitesDatabase.size());
			// vector
			for (String littlejizz : websitesDatabase) {
				missions.add(littlejizz);
			}
			System.out.println("7777777777777777777偉大的資料庫已經建立完成7777777777777777");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			getJPG();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
