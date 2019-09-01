package main.NewUserStories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DataProvider {
	
	//method 1 to use data provider using method as object
	
	@org.testng.annotations.DataProvider(name="test1")
	private Object[][] myFirstMethod() {
		
		return new Object[][] {
				  new Object[] { "deepakkumarprof1", "Chaya@2019" },
				  new Object[] {"deepakkumarprof1", "fgdsfygfgrgfreu" }
				  };
	}
	
	/*public Iterator<Object[]> terator;
    public HashMap<String, String> myhashMap=new HashMap<String, String>();
	@org.testng.annotations.DataProvider(name="test1")
	public Iterator<Object[]> myFirstMethod(){
		myhashMap.put("983598","983598");
		myhashMap.put("983598", "983598");
		//terator = ( (Object) myhashMap).iterator(); 
		return terator;
				  
	
	}*/
	private void fluentWait(String Value ,WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath(Value));
			}
		});

	}
	
	@Test(dataProvider ="test1")
	private void test1(String username, String pass) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
		String User="(//input[@class='whsOnd zHQkBf'])[1]";
		fluentWait(User, driver);
		driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]")).sendKeys(username);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		String Pass="(//input[@class='whsOnd zHQkBf'])[1]";
		fluentWait(User, driver);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
        Thread.sleep(5000);
        driver.close();
	}
}
