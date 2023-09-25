package StepDefinations;

import java.io.IOException;
import java.util.Map;

import crm.cucumber.qa.Pages.HomePage;
import crm.cucumber.qa.Pages.LoginPage;
import crm.cucumber.qa.Pages.NewContactPage;
import crm.cucumber.qa.Pages.NewDealsPage;
import crm.cucumber.qa.base.TestBase;
import crm.cucumber.qa.util.TestUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewDealPageTest extends TestBase {

	
	HomePage ObjHomePage = new HomePage();
	NewDealsPage objNewDealsPage = new NewDealsPage();
	NewContactPage objNewContactPage = new NewContactPage();
	TestUtil objTestUtil = new TestUtil();

	public NewDealPageTest() throws IOException {
		super();
	}

	@When("click on new deal link")
	public void click_on_new_deal_link() {
		objTestUtil.frame("mainpanel");
		ObjHomePage.moveToElement(ObjHomePage.Dealslink);
		ObjHomePage.clickonlinks("New Deal");

	}

	@Then("User enter deals details")
	public void user_enter_deals_details(DataTable dealData) {

		for (Map<String, String> data : dealData.asMaps(String.class, String.class)) {

			objNewDealsPage.Newtitle.sendKeys(data.get("Title"));
			objNewDealsPage.Newcompany.clear();
			objNewDealsPage.Newcompany.sendKeys(data.get("Company"));
			objNewDealsPage.NewprimaryContact.sendKeys(data.get("Primary Contact"));
			objNewDealsPage.Newamount.sendKeys(data.get("Amount"));
			objNewDealsPage.Newprobability.sendKeys(data.get("Probability"));
			objNewDealsPage.Newcommission.sendKeys(data.get("Commission"));
			objNewDealsPage.Newidentifier.sendKeys(data.get("Identifier"));
			objNewDealsPage.Newquantity.clear();
			objNewDealsPage.Newquantity.sendKeys(data.get("Quantity"));
			objNewDealsPage.SelectOptionFromDropDown(objNewDealsPage.TypeDropDown, data.get("Type"));
			objNewDealsPage.SelectOptionFromDropDown(objNewDealsPage.SourceDropDown, data.get("Source"));
			objNewDealsPage.SaveButton.click();
			ObjHomePage.moveToElement(ObjHomePage.Dealslink);
			ObjHomePage.clickonlinks("New Deal");
		}

	}

	@Then("User enters {string} and {string} and {string}")
	public void user_enters_and_and(String Title, String Company, String Primary_Contact) {
		objNewDealsPage.Newtitle.sendKeys(Title);
		objNewDealsPage.Newcompany.clear();
		objNewDealsPage.Newcompany.sendKeys(Company);
		objNewDealsPage.NewprimaryContact.sendKeys(Primary_Contact);
	}

	@Then("User enters {string} and {string} and {string} and {string}")
	public void user_enters_and_and_and(String Amount, String Probability, String Commission, String Identifier) {
		objNewDealsPage.Newamount.sendKeys(Amount);
		objNewDealsPage.Newprobability.sendKeys(Probability);
		objNewDealsPage.Newcommission.sendKeys(Commission);
		objNewDealsPage.Newidentifier.sendKeys(Identifier);

	}

	@Then("User enters {string} and {string} and {string} deals details")
	public void user_enters_and_and_deals_details(String Quantity, String Type, String Source) {
		objNewDealsPage.Newquantity.clear();
		objNewDealsPage.Newquantity.sendKeys(Quantity);
		objNewDealsPage.SelectOptionFromDropDown(objNewDealsPage.TypeDropDown, Type);
		objNewDealsPage.SelectOptionFromDropDown(objNewDealsPage.SourceDropDown, Source);
		objNewDealsPage.SaveButton.click();

	}
	
	

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}

}