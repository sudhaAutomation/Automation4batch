package selenium_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.edge.driver",
		// "C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\msedgedriver.exe");
		// WebDriver driver1 = new EdgeDriver();

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://integratedtoolingsystems.in/1swishzz_staging/admin");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// dynamic wait
		// driver.findElement(By.linkText("Gmail")).click();
		// driver.findElement(By.partialLinkText("Gma")).click();
		// driver.findElement(By.id("input")).sendKeys("gmail");
		/// html/body/ntp-app//div/div[1]/ntp-realbox//div/input
		// driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@admin.com");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		// Thread.sleep(2000);// static wait
		driver.findElement(By.xpath("//input[@name='submit']")).sendKeys(Keys.ENTER);
		driver.findElement(By.partialLinkText("Courses")).click();// system should present in courses list page
		// driver.findElement(By.partialLinkText("ADD C")).click();// system should
		// present in add course page
		// new
		// Select(driver.findElement(By.name("category_id"))).selectByVisibleText("Software
		// Testing");
		// Select se = new Select(driver.findElement(By.xpath("")));
		// se.selectByVisibleText("");
		//
		/// html/body/div/section/div/div/section/div/div/div[2]/table/tbody/tr[1]/td[2]/a[1]/i
		// html/body/div/section/div/div/section/div/div/div[2]/table/tbody/tr[1]/td[2]/a[1]
		driver.findElement(
				By.xpath("/html/body/div/section/div/div/section/div/div/div/table/tbody/tr[1]/td[2]/a[1]/i")).click();
		Alert alrt = driver.switchTo().alert();
		String title = alrt.getText();
		System.out.println(title);
		// alrt.sendKeys("");
		alrt.accept();
		// alrt.dismiss();
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.close();

	}

}
