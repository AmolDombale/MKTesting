package StepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import crm.cucumber.qa.Pages.HomePage;
import crm.cucumber.qa.Pages.LoginPage;
import crm.cucumber.qa.base.TestBase;
import crm.cucumber.qa.util.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageTest extends TestBase{
	LoginPage ObjLoginPage;
	HomePage  ObjHomePage=new HomePage();
	public LoginPageTest() throws IOException {
		super();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException {
		initialization();		
		ObjLoginPage=new LoginPage();
	}

	@When("I enter {string} as username")
	public void i_enter_as_username(String username) {
		ObjLoginPage.enterUserName(prop.getProperty("username"));
	}

	@When("I enter {string} as Password")
	public void i_enter_as_password(String password) {
		ObjLoginPage.enterPassWord(prop.getProperty("password"));
	}

	@Then("I click on login button")
	public void i_click_on_login_button() throws IOException {
		ObjHomePage=ObjLoginPage.ClickOnLoginButton();
	}

	@When("I verify the logo")
	public void i_verify_the_logo() {
	   ObjLoginPage.verifyLogo();
	}
	@When("I verify the links")
	public void i_verify_the_links() {
		ObjLoginPage.verifyLinkOnLoginPage("Sign Up");
		ObjLoginPage.verifyLinkOnLoginPage("Pricing");
		ObjLoginPage.verifyLinkOnLoginPage("Features");
		ObjLoginPage.verifyLinkOnLoginPage("Customers");
		ObjLoginPage.verifyLinkOnLoginPage("Contact");
	}
	
	
	@Given("Browser is open")
	public void browser_is_open() {
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
	}

	@Given("User is on login page1")
	public void user_is_on_login_page1() {
		driver.get(prop.getProperty("url"));
	}

	@When("User click on login")
	public void user_click_on_login() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("user is navigate to home page")
	public void user_is_navigate_to_home_page() {
	    
	}
	@Given("User is login to application")
	public void user_is_login_to_application() throws IOException {
		initialization();		
		ObjLoginPage=new LoginPage();
		ObjHomePage=ObjLoginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
	}





}
