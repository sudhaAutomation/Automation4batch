package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Admin {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.out.println("2.Smoke Testing in before Test");
	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://integratedtoolingsystems.in/1swishzz_staging/admin");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@Test
	public void loginTestCase() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"))
				.sendKeys("admin@admin.com");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]"))
				.sendKeys("123456");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]"))
				.sendKeys(Keys.ENTER);
		String exptitile = "DASHBOARD1";
		String Acttitle = driver.findElement(By.xpath("//header/div[1]/h3[1]")).getText();
		if (Acttitle.equalsIgnoreCase(exptitile)) {
			//System.out.println("System logged in to the dashboard page succesfully");
			Assert.assertTrue(true, "System logged in to the dashboard page succesfully");

		} else {
			Assert.assertTrue(false, "System logged in to the dashboard page failed");

		}

	}

	@AfterMethod
	public void tearDown() {
		//driver.findElement(
			//	By.xpath("/html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/aside[1]/nav[1]/ul[1]/li[13]/a[1]")).click();
		driver.close();

	}

}
