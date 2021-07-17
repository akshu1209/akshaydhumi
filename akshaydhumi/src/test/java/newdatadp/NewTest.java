package newdatadp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
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
	  
	
	 
  @Test(dataProvider = "number of data")
  public void login(String email,String Pass) throws InterruptedException 
  { 
		  System.out.println("In test");
		  Thread.sleep(2000);
	
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

		
		driver.findElement(By.xpath("(//button[@class='btn btn-lg btn-primary modal-btn ajax-submit'])[1]")).click();
		Thread.sleep(1000); 
		String name=driver.findElement(By.xpath("//uL[@class='nav navbar-nav navbar-right margin-right-logo']/li[2]/a")).getText();
		System.out.println(name);
		
		WebElement welcomeUser=driver.findElement(By.xpath("(//span[@class='caret'])[6]"));
		
				Actions action=new Actions (driver);
		action.moveToElement(welcomeUser).build().perform();
		
		Thread.sleep(1000);
		WebElement logout=driver.findElement(By.xpath("(//a[text()=' Log Out'])[2]"));
		logout.click();
	

	//	System.out.println("Outtest");
		
  }

  @DataProvider(name="number of data")
  public Object[][] getDataFromDataProvider()             //dp name change to getDataFromDataProvider
  {
    return new Object[][] {
      { "akshaydhumal.ad95@gmail.com", "@kki1234$" },
      { "akshaydhumal.ad99@gmail.com", "@kki1234$" },
      { "akshaydhumal.ad98@gmail.com", "@kki1234$" },
     
    };
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
	  //driver.close();
  }

}
