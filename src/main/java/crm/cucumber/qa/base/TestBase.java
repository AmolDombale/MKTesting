package crm.cucumber.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import crm.cucumber.qa.util.TestUtil;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {
		prop = new Properties();
		String filepath = "D:\\Automation Testing\\CucumberProject\\src\\main\\java\\crm\\cucumber\\qa\\config\\config.properties";
		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Automation Testing\\FreeCRM.com\\drivers\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver","D:\\Automation Testing\\testng.com\\drivers\\chromedriver.exe");
			
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	public String takeScreenShot(String testName,WebDriver driver) throws IOException {
		File SourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath=System.getProperty("user.dir")+"\\screenshot\\screenshot"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationPath));
		return destinationPath;

	}

}

