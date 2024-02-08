package com;

import org.testng.annotations.Test;

import static org.junit.Assert.assertNotNull;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class NewTest {
	WebDriver wd=null;
	@BeforeTest
	public void init() {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.flipkart.com/");
	}
	@Test(priority = 1)
	public void searchthePagewithelement() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)wd;
		wd.manage().timeouts().pageLoadTimeout(5000,TimeUnit.MILLISECONDS);
		wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		Thread.sleep(2000);
		wd.findElement(By.name("q")).sendKeys("iPhone 13");
		wd.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		wd.findElement(By.name("q")).submit();
		wd.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		WebElement we=wd.findElement(By.linkText("YouTube"));
		js.executeScript("arguments[0].scrollIntoView()"+we);
		assertNotNull(we);
		System.out.println("got the element"+we);
	}
}

