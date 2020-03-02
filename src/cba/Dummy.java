package cba;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Dummy {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	
	
	static public void main(String...ars) throws InterruptedException, AWTException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://altbalajifire.firebaseapp.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		Thread.sleep(2000);
       driver.findElement(By.className("link-under")).click();
       driver.findElement(By.xpath("//button[@class='menu-bread']")).click();

       Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(),'Sign in')]")).click();
	
		
		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("sub10@mob.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
       
		/*
       //preferred regional language 
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg' and text()='DONE']")).isDisplayed())
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
			WebElement el7=driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg' and text()='DONE']"));
			wait.until(ExpectedConditions.elementToBeClickable(el7));
			el7.click();
		}
		else
		{
			System.out.println(" preferred regional language pop up is not Dispalyed ");
		}
		
		*/
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("ABOUT")).click();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //quality
	    
	    
	    WebElement elt34=driver.findElement(By.id("v-VideoQuality"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt34));
	    elt34.click();
	    
	    WebElement elt35=driver.findElement(By.xpath("(//label[@class='rdo-language'])[3]"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt35));
	    elt35.click();
	    
	    driver.findElement(By.xpath("//button[@class='btn btn-lg video-resolution-done-button']")).click();
	    
	    Thread.sleep(5000);
	    driver.navigate().back();
	   
	    
	    
	    
	    
	    
	    
	    
	    
}
}

    
	






















/////////////edit  profile 
/*driver.findElement(By.name("email")).clear();
driver.findElement(By.name("email")).sendKeys("regs11@mob.com");
/*Robot robot=new Robot();
Thread.sleep(3000);
robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_A);
driver.findElement(By.name("email")).sendKeys("regs11@mob.com"); 




driver.findElement(By.id("input-password")).sendKeys("12345678");
driver.findElement(By.id("input-conf-pass")).sendKeys("12345678");
driver.findElement(By.name("first-name")).sendKeys("Regs");

//select 
Select sel21=new Select(driver.findElement(By.name("DOBDay")));
sel21.selectByIndex(29);


Select sel22=new Select(driver.findElement(By.name("DOBMonth")));
sel22.selectByIndex(9);

Select sel23=new Select(driver.findElement(By.name("DOBYear")));
sel23.selectByValue("1995");

driver.findElement(By.className("altf-gender-label")).click();

driver.findElement(By.id("signup-phone")).sendKeys("9880325454");

//select
Select se24=new Select(driver.findElement(By.className("slct-control")));
se24.selectByVisibleText("Karnataka");

driver.findElement(By.name("terms")).click();

driver.findElement(By.xpath("//input[@class='submit-btn grad-btn btn']")).click();



*/

/*
// CLEAR ALL DEVICE
if(driver.findElement(By.xpath("//button[@id='clearDevicesButton']")).isDisplayed())
{
	Thread.sleep(1500);
	//driver.findElement(By.xpath("//p[@class='link-under' and text()='CANCEL']")).click();
	System.out.println("Device limit reached!! Clearing all devices....");
	driver.findElement(By.xpath("//button[@id='clearDevicesButton']")).click();
}
else{
	System.out.println("Device limit not reached, Hence proceeding...");
}
*/

