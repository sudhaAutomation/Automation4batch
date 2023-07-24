package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MyTest {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("1.ADmin portal suite before suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("2.Smoke Testing in before Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("3.My Test Class via Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("4.SetUp method for my test case via Before method");
	}

	@Test
	public void mytest1() {
		System.out.println("5.My Test case via Test");
	}

	@Test
	public void secondtc2() {
		System.out.println("secondtc2 via Test");
	}

	@Test
	public void abcdtc3() {
		System.out.println("abcdtc3 via Test");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("6.tear down method via after method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("7.Post Condition of a class via After class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("8.post condition of Test via After Test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("9.post condition of suite via After suite");
	}

}
