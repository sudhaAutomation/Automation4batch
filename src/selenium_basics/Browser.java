package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Browser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver.manage().window().maximize();
		// http://integratedtoolingsystems.in/1swishzz_staging/admin
		driver.get("http://integratedtoolingsystems.in/1swishzz_staging/admin");// login module should display
		Thread.sleep(2000);
		driver.findElement(By.className("form-control")).sendKeys("admin@admin.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		String exptitle = "welcome";
		String acttitle = driver.findElement(By.className("title")).getText();
		System.out.println(acttitle);

		if (acttitle.equalsIgnoreCase(exptitle)) {
			System.out.println("System logged in successfully");
		} else {
			System.out.println("system not logged in");
		}

		
		// locators
		/*
		 * 8 id name cssselector xpath linkText partialLinktext tagname Classname
		 */
	}

}
