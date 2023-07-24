package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CoursesList {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://integratedtoolingsystems.in/1swishzz_staging/admin");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"))
				.sendKeys("admin@admin.com");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]"))
				.sendKeys("123456");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]"))
				.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//body/div[1]/section[1]/div[1]/div[1]/aside[1]/nav[1]/ul[1]/li[3]/a[1]")).click();

	}

	@Test(groups = "Courses List")
	public void courses() {
		String Expttitle = "COURSES";
		String acttitle = driver.findElement(By.xpath("//h3[contains(text(),'Courses List')]")).getText();
		System.out.println(acttitle);
		if (acttitle.contains(Expttitle)) {
			System.out.println("System naviagted to the courses page");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "System not naviagted to the courses page");

		}

	}

	@Test(priority = 1, groups = "Add course",invocationCount=1)
	public void addcourse() {
		boolean addbuton = driver.findElement(By.linkText("ADD COURSE")).isDisplayed();
		driver.findElement(By.xpath("")).click();
		if (addbuton) {
			System.out.println("Add course button displayed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Add course button not displayed");
		}

	}

	@Test(priority = 2, groups = "Add course",dependsOnMethods="addcourse")
	public void addcoursepage() {
		driver.findElement(By.linkText("ADD COURSE")).click();
		
		String exptitle = "ADD COURSE";
		String addtitle = driver.findElement(By.xpath("//h3[contains(text(),'Add Course')]")).getText();
		if (addtitle.equals(exptitle)) {
			System.out.println("System naviagetd to Add course page successfully");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "System not naviagetd to Add course page successfully");
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
