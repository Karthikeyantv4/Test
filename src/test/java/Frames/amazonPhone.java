package Frames;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonPhone {
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
		System.out.println("Launching Amazon");
	}
	@Test
	public void Test1(){

	WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	search.sendKeys("Iphone");
	boolean displayed = search.isDisplayed();
	Assert.assertTrue(displayed);
	WebElement searchClick = driver.findElement(By.xpath("//input[contains(@value,'Go')]"));
	searchClick.click();
	}
	@Test
	public void Test2(){
	WebElement textValue = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
	String value1 = textValue.getText();
	textValue.click();
	System.out.println(value1);
	}
	@Test 
	public void Test3(){
	WebElement secondVal = driver.findElement(By.xpath("//span[contains(@class,'a-size-large product-title-word-break')]"));
	String value2 = secondVal.getText();
	System.out.println(value2);
	}
	@Test
	public void Test4(){
	WebElement addtoCart = driver.findElement(By.xpath("//*[@id=\"exportsUndeliverable-cart-announce\"]"));
	addtoCart.click();
	System.out.println("Item Added to Cart"); 
	
	@Test
	public void Test5(){
		List<WebElement> textValues = driver.findElements(By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-normal')]"));
		
				System.out.println(textValues.size());
				File f = new File("C:\\Users\\91822\\Desktop\\MobilePhones.xlsx");
				Workbook w = new XSSFWorkbook();
				Sheet sheet = w.createSheet("Sheet1");
				for(int i=0;i<textValues.size();i++)
				{
					WebElement headLines = textValues.get(i);
					String val = headLines.getText();
					Row row = sheet.createRow(i);
					Cell cell = row.createCell(i);
					cell.setCellValue(val);
		
				}
				FileOutputStream f1 = new FileOutputStream(f);
				w.write(f1);
				f1.close();	
	}
}