/*

List<WebElement> list = driver.findElements(By.xpath("//div[@class='category-title']"));
for(WebElement s:list)
{
System.out.println(s.getText());
}


//edit profile 1..PREFFERED REGIONAL LANGUAGE 
driver.findElement(By.id("showMenu")).click();

driver.findElement(By.linkText("SETTINGS")).click();

// printing the Setting page Title
		WebElement wb = driver.findElement(By.id("header-title"));
		String s = wb.getText();
		System.out.println(s);

//driver.findElement(By.xpath("//a[@class='nav-menu active']")).click();

driver.findElement(By.className("tab-sec")).click();
driver.findElement(By.xpath("//label[@for='lang-rdo-5']")).click();
driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg-language']")).click();


////div[@class='tab-sec']/p[contains(text(),'Bahasa Indonesia')]
WebElement ele=driver.findElement(By.xpath("//div[@class='tab-sec']/p[contains(text(),'Bahasa Indonesia')]"));
Thread.sleep(2000);
System.out.println("Preferred regional Language = "+ele.getText());


//editt account details 
driver.findElement(By.xpath("//a[@class='nav-menu']")).click();
Thread.sleep(1000);
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
sell.selectByValue("30");

Select sell1=new Select(driver.findElement(By.name("DOBMonth")));
sell1.selectByValue("10");

Select sell2=new Select(driver.findElement(By.name("DOBYear")));
sell2.selectByValue("1995");

Thread.sleep(1000);
driver.findElement(By.xpath("//button[@class='submit-btn grad-btn btn']")).click();





		//help page >> select any query > sumbit ( with out img )
	    Thread.sleep(2000);
	    driver.findElement(By.id("showMenu")).click();

	    driver.findElement(By.linkText("HELP")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//div[@class='comm-text' and contains(text(),'Common')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg']")).click();  
	    driver.findElement(By.xpath("//p[@class='faq_title']")).click();
	    
	    Thread.sleep(2000);

	        
	    List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='container']"));
			for(WebElement s2:list2)
			{
			//System.out.println(s2.getText());
			WebDriverWait wi = new WebDriverWait(driver, 20);
			WebElement elt = driver.findElement(By.xpath("(//li[@class='listQuestion'])[1]"));
			wi.until(ExpectedConditions.elementToBeClickable(elt));
			
			elt.click();
			}	

			driver.findElement(By.id("questionTitle")).sendKeys("Request to forget..");
			driver.findElement(By.id("submitFaq")).click(); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@class='btn btn-grad btn-lg'])[2]")).click();









	//printing the Setting page Title
    Thread.sleep(2000);

    String[] ss={"SHOWS","MOVIES","COMEDY","SUBSCRIPTION","NOTIFICATIONS","FAVOURITES","SETTINGS","HELP","ABOUT"};
    

     for(String s3 : ss)
     {
    	 Thread.sleep(2000);
    	 driver.findElement(By.id("showMenu")).click();
    	 
    	    driver.findElement(By.linkText(s3)).click();
			WebElement wb = driver.findElement(By.id("header-title"));
			String s = wb.getText();
			System.out.println("Page name = "+s);
			
     }
    



	//click on forgot password
	 driver.findElement(By.xpath("//a[@class='forgot-psw link-under']")).click();
	
	driver.findElement(By.id("wage")).sendKeys("sub3@mob.com"); //jithedra.kumar@mobotics.com
	
	driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg'][contains(text(),'OK')]")).click();
	
	driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg'][contains(text(),'HOME')]")).click();
	

    
   //print error msg and home page some functionality 
     driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
	
	
	
	WebElement wee=driver.findElement(By.xpath("//p[contains(text(),'Enter your email here')]"));
	System.out.println(wee.getText());
	
	
	driver.findElement(By.xpath("//a[@class='link-under' and text()='Terms of Use']")).click();
	
	//print page name 
	Thread.sleep(1000);
	WebElement el2 = driver.findElement(By.id("header-title"));
	System.out.println(el2.getText());
	
    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement el4=driver.findElement(By.id("showMenu"));
    wait.until(ExpectedConditions.elementToBeClickable(el4));
    
    el4.click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(), 'Sign in')]")).click();
	
	driver.findElement(By.xpath("//a[@class='link-under' and text()='Privacy Policy']")).click();
	//print page name 
		Thread.sleep(1000);
		WebElement el3 = driver.findElement(By.id("header-title"));
		System.out.println(el3.getText());



     //sign in from fav page 
      
	//driver.findElement(By.id("showMenu")).click();
	
	//click on fav icon in home page 
       driver.findElement(By.className("home-icons")).click();
       //click on skip for now link 
       driver.findElement(By.className("link-under")).click();
       
       driver.findElement(By.className("home-icons")).click();
       
       driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg']")).click();
       
       driver.findElement(By.name("email")).sendKeys("regs18@mob.com");
       driver.findElement(By.name("password")).sendKeys("12345678");
       driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();
       
       //log out 
       //click on Side menu in HambergurMenu
       Thread.sleep(3000);
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
	   //driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and contains(text(), 'Sign in')]")).click();
	    driver.findElement(By.xpath("(//img[@alt='feature-carousel'])[1]")).click();
	    
	    //ok 
	    driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).click();
	    //fav
	    driver.findElement(By.className("fav-img")).click();
	    
	    driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg' and text()='SIGN IN']")).click();
	       
	    driver.findElement(By.name("email")).sendKeys("regs19@mob.com");
	    driver.findElement(By.name("password")).sendKeys("12345678");
	    driver.findElement(By.xpath("//input[@class='grad-btn submit-btn btn']")).click();


        //FAV PAGE 
		//add show to fav page 
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,4500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='alt-poster'])[10]")).click();
		Thread.sleep(2000);
		
		//ok 
	    driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg' and text()='OK'])[1]")).click();
	
	    //fav
	    driver.findElement(By.className("fav-img")).click();
	    
	    Thread.sleep(3000);
 
	    //Add movie to fav page 
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("MOVIES")).click();
	    
	    js.executeScript("window.scrollBy(0,3000)");
	    Thread.sleep(2000);

	     driver.findElement(By.xpath("(//img[@alt='alt-poster'])[4]")).click();
	     //add to fav
         driver.findElement(By.className("fav-img")).click();
	    
	    //Add comedy to fav page 
	    driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("COMEDY")).click();
	    
	    js.executeScript("window.scrollBy(0,3000)");
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//img[@alt='alt-poster'])[5]")).click();
	    
	    //Print the Text
	    Thread.sleep(2000);
	    WebElement wb5= driver.findElement(By.id("header-title"));
		String s2=wb5.getText();
		System.out.println("Printing from Comedy page : "+ s2);
	    
	    //fav
	    driver.findElement(By.className("fav-img")).click();
	    
	    //Navigate to Fav page
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("FAVOURITES")).click();
	    
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[@class='scroll-menu' and text()='MOVIES']")).click();
	    //click on delet buttton 
	    driver.findElement(By.id("delete-ico")).click();
	    //tick
	    
	    WebElement el10 = driver.findElement(By.xpath("//input[@class='del-check fav-del-check']"));
	    wait.until(ExpectedConditions.elementToBeClickable(el10));
	    el10.click();
	    //CLEAR SELECTED 
	    driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg' and text()='CLEAR SELECTED']")).click();
	   
	   driver.findElement(By.xpath("//p[@class='link-under' and text()='NO']")).click();
	   //CLEAR SELECTED 
	   driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg' and text()='CLEAR SELECTED']")).click();
	   //YES
	   driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg' and text()='YES']")).click();
	    
	   //show page
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("(//div[@class='mvi-item']/div[@class='mvi-img-sec'])[1]")).click();
	   
	  Thread.sleep(1000);
	  WebElement wb6= driver.findElement(By.id("header-title"));
	  String s1=wb6.getText();
	  System.out.println("Printing fron favourite page : "+s1);
	 
	  if(s1.equals(s2))
	  {
		//remove fav from show section 
		    Thread.sleep(3000);
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
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//img[@class='header-ico header-ico-right'])[3]")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn-grad btn-lg' and text()='CLEAR ALL']")).click();
	  driver.findElement(By.xpath("//button[@class='btn grad-btn btn-lg' and text()='YES']")).click();
	  driver.navigate().refresh();
	  Thread.sleep(3000);
	  WebElement el9=driver.findElement(By.className("empty-msg"));
	  System.out.println(el9.getText());
        
	  //Navigate Movies and Videos Subsection 
	  WebElement el12 = driver.findElement(By.xpath("//a[@class='scroll-menu' and text()='MOVIES']"));
	  Thread.sleep(3000);
	  System.out.println("Sub-section in Fav Page : " + el12.getText());
	  el12.click();
	  
	  WebElement el13 = driver.findElement(By.xpath("//a[@class='scroll-menu' and text()='VIDEOS']"));
	  Thread.sleep(3000);
	  System.out.println("Sub-section in Fav Page : " + el13.getText());	
	  el13.click();
	  

      
         //Seach scenarios
         


 driver.findElement(By.id("search-ico-default")).click();
        WebElement el14 = driver.findElement(By.id("alt-search-input"));
        el14.click();
        el14.sendKeys("kil");
        Thread.sleep(2000);
       Actions action = new Actions(driver); 
        action.sendKeys(Keys.ENTER).build().perform();
        
        Thread.sleep(500);
        List<WebElement> ls = driver.findElements(By.xpath("//div[@class='mvi-data']"));
        int count=0;
        Thread.sleep(500);
        for(WebElement el:ls)
        {
        	count++;
        }
        //System.out.println(count); 
        
        if(count<1)
        {
        	WebElement web1=driver.findElement(By.xpath("//div[@class='v-center-box']"));
        	System.out.println(web1.getText());
        }
        else
        {
        	 System.out.println(count); 
        	 
        	 Thread.sleep(2000);
             WebElement web2=driver.findElement(By.xpath("//a[@class='scroll-menu'and text()='SHOWS']"));
             web2.click();
             System.out.println("From Search Page Section : " + web2.getText());
             
             Thread.sleep(2000);
             WebElement web3=driver.findElement(By.xpath("//a[@class='scroll-menu'and text()='MOVIES']"));
             web3.click();
             System.out.println("From Search Page Section : " + web3.getText());
             
             Thread.sleep(2000);
             WebElement web4=driver.findElement(By.xpath("//a[@class='scroll-menu'and text()='VIDEOS']"));
             web4.click();
             System.out.println("From Search Page Section : " + web4.getText());
             
             driver.findElement(By.xpath("//img[@class='header-ico search-input-elem'][1]")).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//img[@class='header-ico search-input-elem'][1]")).click();
        }
       

            //language

Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("HOME")).click();
	    
	    
	    Thread.sleep(2000);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2700)");
	    
	    Thread.sleep(2000);
	    WebElement elt19=driver.findElement(By.xpath("(//img[@alt='alt-poster'])[41]"));
	    wait.until(ExpectedConditions.elementToBeClickable(elt19));
	    elt19.click();
	    
	    Thread.sleep(2000);
	    WebElement elt20=driver.findElement(By.xpath("(//button[@class='btn grad-btn btn-lg'])[1]"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn grad-btn btn-lg'])[1]")));
	    elt20.click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("lang")).click();
	   
	    System.out.println("List of preffered language : ");
	    List<WebElement> li1=driver.findElements(By.className("alt-list"));
	    for(WebElement we:li1)
		{
	    	System.out.println(we.getText());
	    	Thread.sleep(2000);
		}
	    //System.out.println("Clicking on text: " +  driver.findElement(By.xpath("//*[@id='alt-app']//*[text()='Tamil']")));
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id='alt-app']//*[text()='Telugu']")).click();



             //social 
              
  @Test(priority=18 , enabled=false)
	public void clickOnSocialIcons() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='menu-bread']")).click();
	    driver.findElement(By.linkText("ABOUT")).click();
	    
	    By arr[]={By.xpath("(//img[@class='icons'])[1]"),By.xpath("(//img[@class='icons'])[2]"),By.xpath("(//img[@class='icons'])[3]"),By.xpath("(//img[@class='icons'])[4]"),By.xpath("(//img[@class='icons'])[5]")};
	    
	    for(By d : arr)
	    {	
	    Thread.sleep(5000);
	    driver.findElement(d).click();
	    
	    Thread.sleep(3000);
	    // Store all currently open tabs in tabs
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

	    // Switch newly open Tab
	    driver.switchTo().window(tabs.get(1));
	    
	    Thread.sleep(7000);
	    System.out.println("Printing Page Title : " + driver.getTitle());
	    System.out.println("Printing page URL : " + driver.getCurrentUrl());
	 
	    // Switch to old(Parent) tab.
		driver.switchTo().window(tabs.get(1)).close();
		Thread.sleep(1000);
	    driver.switchTo().window(tabs.get(0));
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    



















//Clear method 
public void clear() throws InterruptedException
	{
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and text()='Clear all devices']")).isDisplayed())
		{
			Thread.sleep(2000);
			wait=new WebDriverWait(driver, 20);
			//driver.findElement(By.xpath("//p[@class='link-under' and text()='CANCEL']")).click();
			System.out.println("Device limit reached!! Clearing all devices....");
			WebElement clr=driver.findElement(By.xpath("//button[@class='btn grad-btn btn-sm' and text()='Clear all devices']"));
			wait.until(ExpectedConditions.elementToBeClickable(clr));
			clr.click();
		}
		else{
			Thread.sleep(2000);
			System.out.println("Device limit not reached, Hence proceeding...");
		}
	}





      /// 
       
    
	    
	    
	  //Locating seekbar using resource id
        WebElement seek_bar=driver.findElement(By.xpath("//div[@class='v-group v-bar']"));
        // get start co-ordinate of seekbar
        int start=seek_bar.getLocation().getX();
        //Get width of seekbar
        int end=seek_bar.getSize().getWidth();
        //get location of seekbar vertically
        int y=seek_bar.getLocation().getY();

        
        // Select till which position you want to move the seekbar
       TouchActions act=new TouchActions(driver);
       
        //Move it will the end
        act.press(start,y).moveTo(end,y).release().perform();

        //Move it 40%
        int moveTo=(int)(end*0.4);
        act.press(start,y).moveTo(moveTo,y).release().perform();
	    















..................all the pages     ..  navigate to sub page and print all tthe details 
//div[@class='table-block']/p[contains(text(),'Current Plan ')]


Thread.sleep(2000);
driver.findElement(By.id("showMenu")).click();

driver.findElement(By.linkText("SUBSCRIPTION")).click();
Thread.sleep(2000);
///p[contains(text(),'Current Plan ')]
WebElement web=driver.findElement(By.xpath("//div[@class='table-block']/p[contains(text(),'Current Plan ')]"));
System.out.println(web.getText());
*/