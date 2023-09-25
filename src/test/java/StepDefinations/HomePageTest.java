package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import crm.cucumber.qa.Pages.HomePage;
import crm.cucumber.qa.Pages.LoginPage;
import crm.cucumber.qa.base.TestBase;
import crm.cucumber.qa.util.TestUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest extends TestBase {
	
	LoginPage ObjLoginPage;
	HomePage  ObjHomePage =new HomePage();
	TestUtil objTestUtil=new TestUtil();
	public HomePageTest() throws IOException {
		super();
	}
	
	
	
	@When("Given Login to application")
	public void given_login_to_application() throws IOException {
		initialization();
		ObjLoginPage=new LoginPage();
		ObjHomePage=ObjLoginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Then("User is able to see Home Tab")
	public void user_is_able_to_see_home_tab() {
		objTestUtil.frame("mainpanel");
		ObjHomePage.verifyTabOnHonePage("Home");
	}
	
	public WebElement findElement(By by) {
		WebElement elem=driver.findElement(by);
		if(driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("argument[0].style.border='3px solid red'", elem);
		}
		return elem;
	}
	
}
