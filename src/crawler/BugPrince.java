package crawler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BugPrince implements Runnable {
	int i=1;

	public void download() throws IOException {

		BugMissionsFactory factory = new BugMissionsFactory();
		System.setProperty("webdriver.chrome.driver", "D:/BugJava/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		while (factory.currentUrlsQuantity() != 0) {
			String currentUrl = factory.popUrlList();
			driver.get(currentUrl);
			WebElement element = driver.findElement(By.cssSelector(".detail-data"));
			String detail = element.getText();
			FileWriter fw = new FileWriter(
					"D:/IOtest/Yuching" + currentUrl.substring(currentUrl.lastIndexOf("/") + 1) + ".txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(detail);
			bw.flush();
			bw.close();
			fw.close();
			System.out.println(Thread.currentThread().getName() + "處理完第" + i++ + "筆資料");
		}
		driver.quit();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			download();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
