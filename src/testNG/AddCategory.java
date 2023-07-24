package testNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class AddCategory {
	WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser", "url", "username", "password" })
	public void setUp(String browser, String url, String username, String password) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		else if (browser.equals("gecko")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\SWHIZZ TECHNOLOGIES\\Downloads\\jars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"))
				.sendKeys(username);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]"))
				.sendKeys(password);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]"))
				.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//body/div[1]/section[1]/div[1]/div[1]/aside[1]/nav[1]/ul[1]/li[3]/a[1]")).click();

	}

	@DataProvider
	public Object[][] celldata() throws IOException {
		return getcelldata();
	}

	@Test(dataProvider = "celldata")
	//
	public void addcategory(String categoryname, String sortoder, String metatitle, String metadescri, String metakey,
			String Results) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Categories List')]")).click();
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/a[1]")).click();
		// Thread.sleep(2000);
		driver.findElement(By.name("category_name")).sendKeys(categoryname);// category name
		// Thread.sleep(2000);
		driver.findElement(By.name("sort_order")).sendKeys(sortoder);// sort_order
		// Thread.sleep(2000);
		driver.findElement(By.name("category_meta_title")).sendKeys(metatitle);// category_meta_title
		// Thread.sleep(2000);
		driver.findElement(By.name("category_meta_desc")).sendKeys(metadescri);// category_meta_desc
		// Thread.sleep(2000);
		driver.findElement(By.name("category_meta_keywords")).sendKeys(metakey);// category_meta_keywords
		// Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();// save

		String exptitle = "Admin";
		String acttitle = driver.getTitle();
		System.out.println(acttitle);

		if (Results.equals("pass")) {
			System.out.println("Courses created successfully");
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false, "Courses not created");
		}

	}

	public String[][] getcelldata() throws IOException {
		XLUtility xl = new XLUtility(
				"C:\\Users\\SWHIZZ TECHNOLOGIES\\eclipse-workspace1\\Selenium_12\\TestdataExcelFiles\\Swhizzportltestcases1.xlsx");
		int rowcount = xl.getRowCount("TESTDATA");
		int colcount = xl.getCellCount("TESTDATA", 2);
		System.out.println(rowcount);
		System.out.println(colcount);
		String tdata[][] = new String[rowcount - 1][colcount];
		for (int i = 2; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				tdata[i - 2][j] = xl.getCellData("TESTDATA", i, j);

			}

		}
		return tdata;
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
