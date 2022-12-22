package Frames;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static WebDriver k;
	public static WebDriver driver;
	@BeforeClass
	public static void browser(){
		WebDriverManager.chromedriver().setup();
		k=new ChromeDriver();
	}
	@AfterClass
	public static void quitBrowser(){
		k.quit();
		System.out.println("Browser Closed");
	}
	@Test
	public void launchBrowser(){
		k.get("https://www.amazon.in/");
		System.out.println("Launching Flipkart");
	}
	@Test
	public void test1(){
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	driver.manage().window().maximize();
	WebElement search = driver.findElement(By.xpath(""));
	search.sendKeys("Mobiles", Keys.ENTER);
	System.out.println("Adidas");
	}
	@Ignore
	@Test
	public void Karthik(){
		System.out.println("Karthik");
	}
	@Before
	public void cTime(){
		long cur = System.currentTimeMillis();
		System.out.println("Before CTM"+cur);
	}
	@After
	public void cTimes(){
		long ctm = System.currentTimeMillis();
		System.out.println("After CTM"+ctm);
	}

	
	
}
