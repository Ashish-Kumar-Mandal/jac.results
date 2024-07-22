package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Page10th;
import pages.Page12th;

public class BaseScript {
	static WebDriver driver;
	String rollCode;
	String rollNumber;
	String stream;
	
	Page10th jac10;
	Page12th jac12;
	
	@Parameters({"Browser", "url", "rollCode", "rollNumber", "stream"})
	@BeforeClass
	public void setUp(String Browser, String url, String rollCode, String rollNumber, String stream) throws IOException, InterruptedException {	
		this.rollCode = rollCode;
		this.rollNumber = rollNumber;
		this.stream = stream;
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			driver = new ChromeDriver(opt);			
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		
		jac10 = new Page10th(driver);
		jac12 = new Page12th(driver);
				 
//		Thread.sleep(500);
	}
		
	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
	 
}
