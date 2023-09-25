package crm.cucumber.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.cucumber.qa.base.TestBase;



public class LoginPage extends TestBase{

	// Page Factory
	
	// Declerization
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@value=\"Login\"]")
	WebElement loginbutton;
	
	@FindBy(xpath="//*[contains(text(),\"Sign Up\")]") 
	WebElement signupbutton;
	
	@FindBy(xpath="(//*[@class=\"img-responsive\"])[1]") 
	WebElement crmlogo;
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement featurebutton;
	
	@FindBy(xpath="//a[contains(text(),'DYNAMIC_TXT')]")
	WebElement featurebutton1;
	
	public By Locators(String DYNAMIC_TXT) {
		By locator=By.xpath("//a[contains(text(),'"+DYNAMIC_TXT+"')]");
		return locator;
	}
	
	public void verifyLinkOnLoginPage(String DYNAMIC_TXT) {
		driver.findElement(Locators(DYNAMIC_TXT)).isDisplayed();
	}
	

	//Initializing Page Object
	
	public LoginPage()throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	// Action
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public boolean validateCRMlogo() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage loginToApp(String un , String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();		
		return new HomePage();
	}
	
	public void enterUserName(String un) {
		//username.sendKeys(un);
		driver.findElement(By.name("username")).sendKeys(un);
	}
	public void enterPassWord(String pwd) {
		//username.sendKeys(pwd);
		driver.findElement(By.name("password")).sendKeys(pwd);
	}
	public HomePage ClickOnLoginButton() throws IOException {
		//loginbutton.click();
		driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
		return new HomePage();
	}
	
	public void verifyLogo() {
		driver.findElement(By.xpath("(//*[@class=\"img-responsive\"])[1]")).isDisplayed();
	}
}

