package crm.cucumber.qa.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.NewDealPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

import crm.cucumber.qa.base.TestBase;
import io.cucumber.java.en.Given;

public class HomePage extends TestBase {
	
	TestUtil framHandler = new TestUtil();

	// Declerazation

	@FindBy(xpath = "(//td[@align='left'])[1]")
	WebElement userLabel;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homelink;

	// a[contains(text(),'Calendar')]
	@FindBy(xpath = "//a[contains(text(),'Calendar')]")
	WebElement Calendarlink;

	@FindBy(xpath = "//a[contains(text(),'Companies')]")
	WebElement Companieslink;

	@FindBy(xpath = "//a[contains(text(),'Contacts1')]")
	public WebElement Contactslink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	public WebElement Dealslink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement Taskslink;

	@FindBy(xpath = "//a[contains(text(),'Cases')]")
	WebElement Caseslink;

	@FindBy(xpath = "//a[contains(text(),'Call')]")
	WebElement Calllink;

	@FindBy(xpath = "//a[contains(text(),'Email')]")
	WebElement Emaillink;

	@FindBy(xpath = "//a[contains(text(),'Text/SMS')]")
	WebElement TextSMSlink;

	@FindBy(xpath = "//a[contains(text(),'Print')]")
	WebElement Printlink;

	@FindBy(xpath = "//a[contains(text(),'Campaigns')]")
	WebElement Campaignslink;

	@FindBy(xpath = "//a[contains(text(),'Docs')]")
	WebElement Docslink;

	@FindBy(xpath = "//a[contains(text(),'Forms')]")
	WebElement Formslink;

	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement Reportslink;

	@FindBy(xpath = "//ul[@class='mlddm']/li")
	public List<WebElement> links;

	@FindBy(xpath = "//ul[@style='width: 110px; margin-top: 1px; opacity: 1; visibility: visible; filter: none;']/li")
	public List<WebElement> contactElements;
	
	@FindBy(xpath = "//ul[@style='width: 110px; margin-top: 1px; opacity: 0; visibility: hidden; filter: none;']/li")
	public List<WebElement> DealsSubmenu;
	
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement NewNewDeal;

	public HomePage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	public By xpathprovider(String text) {

		By element = By.xpath("//a[contains(text(),'" + text + "')]");

		return element;

	}


	public void clickOnLink(List<WebElement> crmlink, String value) {
		for (WebElement selectrequiredlink : crmlink) {
			if (selectrequiredlink.getText().equals(value)) {
				System.out.println(selectrequiredlink.getText());
				selectrequiredlink.click();
				break;
			}
		}

	}

	public void moveToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public DealsPage clickOnDealsLink() throws IOException {
		Locators("Deals");
		return new DealsPage();
	}

	public ContactPage clickOnContactLink() throws IOException {
		Locators("Contacts");
		return new ContactPage();
	}

	public TaskPage clickOnTskLink() throws IOException {
		Locators("Tasks");
		return new TaskPage();
	}

	public boolean verifyUserName() {
		return userLabel.isDisplayed();
	}

	public boolean verifyContactlink() {
		return Contactslink.isDisplayed();
	}

	public boolean verifyDealslink() {
		return Dealslink.isDisplayed();
	}

	public boolean verifyTaskLink() {
		return Taskslink.isDisplayed();
	}

	public boolean verifyHomeLink() {
		return homelink.isDisplayed();
	}

	public boolean verifyFormsLink() {
		return Formslink.isDisplayed();
	}

	public boolean verifyDocslink() {
		return Docslink.isDisplayed();
	}

	public boolean verifyCampaignslink() {
		return Campaignslink.isDisplayed();
	}

	public boolean verifyPrintlink() {
		return Printlink.isDisplayed();
	}

	public boolean verifyTextSMSlink() {
		return TextSMSlink.isDisplayed();
	}

	public boolean verifyEmaillink() {
		return Emaillink.isDisplayed();
	}

	public boolean verifyCalllink() {
		return Calllink.isDisplayed();
	}

	public boolean verifyCaseslink() {
		return Caseslink.isDisplayed();
	}

	public boolean verifyCalendarlink() {
		return Calendarlink.isDisplayed();
	}

	public boolean verifyCompanieslink() {
		return Companieslink.isDisplayed();
	}

	public boolean verifyReport() {
		return Reportslink.isDisplayed();
	}
	public NewDealPage NewDealForm() throws IOException {
		NewNewDeal.click();		
		return new NewDealPage();
	}
	
	
	public By Locators(String DYNAMIC_TXT) {
		By locator=By.xpath("//a[contains(text(),'"+DYNAMIC_TXT+"')]");
		return locator;
	}
	
	public void verifyTabOnHonePage(String DYNAMIC_TXT) {
		driver.findElement(Locators(DYNAMIC_TXT)).isDisplayed();
	}
	public void clickonlinks(String DYNAMIC_TXT) {
		driver.findElement(Locators(DYNAMIC_TXT)).click();
	}

	
	
	
	
	
}
