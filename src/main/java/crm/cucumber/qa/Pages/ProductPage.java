package crm.cucumber.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.cucumber.qa.base.TestBase;

public class ProductPage extends TestBase {
	
	

	@FindBy(xpath="//td//input[@value='New Product']")
	WebElement New_Product;
	
	@FindBy(xpath="//td//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//td//input[@id='cost']")
	WebElement cost;
	
	@FindBy(xpath="//td//input[@id='retail_value']")
	WebElement retail_value;
	
	
	@FindBy(xpath="//td//input[@id='wholesale']")
	WebElement wholesale;
	
	
	@FindBy(xpath="//td//input[@id='sku']")
	WebElement sku;
	
	@FindBy(xpath="//td//input[@id='inventory_amount']")
	WebElement inventory_amount;
	
	@FindBy(xpath="//td//textarea[@name='description']")
	WebElement description;
	
	public ProductPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void createNewProduct(String Name,String Cost,
			String Retail_value,String Wholesale,String Sku,
			String Inventory_amount,String Description){
		New_Product.click();
		name.sendKeys(Name);
		cost.clear();
		cost.sendKeys(Cost);
		retail_value.clear();
		retail_value.sendKeys(Retail_value);
		wholesale.clear();
		wholesale.sendKeys(Wholesale);
		sku.sendKeys(Sku);
		inventory_amount.clear();
		inventory_amount.sendKeys(Inventory_amount);
		description.sendKeys(Description);
		
	}
	
	

}
