package crm.cucumber.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crm.cucumber.qa.base.TestBase;

public class NewContactPage extends TestBase {

	@FindBy(xpath="Contactslink")
	WebElement contactlabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement selectDropDrown;
	
	@FindBy(id="first_name")
	WebElement UserFirstName;	
	
	@FindBy(id="middle_initial")
	WebElement middleName;	
	
	@FindBy(id="surname")
	WebElement surname;	
	
	@FindBy(xpath="//select[@name='suffix']")
	WebElement suffix;
	
	@FindBy(name="nickname")
	WebElement nickname;
	
	@FindBy(name="client_lookup")
	WebElement Clientlookup;	
	
	
	
	@FindBy(name="company_position")
	WebElement companyposition; 
	
	@FindBy(name="department")
	WebElement department;
	
	@FindBy(name="contact_lookup_sup")
	WebElement superviser; 
	
	@FindBy(name="contact_lookup_ass")
	WebElement assistant; 
	
	@FindBy(name="contact_lookup_ref")
	WebElement ReferredBy; 
	
	@FindBy(xpath="//select[@name='category']")
	WebElement category;
	
	@FindBy(xpath="//select[@name='status']")
	WebElement status; 
	
	@FindBy(name="phone")
	WebElement phone; 
	
	@FindBy(name="mobile")
	WebElement mobile; 
	
	@FindBy(name="home_phone")
	WebElement home_phone; 
	
	@FindBy(name="fax")
	WebElement fax;
	
	@FindBy(name="email")
	WebElement email; 
	
	@FindBy(name="im_id")
	WebElement im_id; 
	
	@FindBy(xpath="//select[@name='im_netowrk']")
	WebElement netowrk; 
	
	@FindBy(name="skype_id")
	WebElement skype_id; 
	
	@FindBy(xpath="//select[@name='source']")
	WebElement source;
	
	@FindBy(name="identifier")
	WebElement identifier;	
	
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
	public NewContactPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	public void SelectOptionFromDropDown(WebElement element,String title) {
		Select select=new Select(element);
		select.selectByValue(title);
	}
	
	public void createNewContatct(String title,String FirstName,
			String MiddleName,String LastName,String suffx,
			String nicname, String Company,
			String position,String deprtment,String superser,
			String asstant,String referBy,String catgory,
			String satus,String pone,String mobilePhone,
			String homephone,String fx,
			String emal,String imid,String network,
			String skypeid,String sorce,String idenfier) 
	
	{
		SelectOptionFromDropDown(selectDropDrown,title);
		UserFirstName.sendKeys(FirstName);
		middleName.sendKeys(MiddleName);
		surname.sendKeys(LastName);
		SelectOptionFromDropDown(suffix,suffx);	
		nickname.sendKeys(nicname);
		Clientlookup.sendKeys(Company);	
		companyposition.sendKeys(position);
		department.sendKeys(deprtment);
		superviser.sendKeys(superser);
		assistant.sendKeys(asstant);
		ReferredBy.sendKeys(referBy);
		SelectOptionFromDropDown(category,catgory);		
		SelectOptionFromDropDown(status,satus);
		phone.sendKeys(pone);
		mobile.sendKeys(mobilePhone);
		home_phone.sendKeys(homephone);
		fax.sendKeys(fx);
		email.sendKeys(emal);
		im_id.sendKeys(imid);
		SelectOptionFromDropDown(netowrk,network);
		skype_id.sendKeys(skypeid);
		SelectOptionFromDropDown(source,sorce);
		identifier.sendKeys(idenfier);		
		saveButton.click();
	}
	
	public void createNewContact1(String title,String FirstName,String MiddleName,String LastName,String suffx,String Company) {
		SelectOptionFromDropDown(selectDropDrown,title);
		UserFirstName.sendKeys(FirstName);
		middleName.sendKeys(MiddleName);
		surname.sendKeys(LastName);
		SelectOptionFromDropDown(suffix,suffx);
		
		
		Clientlookup.sendKeys(Company);
		saveButton.click();
	}
	public By UserSelectionLocator(String name) {
		By locator=By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']");
	return locator;
	
	}
	
	public void selectContact(String name) {
		driver.findElement(UserSelectionLocator(name)).click();
	}
	

}
