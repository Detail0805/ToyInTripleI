package crawler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BugMissionsFactory implements Runnable {
/**
 * �ݭn�ϥΥ~�ӮM��i�H����¶�LSSH����
 * 
 * ***/
	private static Vector<String> urlList = new Vector<>(6000);
	static int CurrentMissionPageNumber = 1;
	static int totalPages;
	String yuching = "https://buy.yungching.com.tw/region";
	static {
		// �˭�DRIVER������
		System.setProperty("webdriver.chrome.driver", "D:/BugJava/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String yuching = "https://buy.yungching.com.tw/region";
		driver.get(yuching);
		// �z�L�̫�@�����s�A����`����
		WebElement lastPage = driver.findElementByPartialLinkText("�̥���");
		String finalPage = lastPage.getAttribute("href");
		String currentPage = finalPage.substring(finalPage.lastIndexOf("=") + 1);
		totalPages = Integer.valueOf(currentPage);
		System.out.println("�����@��" + totalPages + "��");
		driver.quit();
	}

	public int currentUrlsQuantity() {
		return urlList.size();
	}

	public synchronized String popUrlList() {
		String tempString = urlList.get(0);
		urlList.remove(0);
		return tempString;
	}

	public synchronized void AddurlList(String url) {
		urlList.add(url);
	};

	public void getYuchingHouseData(int pageNumber) throws IOException {

		// �˭Ӥ����
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_kk");
		String currentTime = sf.format(new Date());
		// �˭�WRITER��
		FileWriter fw = new FileWriter("D:/IOtest/Yuching" + currentTime + ".txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		// �˭�DRIVER��
		System.setProperty("webdriver.chrome.driver", "D:/BugJava/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// �s�W����
		String currentUrl = yuching + "?pg=" + pageNumber;
		driver.get(currentUrl);
		// �h�����䪫����},�̧Ǧs�JurlList
		List<WebElement> webElements = driver.findElements(By.cssSelector(".l-item-list > .m-list-item > a"));
		for (int j = 0; j < webElements.size(); j++) {
			String url = webElements.get(j).getAttribute("href");
			urlList.add(url);
			bw.write(url);
			bw.newLine();
		}
		System.out.println("��" + pageNumber + "���U������");
		bw.flush();
		bw.close();
		fw.close();
		driver.quit();
	}

	@Override
	public void run() {
		try {
			int pageNumber = 0;
			while (CurrentMissionPageNumber <= totalPages) {
				synchronized (this) {
					if (CurrentMissionPageNumber <= totalPages) {
						pageNumber = CurrentMissionPageNumber++;
					}
				}
				if (pageNumber != 0) {
					System.out.println(Thread.currentThread().getName() + "���b�B�z��" + pageNumber + "��");
					getYuchingHouseData(pageNumber);
				} else {
					System.out.println("�����w�gŪ������" + Thread.currentThread().getName() + "�w�g�U�Z");
				}
			}
			System.out.println(Thread.currentThread().getName() + "�w�g�U�Z");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};
}
