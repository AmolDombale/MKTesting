package crm.cucumber.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import crm.cucumber.qa.base.TestBase;

public class DatePicker extends TestBase {

	public DatePicker() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {

		String expectedMonth = "September, 2026";
		String expectedDay = "20";

		System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\FreeCRM.com\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classic.freecrm.com/index.html");
		findElement(By.name("username")).sendKeys("AmolDombale");
		findElement(By.name("password")).sendKeys("Amol@5793");
		findElement(By.xpath("//*[@value=\"Login\"]")).click();
		driver.switchTo().frame("mainpanel");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Calendar']"))).build().perform();
		findElement(By.xpath("//a[text()='New Event']")).click();
		findElement(By.xpath("(//img[@title='Date selector'])[1]")).click();
		// td[text()='September, 2023']

		// String date = findElement(By.xpath("//td[text()='September,
		// 2023']")).getText();

		while (true)

		{
			Thread.sleep(3000);
			// driver.switchTo().frame("processFrame");

			String date = findElement(By.xpath("//td[contains(text(),'September')]")).getText();

			if (date.equals(expectedMonth)) {
				break;
			} else {

				findElement(By.xpath("(//div[@unselectable='on'])[7]")).click();
				String date1 = findElement(By.xpath("//td[contains(text(),'September')]")).getText();
				System.out.println(date1);
			}
		}
		findElement(By.xpath("//td[contains(text(),'" + expectedDay + "')]")).click();
	}

	public static WebElement findElement(By by) {
		WebElement elem = driver.findElement(by);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		}
		return elem;
	}

}
