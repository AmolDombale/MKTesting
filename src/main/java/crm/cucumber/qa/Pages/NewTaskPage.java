package crm.cucumber.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.cucumber.qa.base.TestBase;

public class NewTaskPage extends TestBase {
	
	@FindBy(xpath="//span[@style='color:red;font-weight:bold;']")
	WebElement hashstrickMark;
	
	
	@FindBy(xpath="//select[@name='auto_extend']")
	WebElement Auto_Extend;
	

	
	
	
	
	
	
	
	
	
	
	

	public NewTaskPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

}
