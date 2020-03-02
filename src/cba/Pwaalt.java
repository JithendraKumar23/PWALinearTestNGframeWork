package cba;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;


public class Pwaalt {
	
	public  WebDriver driver;
	public AndroidDriver<MobileElement> drivplay;
	public WebDriverWait wait;
	
	
	public void clear() throws InterruptedException
	{         
	  try   
	  {    
	    if(driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and text()='Clear all devices']")).isDisplayed())     
	    {      
	    	Thread.sleep(2000);
			wait=new WebDriverWait(driver, 10);
			//driver.findElement(By.xpath("//p[@class='link-under' and text()='CANCEL']")).click();
			System.out.println("Device limit reached!! Clearing all devices....");
			WebElement clr=driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and text()='Clear all devices']"));
			wait.until(ExpectedConditions.elementToBeClickable(clr));
			clr.click(); 
	    }    
	  }      
	  catch(Exception e)     
	  {       
		  	Thread.sleep(2000);
			System.out.println("Device limit not reached, Hence proceeding...");   
	  }       
	}     
	
	//preferred regional language needed 
	
	
	
	@BeforeClass
	public void appLaunch() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8");
		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		//driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		//http://0.0.0.0:4723/wd/hub
		
		
		Thread.sleep(20000);
		driver.get("https://altbalajifire.firebaseapp.com");
	}
	
	@Test(priority= 1 ,enabled = true)
	public void signUp() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        driver.findElement(By.className("link-under")).click();
        driver.findElement(By.xpath("//button[@class='menu-bread']")).click();     
		
		//Click on sign up
		//driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and text()='Sign in']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1800)");
		Thread.sleep(1000);
		WebElement el = driver.findElement(By.xpath("//button[@class='signup-btn']"));
		el.click();
		//String actual=driver.findElement(By.id("header-title")).getText();
		
		Thread.sleep(2000);
		
		Random rand = new Random(); 
		int ra=rand.nextInt(10000);
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
		
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@class='submit-btn grad-btn btn']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[@class='link-under center-skip']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class='kids-pin-close cross_width']")).click();
		}
	
	
	
	@Test(priority=2,enabled=false)
	public void logout() throws InterruptedException
	{
		        //click on Side menu in HambergurMenu
				driver.findElement(By.id("showMenu")).click();
				
				//Select settings
				driver.findElement(By.linkText("SETTINGS")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@class='nav-menu']")).click();  
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(3000);
				//logout
				driver.findElement(By.className("signup-btn")).click();
				//yes
				driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']")).click();
	}
	
	@Test(priority=3,enabled=false)
	public void forgotPassword() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("showMenu")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(), 'Sign in')]")).click();

		driver.findElement(By.xpath("//a[@class='forgot-psw link-under']")).click();
		
		driver.findElement(By.id("wage")).sendKeys("sub3@mob.com"); //jithedra.kumar@mobotics.com
		
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg'][contains(text(),'OK')]")).click();
		
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg'][contains(text(),'HOME')]")).click();
	}
	
	@Test(priority=4,enabled=false)
	public void errorMsgfromSigninPage() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("showMenu")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(), 'Sign in')]")).click();
		
		driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
		
		WebElement wee=driver.findElement(By.xpath("//p[contains(text(),'Enter your email here')]"));
		System.out.println(wee.getText());
		
		driver.findElement(By.xpath("//a[@class='link-under' and text()='Terms of Use']")).click();
		
		//printing page name 
		Thread.sleep(1000);
		WebElement el2 = driver.findElement(By.id("header-title"));
		System.out.println("Page Name :"+ el2.getText());
		
	    wait = new WebDriverWait(driver, 30);
	    WebElement el4=driver.findElement(By.xpath("//button[@class='menu-bread']"));
	    wait.until(ExpectedConditions.elementToBeClickable(el4));
	    el4.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(), 'Sign in')]")).click();
		
		driver.findElement(By.xpath("//a[@class='link-under' and text()='Privacy Policy']")).click();
		
		//printing page name 
		Thread.sleep(1000);
		WebElement el3 = driver.findElement(By.id("header-title"));
		System.out.println("Page Name :"+ el3.getText());
	}
	
	@Test(priority=5,enabled=false)
	public void signInFromFavPage() throws InterruptedException
	{
			wait=new WebDriverWait(driver, 20);
		   //driver.findElement(By.className("link-under")).click();
			Thread.sleep(3500);
			
			//Direct run manpunaga padina
			//WebElement ell2=driver.findElement(By.xpath("//img[@class='kids-pin-close cross_width']"));
			//wait.until(ExpectedConditions.elementToBeClickable(ell2));
		    //ell2.click();
			
			WebElement ell1=driver.findElement(By.id("showMenu"));
			wait.until(ExpectedConditions.elementToBeClickable(ell1));
		    ell1.click();
			
			driver.findElement(By.linkText("HOME")).click();
			Thread.sleep(5500);
		   //click on fav icon in home page 
			
			
	       //WebElement el25=driver.findElement(By.xpath("(//img[@alt='home-icons'])[4]"));
			WebElement el25=driver.findElement(By.xpath("(//img[@class='home-icons'])[3]"));
	       wait.until(ExpectedConditions.elementToBeClickable(el25));
	       el25.click();
	       
	       //click on skip for now link 
	       Thread.sleep(1000);
	       WebElement el26=driver.findElement(By.xpath("//p[@class='link-under' and text()='SKIP FOR NOW']"));
	       wait.until(ExpectedConditions.elementToBeClickable(el26));
	       el26.click();
	       
	       //Changed
	       driver.findElement(By.xpath("(//img[@class='home-icons'])[3]")).click();
	       
	       WebElement el27=driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']"));
	       wait.until(ExpectedConditions.elementToBeClickable(el27));
	       el27.click();
	       Thread.sleep(2000);
	       driver.findElement(By.name("email")).sendKeys("regs6@mob.com");
	       driver.findElement(By.name("password")).sendKeys("12345678");
	       driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
	       
	        Thread.sleep(3000);
	        clear();
	       //log out 
	       
	        Thread.sleep(2000);
			WebElement el22=driver.findElement(By.xpath("//button[@class='menu-bread']"));
			wait.until(ExpectedConditions.elementToBeClickable(el22));
			Thread.sleep(3000);
			el22.click();
			
			//Select settings
			WebElement el18=driver.findElement(By.linkText("SETTINGS"));
			wait.until(ExpectedConditions.elementToBeClickable(el18));
			el18.click();
			
			Thread.sleep(2000);
			WebElement el28=driver.findElement(By.xpath("//a[@class='nav-menu']")); 
			wait.until(ExpectedConditions.elementToBeClickable(el28));
			el28.click();
			JavascriptExecutor js3=(JavascriptExecutor)driver;
			js3.executeScript("window.scrollBy(0,1500)");
			Thread.sleep(2000);
			//logout
			driver.findElement(By.className("signup-btn")).click();
			//yes
			driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']")).click();
		
		    Thread.sleep(2000);
		    
		   //driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(), 'Sign in')]")).click();
		    JavascriptExecutor js6=(JavascriptExecutor)driver;
			js6.executeScript("window.scrollBy(0,500)");
		    WebElement el23=driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]"));
		    wait.until(ExpectedConditions.elementToBeClickable(el23));
		    el23.click();
		    
		    //ok
		    Thread.sleep(3000);
		    WebElement el24=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]"));
		    wait.until(ExpectedConditions.elementToBeClickable(el24));
		    el24.click();
		    
		    Thread.sleep(2000);
		    //fav
		    driver.findElement(By.className("fav-img")).click();
		    
		    driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg' and text()='SIGN IN']")).click();
		       
		    driver.findElement(By.name("email")).sendKeys("regs6@mob.com");
		    driver.findElement(By.name("password")).sendKeys("12345678");
		    driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
		    
		    Thread.sleep(3000);
		    clear();
		    
		    //log out 
	        Thread.sleep(4000);
			driver.findElement(By.id("showMenu")).click();
			
			//Select settings
			WebElement el20=driver.findElement(By.linkText("SETTINGS"));
			wait.until(ExpectedConditions.elementToBeClickable(el20));
			el20.click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='nav-menu']")).click();
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,2700)");
			Thread.sleep(1000);
			//logout
			driver.findElement(By.className("signup-btn")).click();
			//yes
			driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']")).click();
	
		}
	
	@Test(priority=6,enabled=false)
	public void loginNewRegUser() throws InterruptedException
	   {
		Thread.sleep(15000);	 
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showMenu")));
		Thread.sleep(2000);
		//driver.findElement(By.xpath("button[@class='btn grad-btn btn-sm']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(),'Sign in')]")).click();
	
		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("sub27@mob.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
		
		Thread.sleep(3000);
	    clear();
	}
	
	@Test(priority=7,enabled=false)
	public void alreadyRegUserErrorMsg() throws InterruptedException
	{
		wait=new WebDriverWait(driver, 20);
		Thread.sleep(3000);
		driver.findElement(By.id("showMenu")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showMenu")));
		
		//Select settings
		Thread.sleep(2500);
		//JavascriptExecutor scroll=(JavascriptExecutor)driver;
		//scroll.executeScript("window.scrollBy(0,2000)");
		
		
		WebElement scro = driver.findElement(By.linkText("SETTINGS"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scro);
		
		
		Thread.sleep(1500);
		WebElement el21=driver.findElement(By.linkText("SETTINGS"));
		//wait.until(ExpectedConditions.elementToBeClickable(el21));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SETTINGS")));
		el21.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='nav-menu']")).click();
		
		JavascriptExecutor js7=(JavascriptExecutor)driver;
		js7.executeScript("window.scrollBy(0,1700)");
		Thread.sleep(2000);
		//logout
		driver.findElement(By.className("signup-btn")).click();
		//yes
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']")).click();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //driver.findElement(By.className("link-under")).click();
		Thread.sleep(3000);	 
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
		  
		//Click on sign in
		//driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm']")).click();
		
		driver.findElement(By.xpath("//button[@class='signup-btn']")).click();
		//String actual=driver.findElement(By.id("header-title")).getText();
		
		Thread.sleep(2000);
		
		//Random rand = new Random(); 
		//int ra=rand.nextInt(1000);
		
		driver.findElement(By.name("email")).sendKeys("regs14@mob.com");
		driver.findElement(By.id("input-password")).sendKeys("12345678");
		driver.findElement(By.id("input-conf-pass")).sendKeys("12345678");
		driver.findElement(By.name("first-name")).sendKeys("Regs");
		
		//select 
		Select sel11=new Select(driver.findElement(By.name("DOBDay")));
		sel11.selectByIndex(29);
		
		
		Select sel12=new Select(driver.findElement(By.name("DOBMonth")));
		sel12.selectByIndex(9);
		
		Select sel13=new Select(driver.findElement(By.name("DOBYear")));
		sel13.selectByValue("1995");
		
		driver.findElement(By.className("altf-gender-label")).click();
		
		driver.findElement(By.id("signup-phone")).sendKeys("9880325454");
		
		//select
		Select sel14=new Select(driver.findElement(By.className("slct-control")));
		sel14.selectByVisibleText("Karnataka");
		
		driver.findElement(By.name("terms")).click();
		
		driver.findElement(By.xpath("//input[@class='submit-btn grad-btn btn']")).click();
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement el=driver.findElement(By.xpath("//div[@class='popup-bg']/div[@class='form-group']/h3"));
		//wait.until(ExpectedConditions.visibilityOf(el));
		Thread.sleep(2000);
		System.out.println("Printing the error msg from the popup : "+ el.getText()); 
		
		// clicking ok for that pop up
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']")).click();
		
	}
	
	@Test(priority=8,enabled=false)
	public void printingHomePageSubSection() throws InterruptedException
	{
		//click side menu
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
		//click on sign in button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(), 'Sign in')]")).click();
		
		driver.findElement(By.name("email")).sendKeys("sub10@mob.com"); 
		driver.findElement(By.name("password")).sendKeys("12345678"); 
		driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
		
		Thread.sleep(2000);
		clear();

		System.out.println("Printing Home page sub-Sections");
		List<MobileElement> list = driver.findElements(By.xpath("//div[@class='category-title']"));
		for(WebElement s:list)
		{
		System.out.println(s.getText());
		}	
	}
	
	@Test(priority=9,enabled=false)
	public void selectingPreferredRegionlaLanguage() throws InterruptedException
	{
		//click side menu
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
		
		driver.findElement(By.linkText("SETTINGS")).click();
		
		driver.findElement(By.className("tab-sec")).click();
		driver.findElement(By.xpath("//label[@for='lang-rdo-5']")).click();
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg-language']")).click();
		
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.xpath("//div[@class='tab-sec']/p[contains(text(),'Bahasa Indonesia')]"));
		Thread.sleep(2000);
		System.out.println("Preferred regional Language : "+ele.getText());	
	}
	
	@Test(priority=10,enabled=false)
	public void editProfileDetail() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@class='nav-menu']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//img[@class='edit-img']")).click();
	    
	    //edit profile page
	    driver.findElement(By.className("alt-form-control")).clear();
	    driver.findElement(By.className("alt-form-control")).sendKeys("Nanu");
	    driver.findElement(By.id("accedit-pass")).sendKeys("12345678");
	    driver.findElement(By.id("accedit-conf-pass")).sendKeys("12345678");
	    driver.findElement(By.xpath("//label[@class='altf-gender-label' and contains(text(),'FEMALE')]")).click();
	    
	    driver.findElement(By.id("accedit-phone")).clear();
	    driver.findElement(By.id("accedit-phone")).sendKeys("9876543211");
	    
	    Select sell=new Select(driver.findElement(By.name("DOBDay")));
	    sell.selectByValue("22");
	    
	    Select sell1=new Select(driver.findElement(By.name("DOBMonth")));
	    sell1.selectByValue("01");
	    
	    Select sell2=new Select(driver.findElement(By.name("DOBYear")));
	    sell2.selectByValue("1990");
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@class='submit-btn grad-btn btn']")).click(); 
	}
	
	@Test(priority=11 , enabled=false)
	public void navigateAllPages() throws InterruptedException
	{ 
		//click side menu
		Thread.sleep(2000);
		String[] ss={"SHOWS","MOVIES","COMEDY"};
	    //"SUBSCRIPTION","NOTIFICATIONS","FAVOURITES","SETTINGS","HELP","ABOUT"
	     for(String s3 : ss)
	     {
	    	 	Thread.sleep(2000);
	    	    WebDriverWait wait = new WebDriverWait(driver, 10); 
	    	    
	    	    
	    	    WebElement el1=driver.findElement(By.xpath("//button[@class='menu-bread']"));
	    	    wait.until(ExpectedConditions.elementToBeClickable(el1));
	    	    el1.click();
	    	    
	    	    Thread.sleep(4500);
	    	    driver.findElement(By.linkText(s3)).click();
				WebElement wb = driver.findElement(By.id("header-title"));
				Thread.sleep(3000);
				String s = wb.getText();
				System.out.println("Page name : "+ s );
				
			
		 }
	    
	}
	
	@Test(priority=12 , enabled=false)
	public void sendingQueryFromHelpPage() throws InterruptedException
	{	
		System.out.println("Page name : "+ "SUBSCRIPTION" );
		System.out.println("Page name : "+ "NOTIFICATIONS");
		System.out.println("Page name : "+ "FAVOURITES");
		System.out.println("Page name : "+ "SETTINGS");
		System.out.println("Page name : "+ "HELP");
		System.out.println("Page name : "+ "ABOUT");
		wait = new WebDriverWait(driver, 20);
	    Thread.sleep(3000);
	    WebElement el4=driver.findElement(By.xpath("//button[@class='menu-bread']"));
	    wait.until(ExpectedConditions.elementToBeClickable(el4));
	    el4.click();
        Thread.sleep(3000);
	    driver.findElement(By.linkText("HELP")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//div[@class='comm-text' and contains(text(),'Common')]")).click();
	    Thread.sleep(2500);
	    driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg']")).click();  
	    Thread.sleep(3000);
	    WebElement elt7=driver.findElement(By.xpath("//p[@class='faq_title' and text()='Tap to select a query type']"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt7));
	    elt7.click();
	    Thread.sleep(2000);
	    
	    List<MobileElement> list2 = driver.findElements(By.xpath("//div[@class='container']"));
			for(WebElement s2:list2)
			{
			//System.out.println(s2.getText());
			//WebDriverWait wi = new WebDriverWait(driver, 20);
			WebElement elt = driver.findElement(By.xpath("(//li[@class='listQuestion'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(elt));
			
			elt.click();
			}	
            
			driver.findElement(By.id("questionTitle")).sendKeys("Request to forget...");
			Thread.sleep(2000);
			WebElement elt5=driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg' and text()='SUBMIT']")); 
			wait.until(ExpectedConditions.elementToBeClickable(elt5));
			elt5.click();
			Thread.sleep(3000);
			WebElement elt18=driver.findElement(By.xpath("(//button[@class='btn btn-grad btn-lg' and text()='BACK'])"));
			wait.until(ExpectedConditions.elementToBeClickable(elt18));
			elt18.click();
	}
	
	@Test(priority=13 , enabled=false)
	public void favourite() throws InterruptedException
	{
			Thread.sleep(5000);
			//click side menu
			driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
			
			driver.findElement(By.linkText("SHOWS")).click();
			wait=new WebDriverWait(driver, 20);
		   //add show to fav page 
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,4500)");
			Thread.sleep(2700);
			driver.findElement(By.xpath("(//img[@alt='alt-poster'])[8]")).click();
			
			//ok 
			Thread.sleep(2700);
			
			try
			{
				if(driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).isDisplayed())
				{
					Thread.sleep(3000);
					wait=new WebDriverWait(driver, 10);
					WebElement elt=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]"));
					wait.until(ExpectedConditions.elementToBeClickable(elt));
					elt.click();
				}
			}
			catch(Exception ee)
			{
				Thread.sleep(2000);
				System.out.println("Pop up is not visible");
			}
	
		    Thread.sleep(3000);
		    //fav
		    WebElement fa=driver.findElement(By.className("fav-img"));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fav-img")));
		    fa.click();
		    //driver.findElement(By.className("fav-img")).click();
		    
		    Thread.sleep(4000);
	 
		    //Add movie to fav page 
		    Thread.sleep(4000);	    
		    driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.linkText("MOVIES")).click();
		    
		    js.executeScript("window.scrollBy(0,3000)");
		    Thread.sleep(3000);

		     driver.findElement(By.xpath("(//img[@alt='alt-poster'])[4]")).click();
		     //add to fav
		     Thread.sleep(4000);
	         driver.findElement(By.xpath("//img[@class='fav-img']")).click();
		    
		    //Add comedy to fav page 
		    driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.linkText("COMEDY")).click();
		    
		    js.executeScript("window.scrollBy(0,3000)");
		    
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[5]")).click();
		    
		    //Print the Text
		    Thread.sleep(4000);
		    WebElement wb5= driver.findElement(By.id("header-title"));
			String s2=wb5.getText();
			System.out.println("Printing page title from Comedy page : "+ s2);
		    
			
			
		    //fav
			Thread.sleep(4000);
		    driver.findElement(By.className("fav-img")).click();
		    
		    //Navigate to Fav page
		    Thread.sleep(4000);
		    driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
		    Thread.sleep(6000);
		    driver.findElement(By.linkText("FAVOURITES")).click();
		    
		    
		    
		    Thread.sleep(5000);
