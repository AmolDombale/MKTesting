package StepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.pages.NewContactPage;

import crm.cucumber.qa.base.TestBase;
import crm.cucumber.qa.util.TestUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TestTables extends TestBase {
	
	NewContactPage objNewContactPage=new NewContactPage();
	public TestTables() throws IOException {
		super();

	}

	@Given("user enter username and pwd")
	public void user_enter_username_and_pwd(DataTable credentials) {
		List<String> data = credentials.row(0);

		System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\FreeCRM.com\\drivers\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html");

		findElement(By.name("username")).sendKeys(data.get(0));
		findElement(By.name("password")).sendKeys(data.get(1));
		findElement(By.xpath("//input[@value='Login']")).click();
	

	}

	@When("user hover mous on contact")
	public void user_hover_mous_on_contact() {
		driver.switchTo().frame("mainpanel");
		Actions act = new Actions(driver);
		act.moveToElement(findElement(By.xpath("//a[text()='Contacts']"))).build().perform();
	}

	@When("user select new contact")
	public void user_select_new_contact() {
		findElement(By.xpath("//a[text()='New Contact']")).click();
	}

	@When("user fill new conatct form")
	public void user_fill_new_conatct_form(DataTable newformdata) {
		List<String> data = newformdata.row(0);

		Select sect = new Select(findElement(By.xpath("//select[@name='title']")));
		sect.selectByValue(data.get(0));
		findElement(By.id("first_name")).sendKeys(data.get(1));
		findElement(By.id("middle_initial")).sendKeys(data.get(2));
		findElement(By.id("surname")).sendKeys(data.get(3));

		Select suffix = new Select(findElement(By.xpath("//select[@name='suffix']")));

		suffix.selectByValue(data.get(4));

		findElement(By.name("nickname")).sendKeys(data.get(5));
		findElement(By.name("phone")).sendKeys(data.get(6));

		findElement(By.name("email")).sendKeys(data.get(7));
	}

	@When("User clicked on save")
	public void user_clicked_on_save() {
		findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	}
	
	
	public static WebElement findElement(By by) {
		WebElement elem = driver.findElement(by);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		}
		return elem;
	}
	@Given("user enter username1 and pwd1")
	public void user_enter_username1_and_pwd1(DataTable dataTable) {
		List<String> multiplerows = dataTable.values();
		System.out.println(multiplerows.get(0));
	}


}
