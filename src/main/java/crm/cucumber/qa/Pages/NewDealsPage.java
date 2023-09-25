package crm.cucumber.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crm.cucumber.qa.base.TestBase;

public class NewDealsPage extends TestBase {
	

	@FindBy(xpath="//input[@id='title']")
	public
	WebElement Newtitle;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	public WebElement Newcompany;
	
	@FindBy(xpath="//input[@name='contact_lookup']")
	public WebElement NewprimaryContact;
	
	@FindBy(xpath="//input[@name='amount']")
	public WebElement Newamount;
	
	@FindBy(xpath="//input[@name='probability']")
	public WebElement Newprobability;
	
	@FindBy(xpath="//input[@name='commission']")
	public WebElement Newcommission;
	
	@FindBy(xpath="//input[@name='identifier']")
	public WebElement Newidentifier;
	
	@FindBy(xpath="//input[@name='quantity']")
	public WebElement Newquantity;
	
	@FindBy(xpath="//select[@name='type']")
	public WebElement TypeDropDown;
	
	@FindBy(xpath="//select[@name='source']")
	
	public WebElement SourceDropDown;
	
	
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	public WebElement SaveButton;
	
	public NewDealsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void SelectOptionFromDropDown(WebElement element,String title) {
		Select select=new Select(element);
		select.selectByValue(title);
	}
	
	public void CreateNewDeal(String title,String company,String primaryContact,String amount,String quantity) {
		Newtitle.sendKeys(title);
		Newcompany.sendKeys(company);
		NewprimaryContact.sendKeys(primaryContact);
		Newamount.sendKeys(amount);
		Newquantity.clear();
		Newquantity.sendKeys(quantity);
		SaveButton.click();
	}

}