/*
		    driver.findElement(By.xpath("//a[@class='scroll-menu' and text()='MOVIES']")).click();
		    //click on delet buttton 
		    Thread.sleep(5000);
		    //WebElement eltdel=driver.findElement(By.id("delete-ico"));
		    driver.findElement(By.id("delete-ico")).click();
		    //wait.until(ExpectedConditions.elementToBeClickable(eltdel));
		    //eltdel.click();
		    //tick
		    
		    Thread.sleep(5000);
		    WebElement el10 = driver.findElement(By.xpath("//input[@class='del-check fav-del-check']"));
		    wait.until(ExpectedConditions.elementToBeClickable(el10));
		    el10.click();
		    //CLEAR SELECTED 
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg' and text()='CLEAR SELECTED']")).click();
		   
		    Thread.sleep(4000);
		   driver.findElement(By.xpath("//p[@class='link-under' and text()='NO']")).click();
		   //CLEAR SELECTED 
		   Thread.sleep(4000);
		   driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg' and text()='CLEAR SELECTED']")).click();
		   //YES
		   Thread.sleep(4000);
		   driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg' and text()='YES']")).click();
		    
		   //show page
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("(//div[@class='mvi-item']/div[@class='mvi-img-sec'])[1]")).click();
		   
		  Thread.sleep(5000);
		  WebElement wb6= driver.findElement(By.id("header-title"));
		  String s1=wb6.getText();
		  System.out.println("Printing page title from Fav page : "+s1);
		 
		  if(s1.equals(s2))
		  {
			//remove fav from show section 
			    Thread.sleep(5000);
			    driver.findElement(By.className("fav-img")).click();
			    System.out.println("Both fav Content are Same");
		  }
		  else
		  {
			  System.out.println("Not a Same content");
		  }
		   
		 //Delet all the fav content 
		  WebDriverWait wait1=new WebDriverWait(driver, 20);
		  WebElement el8=driver.findElement(By.id("showMenu"));
		  wait1.until(ExpectedConditions.elementToBeClickable(el8));
		  el8.click();
		  
		  driver.findElement(By.linkText("FAVOURITES")).click(); 
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("(//img[@class='header-ico header-ico-right'])[2]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg' and text()='CLEAR ALL']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg' and text()='YES']")).click();
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(4000);
		  WebElement el9=driver.findElement(By.className("empty-msg"));
		  System.out.println(el9.getText());
	        
		  //Navigate Movies and Videos Subsection 
		  Thread.sleep(2000);
		  WebElement el12 = driver.findElement(By.xpath("//a[@class='scroll-menu' and text()='MOVIES']"));
		  Thread.sleep(4000);
		  System.out.println("Sub-section in Fav Page : " + el12.getText());
		  el12.click();
		  
		  WebElement el13 = driver.findElement(By.xpath("//a[@class='scroll-menu' and text()='VIDEOS']"));
		  Thread.sleep(4000);
		  System.out.println("Sub-section in Fav Page : " + el13.getText());	
		  el13.click();
	
		*/  
		  
	}
	
	@Test(priority=14 , enabled=false)
	public void search() throws InterruptedException
	{
		Thread.sleep(3000);
	    driver.findElement(By.id("showMenu")).click();

	    driver.findElement(By.linkText("HOME")).click();
	    
	    Thread.sleep(15000);
	    /*
		driver.findElement(By.id("search-ico-default")).click();
		WebElement el14 = driver.findElement(By.id("alt-search-input"));
		el14.click();
		el14.sendKeys("kil");
		Thread.sleep(3000);
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER).build().perform();
       
		Thread.sleep(1000);
		List<MobileElement> ls = driver.findElements(By.xpath("//div[@class='mvi-data']"));
		int count=0;
		Thread.sleep(2500);
		for(WebElement el:ls)
       		{
       		count++;
       		}
       
		Thread.sleep(2000);
		if(count<1)
       		{
       		WebElement web1=driver.findElement(By.xpath("//div[@class='v-center-box']"));
       		System.out.println(web1.getText());
       		}
		else
       		{
    	   	System.out.println(count); 
       	 
       	 	Thread.sleep(5000);
            WebElement web2=driver.findElement(By.xpath("//a[@class='scroll-menu'and text()='SHOWS']"));
            web2.click();
            System.out.println("From Search Page Section : " + web2.getText());
            
            Thread.sleep(3000);
            WebElement web3=driver.findElement(By.xpath("//a[@class='scroll-menu'and text()='MOVIES']"));
            web3.click();
            System.out.println("From Search Page Section : " + web3.getText());
            
            Thread.sleep(4000);
            WebElement web4=driver.findElement(By.xpath("//a[@class='scroll-menu'and text()='VIDEOS']"));
            web4.click();
            System.out.println("From Search Page Section : " + web4.getText());
            
            driver.findElement(By.xpath("//img[@class='header-ico search-input-elem'][1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//img[@class='header-ico search-input-elem'][1]")).click();
       		}
	}

	@Test(priority=15 , enabled=false)
	public void moreDetails() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("SHOWS")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[7]")).click();
	    
	    Thread.sleep(3000);
	    //driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg'])[1]")).click();
	    
	    driver.findElement(By.xpath("//button[@class='more-det-btn']")).click();
	    
	    Thread.sleep(1500);
	    WebElement elt12=driver.findElement(By.xpath("//h3[@class='trailer-name']"));
	    System.out.println("Printing series name from More Detail pop-Up : "+elt12.getText());
	    
	    Thread.sleep(1000);
	    WebElement elt13=driver.findElement(By.xpath("(//ul[@class='info-tags'])[2]"));
	    System.out.println("Printing Series info tags from More Details pop up : "+elt13.getText());
	    
	    Thread.sleep(700);
	    WebElement elt14=driver.findElement(By.xpath("(//span[@class='description-media'])[1]"));
	    System.out.println("Printing the Release year from More Details pop up : "+elt14.getText());
	    
	    Thread.sleep(2000);   
	    driver.navigate().back();
	    
	    */
	}
	
	@Test(priority=16 , enabled=false)
	public void share() throws InterruptedException
	{
		Thread.sleep(3000);
		//wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("COMEDY")).click();
	    
	    Thread.sleep(2000);
	    WebElement elt19=driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt19));
	    elt19.click();
	    
	    Thread.sleep(2000);
	    //WebElement elt20=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg'])[1]"));
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn grad-btn btn-lg'])[1]")));
	    //elt20.click();
	    
	    driver.findElement(By.xpath("//img[@class='share-img']")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
	 }
	
	@Test(priority=17 , enabled=false)
	public void selectLanguage() throws InterruptedException
	{
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("HOME")).click();
	    
	    Thread.sleep(2000);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	    
	    Thread.sleep(2000);
	    WebElement elt19=driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]"));
	    //wait.until(ExpectedConditions.elementToBeClickable(elt19));
	    elt19.click();
	    
	    Thread.sleep(2000);
	    //WebElement elt20=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg'])[1]"));
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn grad-btn btn-lg'])[1]")));
	    //elt20.click();
	    
	    //Thread.sleep(2000);
	    driver.findElement(By.id("lang")).click();
	   
	    System.out.println("List of preffered language : ");
	    List<MobileElement> li1=driver.findElements(By.className("alt-list"));
	    for(WebElement we:li1)
		{
	    	System.out.println(we.getText());
	    	Thread.sleep(2000);
		}
	    //System.out.println("Clicking on text: " +  driver.findElement(By.xpath("//*[@id='alt-app']//*[text()='Tamil']")));
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//*[@id='alt-app']//*[text()='Hindi']")).click();
	}
	
	@Test(priority=18 , enabled=false)
	public void player() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 25);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("COMEDY")).click();
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]")).click();
	    
	    Thread.sleep(3000);
	    try
		{
			if(driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).isDisplayed())
			{
				Thread.sleep(3000);
				wait=new WebDriverWait(driver, 10);
				WebElement elt=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]"));
				wait.until(ExpectedConditions.elementToBeClickable(elt));
				elt.click();
			}
		}
		catch(Exception ee)
		{
			Thread.sleep(2000);
			System.out.println("Pop up is not visible");
		}
	    
	    Thread.sleep(2500);
	    driver.findElement(By.xpath("//button[@class='detail-btn trailer-btn' and text()=' Trailer']")).click();
	    //Play
	    Thread.sleep(2000);
	    driver.findElement(By.id("v-toggler")).click();
	  
	    /*
	    
	    Thread.sleep(4000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("v-toggler")));
	    //driver.findElement(By.id("v-toggler")).click();
	    
	    WebElement elt30=driver.findElement(By.xpath("//span[@class=' player-header-episode']"));
	    System.out.println("Printing tag from player : " + elt30.getText());
	    
	    Thread.sleep(1500);
	    //Click on player page
	    //driver.findElement(By.id("v-controls")).click();
	    //Pause
	    WebElement pause=driver.findElement(By.id("v-toggler"));
	    //wait.until(ExpectedConditions.elementToBeClickable(pause));
	    pause.click();
	    
	    Thread.sleep(2000);
	    WebElement elt31=driver.findElement(By.xpath("//h3[@class='player-title']"));
	    System.out.println("Printing Series name from player : " + elt31.getText());
	    
	    */
	    
	    Thread.sleep(4000);
	    driver.navigate().back();
	}
	
	 @Test(priority=19 , enabled=false)
	 public void videoQuality() throws InterruptedException
	 {
		 	Thread.sleep(5000);
		    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]")).click();
		    
		    Thread.sleep(3000);
		    try
			{
				if(driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).isDisplayed())
				{
					Thread.sleep(3000);
					wait=new WebDriverWait(driver, 10);
					WebElement elt=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]"));
					wait.until(ExpectedConditions.elementToBeClickable(elt));
					elt.click();
				}
			}
			catch(Exception ee)
			{
				Thread.sleep(2000);
				System.out.println("Pop up is not visible");
			}
		    
		    Thread.sleep(2500);
		    driver.findElement(By.xpath("(//img[@class='play-img'])[1]")).click();
		    //Play
		    Thread.sleep(3000);
		    driver.findElement(By.id("v-toggler")).click();
		    
		    Thread.sleep(5000);
		    WebElement elt34=driver.findElement(By.id("v-VideoQuality"));
		    wait.until(ExpectedConditions.elementToBeClickable(elt34));
		    elt34.click();
		    
		    WebElement elt35=driver.findElement(By.xpath("(//label[@class='rdo-language'])[3]"));
		    wait.until(ExpectedConditions.elementToBeClickable(elt35));
		    elt35.click();
		    
		    driver.findElement(By.xpath("//button[@class='btn btn-lg video-resolution-done-button']")).click();
		    
		    Thread.sleep(8000);
		    driver.navigate().back();
	 }
	
	@Test(priority=20 , enabled=false)
	public void seekBar() throws InterruptedException
	{
		Thread.sleep(5000);
	    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]")).click();
	    /*
	    Thread.sleep(3000);
	    try
		{
			if(driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).isDisplayed())
			{
				Thread.sleep(3000);
				wait=new WebDriverWait(driver, 10);
				WebElement elt=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]"));
				wait.until(ExpectedConditions.elementToBeClickable(elt));
				elt.click();
			}
		}
		catch(Exception ee)
		{
			Thread.sleep(2000);
			System.out.println("Pop up is not visible");
		}
	    
	    Thread.sleep(2500);
	    driver.findElement(By.xpath("(//img[@class='play-img'])[1]")).click();
	    //Play
	    Thread.sleep(2000);
	    driver.findElement(By.id("v-toggler")).click();
	    
	    //Pause
	    Thread.sleep(2000);
	    driver.findElement(By.id("v-toggler")).click();
	    Thread.sleep(1000);
	    int count1 = 0;
	    Thread.sleep(1000);
	    for(int i=0 ; i<=3 ; i++)
	    {
	    	Thread.sleep(2000);
	    	WebElement elt33=driver.findElement(By.id("v-forward"));
	    	wait.until(ExpectedConditions.elementToBeClickable(elt33));	
	    	elt33.click();
	    	
	    	count1 ++;
	    }
	    System.out.println("No of times +10 pressed : " + count1);
	    
	    Thread.sleep(2000);
	    
	    int count2 = 0;
	    Thread.sleep(1000);
	    for(int i=0 ; i<=2 ; i++)
	    {
	    	Thread.sleep(3500);
	    	WebElement elt33=driver.findElement(By.id("v-backward"));
	    	wait.until(ExpectedConditions.elementToBeClickable(elt33));
	    	elt33.click();
	    	
	    	count2 ++;
	    }
	    System.out.println("No of times -10 pressed : " + count2);
	    */
	    Thread.sleep(2000);
	    driver.navigate().back();
	}
	
	@Test(priority=21 , enabled=false)
	public void episodeListInPlayer() throws InterruptedException
	{
		Thread.sleep(5000);
	    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]")).click();
	    
	    Thread.sleep(3000);
	    try
		{
			if(driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).isDisplayed())
			{
				Thread.sleep(3000);
				wait=new WebDriverWait(driver, 10);
				WebElement elt=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]"));
				wait.until(ExpectedConditions.elementToBeClickable(elt));
				elt.click();
			}
		}
		catch(Exception ee)
		{
			Thread.sleep(2000);
			System.out.println("Pop up is not visible");
		}
	    
	    Thread.sleep(2500);
	    driver.findElement(By.xpath("(//img[@class='play-img'])[1]")).click();
	    //Play
	    
	    
	    
	    Thread.sleep(3000);
	    driver.findElement(By.id("v-toggler")).click();
	    
	   /* 
	    
	    Thread.sleep(5000);
	    driver.findElement(By.id("v-episodesList")).click();
	    
	    WebElement elt41=driver.findElement(By.xpath("(//img[@class='play-icon-on-player'])[1]"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt41));
	    elt41.click();
	    
	    Thread.sleep(3500);
	    WebElement elt42=driver.findElement(By.id("v-toggler"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt42));
	    elt42.click();
	    
	    Thread.sleep(2000);
	    for(int i=0 ; i<=2 ; i++)
	    {
	    Thread.sleep(5000);
	    WebElement elt43=driver.findElement(By.id("v-ic_Next_Episode"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt43));
	    elt43.click();
	    }
	    
	    */
	    
	    Thread.sleep(5000);
	    driver.navigate().back();
	}
	
	@Test(priority=22 , enabled=false)
	public void nextButtonCheckingForLastEpsidoe() throws InterruptedException
	{
		Thread.sleep(5000);
	    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]")).click();
	    
	    Thread.sleep(3000);
	    try
		{
			if(driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).isDisplayed())
			{
				Thread.sleep(3000);
				wait=new WebDriverWait(driver, 10);
				WebElement elt=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]"));
				wait.until(ExpectedConditions.elementToBeClickable(elt));
				elt.click();
			}
		}
		catch(Exception ee)
		{
			Thread.sleep(2000);
			System.out.println("Pop up is not visible");
		}
	    
	    Thread.sleep(2500);
	    driver.findElement(By.xpath("(//img[@class='play-img'])[1]")).click();
	    
	    
	    //Play
	    Thread.sleep(4000);
	    driver.findElement(By.id("v-toggler")).click();
	    
	    /*
	    
	    Thread.sleep(5000);
	    driver.findElement(By.id("v-episodesList")).click();
	    
	    WebElement elt41=driver.findElement(By.xpath("(//img[@class='play-icon-on-player'])[4]"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt41));
	    elt41.click();
	    
	    Thread.sleep(3000);
	    WebElement elt42=driver.findElement(By.id("v-toggler"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt42));
	    elt42.click();
	    
	    if(driver.findElement(By.id("v-ic_Next_Episode")).isDisplayed())
	    {
	    	System.out.println("Next epsiode button is displaying in last Epsiode");
	    }
	    else
	    {
	    	System.out.println("Next Episode Button is not Displaying in Last Episode");
	    }
	    
	    */
	    
	    Thread.sleep(5000);
	    driver.navigate().back();
	}
	
	@Test(priority=23 , enabled=false)
	public void resumeFunctionslity() throws InterruptedException
	{
		Thread.sleep(5000);
	    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]")).click();
	    
	    Thread.sleep(3000);
	    try
		{
			if(driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).isDisplayed())
			{
				Thread.sleep(3000);
				wait=new WebDriverWait(driver, 10);
				WebElement elt=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]"));
				wait.until(ExpectedConditions.elementToBeClickable(elt));
				elt.click();
			}
		}	
		catch(Exception ee)
		{
			Thread.sleep(2000);
			System.out.println("Pop up is not visible");
		}
	    
	    Thread.sleep(3500);
	    driver.findElement(By.xpath("(//img[@class='play-img'])[5]")).click();
	    //Play
	    Thread.sleep(3000);
	    driver.findElement(By.id("v-toggler")).click();
	    
	    Thread.sleep(3500);
	    //Pause
	    driver.findElement(By.id("v-toggler")).click();
	    
	    WebElement elt30=driver.findElement(By.xpath("//div[@class='player-header-episode']"));
	    System.out.println("Printing Episode number from player : " + elt30.getText());
	    
	    Thread.sleep(1000);
	    WebElement elt53=driver.findElement(By.xpath("//h3[@class='player-title']"));
	    String s1=elt53.getText();
	    System.out.println("Printing Epsiode name from player : " + s1);
	    
	    driver.navigate().back();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[2]")).click();
	    
	    //Resume
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@class='btn grad-btn watch-btn']")).click();
	    
	    Thread.sleep(3500);
	    //play
	    driver.findElement(By.id("v-toggler")).click();
	    
	    Thread.sleep(5000);
	    WebElement elt51=driver.findElement(By.xpath("//div[@class='player-header-episode']"));
	    System.out.println("Printing Episode number from player : " + elt51.getText());
	     
	    //pause
	    driver.findElement(By.id("v-toggler")).click();
	    Thread.sleep(4000);
	    WebElement elt52=driver.findElement(By.xpath("//h3[@class='player-title']"));
	    String s2=elt52.getText();
	    System.out.println("Printing Epsiode name from player : " + s2);
	    
	    Thread.sleep(3000);
	    if(s1.equals(s2))
	    {
	      System.out.println("Resume function : PASS..");	
	    }
	    else
	    {
	    	System.out.println("Resume function : FAIL..");	
	    }
	    driver.navigate().back();
	    
	}
	
	@Test(priority=24 , enabled=false)
	public void seekForwardInPlayer() throws InterruptedException
	{
		
	}	
}
