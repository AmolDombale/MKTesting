package StepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import crm.cucumber.qa.Pages.HomePage;
import crm.cucumber.qa.Pages.NewContactPage;
import crm.cucumber.qa.Pages.NewDealsPage;
import crm.cucumber.qa.Pages.PageObjectManager;
import crm.cucumber.qa.Pages.ProductPage;
import crm.cucumber.qa.base.TestBase;
import crm.cucumber.qa.util.TestUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps extends TestBase {

	Scenario scn;
	HomePage ObjHomePage;
	NewDealsPage objNewDealsPage= new NewDealsPage(); ;
	NewContactPage objNewContactPage = new NewContactPage(); ;
	TestUtil objTestUtil = new TestUtil();;
	ProductPage objProductPage= new ProductPage();;
	

	public ProductPageSteps() throws IOException {
		super();		 
		 
	}

	@When("click on product link")
	public void click_on_product_link() throws IOException {
		ObjHomePage = new HomePage();
		objTestUtil.frame("mainpanel");
		ObjHomePage.moveToElement(ObjHomePage.Dealslink);
		ObjHomePage.clickonlinks("Products");
	}

	@Then("User enter Product details")
	public void user_enter_product_details(DataTable dataTable) throws IOException {
		objProductPage = new ProductPage();
		
		for (Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
			objProductPage.createNewProduct(data.get("Name"), data.get("Cost"), data.get("Retail_value"),
					data.get("Wholesale"), data.get("Sku"), data.get("Inventory_amount"), data.get("Description"));
			ObjHomePage.moveToElement(ObjHomePage.Dealslink);
			ObjHomePage.clickonlinks("Products");
		}
	}

	@Before
	public void beforeScenario(Scenario s) {
		this.scn = s;
	}

	@After
	public void afterScenario(Scenario s) throws IOException {

		if (s.isFailed()) {
			File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destinationPath = "D://Automation Testing/CucumberProject/Screenshots/dob.png";
			FileUtils.copyFile(SourceFile, new File(destinationPath));

		}
	}

}
