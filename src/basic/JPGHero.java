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
		//���d���ն}�M
		this.website = "https://ck101.com/thread-3879839-1-1.html";
		System.out.println("�˷R���W�ҧA�S���ڸ�ƧڴN�n�ۤv�ӤF");
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
			//���ɮצW�r
			String name = finaljizz.substring(finaljizz.lastIndexOf("/") + 1);
			//�ظ��|
			File jpgPath = new File(dir, name);			
			FileOutputStream fos = new FileOutputStream(jpgPath);
			System.out.println(i + "���Ϥ�" + name + "��" + "���}��" + finaljizz);
			while ((bbb = jizzstream.read(bb)) != -1) {
				fos.write(bb, 0, bbb);
			}
			i++;
			System.out.println(Thread.currentThread().getName() + "�����F��" + i + "�i�Ϥ�!");
			fos.flush();
			fos.close();
		}
		System.out.println("��W���Ҥu�B��" + Thread.currentThread().getName() + "�����F" + i + "�i�Ϥ���w�g�U�Z");
	}

	public void makeDatabase() {
		websitesDatabase = new HashSet<>();
		String tempStr;
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(website);
			// HttpURLConnection�~��]�w�w����Method="get",�٦�User-Agent
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, likeGecko) Chrome/60.0.3112.101 Safari/537.36");

			// Ū�������{���X&�C�L
			InputStream fis = url.openConnection().getInputStream();
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			while ((tempStr = br.readLine()) != null) {
				result.append(tempStr + "\r\n");
			}
			resultString = result.toString();
			System.out.println(resultString);
			// �M��ŦX�����󪺹Ϥ����}by���W�ơA�üW�i��Ʈw
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
			System.out.println("7777777777777777777���j����Ʈw�w�g�إߧ���7777777777777777");
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
