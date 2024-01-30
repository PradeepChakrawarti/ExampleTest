package Group_FP;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extract_1one {

	WebDriver driver;
	ExtentReports report;
	
	public void reportTest() {
		 report = new ExtentReports(System.getProperty("user.dir")+"\\Project.html");
//		 report test = report.startTest("Extent report demo");
		  ExtentTest test = report.startTest("Report is ready");
		 
	}
	
	@DataProvider(name="getdata")
	public Object[][] getdata() throws EncryptedDocumentException, IOException{
         
		Provider_1 get = new Provider_1();
		
		Object[][] data = get.getDataFromExcel();
		
		return data;
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SDET 101\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
        driver = new ChromeDriver();
        
        driver.get("https://demo.nopcommerce.com/");
        
        driver.manage().window().maximize();
        
        Thread.sleep(1000);
        
	}
	
	@Test(dataProvider = "getdata")
	public void regirstration(String name,String last,String email,String compnyName,String pass,String confirmPass) throws InterruptedException {
		
		driver.findElement(By.className("ico-register")).click();
		Thread.sleep(1000);
		
		WebElement firstName = driver.findElement(By.id("FirstName"));
		Thread.sleep(1000);
		WebElement lastName = driver.findElement(By.id("LastName"));
		Thread.sleep(1000);

		WebElement Email = driver.findElement(By.id("Email"));
		Thread.sleep(1000);
		WebElement C_Name = driver.findElement(By.id("Company"));
		Thread.sleep(1000);

		WebElement password = driver.findElement(By.xpath("//input[@type='password'][1]"));
		Thread.sleep(1000);
		WebElement confPass = driver.findElement(By.id("ConfirmPassword"));
		Thread.sleep(1000);
	    WebElement rntn = driver.findElement(By.id("register-button"));
		
	    firstName.sendKeys(name);
	    lastName.sendKeys(last);
	    
	    Email.sendKeys(email);
	    firstName.sendKeys(compnyName);
	    
	    password.sendKeys(pass);
	    confPass.sendKeys(confirmPass);
	}
	
		
	@AfterMethod
	public void tearUp() {
		
		driver.close();
		
	}
}
