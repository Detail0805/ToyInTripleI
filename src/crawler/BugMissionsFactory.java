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
 * 需要使用外來套件可以直接繞過SSH驗證
 * 
 * ***/
	private static Vector<String> urlList = new Vector<>(6000);
	static int CurrentMissionPageNumber = 1;
	static int totalPages;
	String yuching = "https://buy.yungching.com.tw/region";
	static {
		// 弄個DRIVER拿頁數
		System.setProperty("webdriver.chrome.driver", "D:/BugJava/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String yuching = "https://buy.yungching.com.tw/region";
		driver.get(yuching);
		// 透過最後一頁按鈕，獲取總頁數
		WebElement lastPage = driver.findElementByPartialLinkText("最末頁");
		String finalPage = lastPage.getAttribute("href");
		String currentPage = finalPage.substring(finalPage.lastIndexOf("=") + 1);
		totalPages = Integer.valueOf(currentPage);
		System.out.println("本次共有" + totalPages + "頁");
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

		// 弄個日期阿
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_kk");
		String currentTime = sf.format(new Date());
		// 弄個WRITER阿
		FileWriter fw = new FileWriter("D:/IOtest/Yuching" + currentTime + ".txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		// 弄個DRIVER阿
		System.setProperty("webdriver.chrome.driver", "D:/BugJava/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// 連上網頁
		String currentUrl = yuching + "?pg=" + pageNumber;
		driver.get(currentUrl);
		// 去網頁找物件網址,依序存入urlList
		List<WebElement> webElements = driver.findElements(By.cssSelector(".l-item-list > .m-list-item > a"));
		for (int j = 0; j < webElements.size(); j++) {
			String url = webElements.get(j).getAttribute("href");
			urlList.add(url);
			bw.write(url);
			bw.newLine();
		}
		System.out.println("第" + pageNumber + "頁下載完成");
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
					System.out.println(Thread.currentThread().getName() + "正在處理第" + pageNumber + "頁");
					getYuchingHouseData(pageNumber);
				} else {
					System.out.println("網頁已經讀取完成" + Thread.currentThread().getName() + "已經下班");
				}
			}
			System.out.println(Thread.currentThread().getName() + "已經下班");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};
}
