package crawler;
import java.io.File;
import java.io.IOException;

public class BugTest {

	// TODO Auto-generated method stub
	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File("D:/IOtest");
		if (!file.exists()) {
			file.mkdirs();
		}
		System.out.println(BugMissionsFactory.totalPages);

		// 自己玩
		// BugPrince worker = new BugPrince();
		// worker.download();

		// 大家玩
		BugMissionsFactory getCommoditiesUrl = new BugMissionsFactory();
		Thread thread1 = new Thread(getCommoditiesUrl, "一號");
		Thread thread2 = new Thread(getCommoditiesUrl, "二號");
		Thread thread3 = new Thread(getCommoditiesUrl, "三號");
		Thread thread4 = new Thread(getCommoditiesUrl, "四號");
		Thread thread5 = new Thread(getCommoditiesUrl, "五號");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();
		System.out.println("資料庫共有" + getCommoditiesUrl.currentUrlsQuantity() + "筆資料");
		BugPrince downloadInfo = new BugPrince();
		thread1 = new Thread(downloadInfo, "一號");
		thread2 = new Thread(downloadInfo, "二號");
		thread3 = new Thread(downloadInfo, "三號");
		thread4 = new Thread(downloadInfo, "四號");
		thread5 = new Thread(downloadInfo, "五號");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();

		// String source = driver.getPageSource();
		// System.out.println(source);

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(lambda dr: dr.find_element_by_name('q').is_displayed())

		// dr.quit()
	}

}
