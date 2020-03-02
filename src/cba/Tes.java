package cba;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.remote.MobileCapabilityType;

public class Tes {

	static public void main(String...args) throws MalformedURLException, InterruptedException {
		
	    WebDriver driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.get("https://altbalajifire.firebaseapp.com");

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        driver.findElement(By.className("link-under")).click();
		driver.findElement(By.id("showMenu")).click();
		
		//Click on sign in
		//driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm']")).click();
		
		driver.findElement(By.xpath("//button[@class='signup-btn']")).click();
		//String actual=driver.findElement(By.id("header-title")).getText();
		
		Thread.sleep(2000);
		
		Random rand = new Random(); 
		int ra=rand.nextInt(1000);
		
		driver.findElement(By.name("email")).sendKeys(ra+"@mob.com");
		driver.findElement(By.id("input-password")).sendKeys("12345678");
		driver.findElement(By.id("input-conf-pass")).sendKeys("12345678");
		driver.findElement(By.name("first-name")).sendKeys("Regs");
		
		//select 
		Select sel=new Select(driver.findElement(By.name("DOBDay")));
		sel.selectByIndex(29);
		
		
		Select sel1=new Select(driver.findElement(By.name("DOBMonth")));
		sel1.selectByIndex(9);
		
		Select sel2=new Select(driver.findElement(By.name("DOBYear")));
		sel2.selectByValue("1995");
		
		driver.findElement(By.className("altf-gender-label")).click();
		
		driver.findElement(By.id("signup-phone")).sendKeys("9880325454");
		
		//select
		Select sel4=new Select(driver.findElement(By.className("slct-control")));
		sel4.selectByVisibleText("Karnataka");
		
		driver.findElement(By.name("terms")).click();
		
		driver.findElement(By.xpath("//input[@class='submit-btn grad-btn btn']")).click();
		
		driver.findElement(By.xpath("//p[@class='link-under center-skip']")).click();
		
		driver.findElement(By.xpath("//img[@class='kids-pin-close cross_width']")).click();
		
		//click on Side menu in HambergurMenu
		driver.findElement(By.id("showMenu")).click();
		
		//Select settings
		driver.findElement(By.linkText("SETTINGS")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='nav-menu']")).click();   
		//logout
		driver.findElement(By.className("signup-btn")).click();
		//yes
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("showMenu")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm']")).click();
		
		//Thread.sleep(4000);
		
		driver.findElement(By.name("email")).sendKeys(ra+"@mob.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
		
		//click Done button
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn grad-btn btn-lg']")));
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']")).click();    
		// .//button[@class="btn grad-btn btn-lg"] used in console 
		Thread.sleep(2000);
		driver.findElement(By.id("showMenu")).click();
		    
		  String s1=driver.findElement(By.linkText("FAVOURITES")).getText();
          System.out.println("Side menu is : " + s1);
		  String s2="FAVOURITES";
		  System.out.println(s2);
         
         if(s1.equals(s2))
         {
        	 System.out.println("Log in Passed");
         }
         else
         {
        	 System.out.println("log in failed");
         }
         
       
         //Selecting all the pages from side menu
 		//from Home page
 		driver.findElement(By.linkText("HOME")).click();
 		Thread.sleep(1000);
 		List<WebElement> list = driver.findElements(By.xpath("//div[@class='category-title']"));
 		for(WebElement s:list)
 		{
 		System.out.println(s.getText());
 		}
 		
 		Thread.sleep(2000);
 		
 		System.out.println("");
 		

	}

}
