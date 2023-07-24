package selenium_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.epfindia.gov.in/site_en/index.php#");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// dynamic wait
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.partialLinkText("Exempted Es"))).build().perform();
		//act.contextClick(driver.findElement(By.partialLinkText("EPFO Corn"))).build().perform();
		act.moveToElement(driver.findElement(By.partialLinkText("EPFO Corn"))).contextClick().build().perform();
		
		
		

	}

}
