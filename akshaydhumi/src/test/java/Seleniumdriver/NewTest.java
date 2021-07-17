package Seleniumdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;



public class NewTest {
	
	WebDriver driver;
	
	@BeforeSuite
	  public void Open_Browser()
	{
		System.out.println("In open browser method under Before Suite");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\akii java\\17 may\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		System.out.println("Crome Browser is open successfully");
	  }
	
	// please dont do such mistakes try code find exception while doing , this is very basic plz take care of this thing we need to join company ASAP, i think you are not doing good practice
	// okay bro

	  @BeforeTest
	  public void Enter_URL() {
		  System.out.println("In enterApplication Method under BeforeTest");
		  driver.get("https://www.mercurytravels.co.in");
		  System.out.println("Application url Has Enter Successffully");
		  
	  }
	  
	  
	  
	  @BeforeClass
	  public void Maximize_URL() {
		  System.out.println("In maximizeBroser Method under BeforeClass");
		  driver.manage().window().maximize();
		  System.out.println("Chrome Browser Is Maximized  Successffully");
		  
		  
	  }
	  
	  
	  
	  
	  @BeforeMethod
	  public void getCookies() {
		  
		  System.out.println("In getCookies Method under Beforemethod");
		  Set<Cookie> cookies=driver.manage().getCookies();
		  for(Cookie cookie:cookies)
		  {
			  System.out.println(cookie.getName());
		  }
	  
	  }
	  @Parameters({"EMAIL_ID","Password"})
	 
	 @Test
	           
	  public void login(String email,String Pass) throws InterruptedException 
	  { 
			  System.out.println("In test");
			  Thread.sleep(2000);
		/*	  Actions a=new Actions(driver);
			  a.moveToElement(driver.findElement(By.xpath("//html/body/nav[2]/div/div[2]/ul/li[1]/a"))).build().perform();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//a[contains(text(),'User Login')] )[2]")).click();
			  Thread.sleep(2000); */
			  
		 //akshaydhumal.ad95@gmail.com
			  
			  //@kki1234$
			  driver.findElement(By.xpath("(//span[@class='caret'])[4]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//a[@data-toggle='modal'])[3]")).click();
				Thread.sleep(3000);
			driver.findElement(By.id("sign_user_email")).sendKeys(email);
			Thread.sleep(3000);
			driver.findElement(By.id("sign_user_password")).sendKeys(Pass);
			Thread.sleep(3000); 

			/*driver.findElement(By.xpath("(//span[@class='caret'])[4]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@data-toggle='modal'])[3]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("email") ;
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//input[@id='sign_user_password']")).sendKeys("Pass");
			Thread.sleep(3000); */
			
			driver.findElement(By.xpath("(//button[@class='btn btn-lg btn-primary modal-btn ajax-submit'])[1]")).click();
			System.out.println("Outtest");
			
	  }
	  
  @AfterMethod
  public void Take_SS() throws IOException
  {
	  System.out.println("CaptureScreenshot under AfterMethod");
	  File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyDirectory(src, new File("C:\\Users\\Admin\\eclipse-workspace\\akshaydhumi\\src\\test\\resources\\SS"));
	  
  }

 

  @AfterClass
  public void deleteallcookies()
  {
	  System.out.println("In dbConnectionclosed method under Aftetest");
	  driver.manage().deleteAllCookies();
  }


  @AfterTest
  public void afterTest() 
  {
	  System.out.println("In dbConnectionclosed method under Aftetest");
  }

  

  @AfterSuite
  public void afterSuite()
{ 
	  System.out.println("In Close Browser  method under Aftesuite");
	  driver.close();
  }

}
