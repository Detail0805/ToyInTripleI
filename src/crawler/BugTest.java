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

		// �ۤv��
		// BugPrince worker = new BugPrince();
		// worker.download();

		// �j�a��
		BugMissionsFactory getCommoditiesUrl = new BugMissionsFactory();
		Thread thread1 = new Thread(getCommoditiesUrl, "�@��");
		Thread thread2 = new Thread(getCommoditiesUrl, "�G��");
		Thread thread3 = new Thread(getCommoditiesUrl, "�T��");
		Thread thread4 = new Thread(getCommoditiesUrl, "�|��");
		Thread thread5 = new Thread(getCommoditiesUrl, "����");
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
		System.out.println("��Ʈw�@��" + getCommoditiesUrl.currentUrlsQuantity() + "�����");
		BugPrince downloadInfo = new BugPrince();
		thread1 = new Thread(downloadInfo, "�@��");
		thread2 = new Thread(downloadInfo, "�G��");
		thread3 = new Thread(downloadInfo, "�T��");
		thread4 = new Thread(downloadInfo, "�|��");
		thread5 = new Thread(downloadInfo, "����");
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
