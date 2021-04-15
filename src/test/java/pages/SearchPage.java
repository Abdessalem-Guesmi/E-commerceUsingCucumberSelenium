package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	private WebDriver driver;
	WebElement item;
	List<WebElement> cols;
	List<WebElement> rows;
	private By emailField = By.id("SearchEmail");
	private By searchBtn = By.id("search-customers");
	private By table = By.xpath("//table[@id='customers-grid']");
	private By fnameField = By.id("SearchFirstName");
	private By lnameField = By.id("SearchLastName");

	public SearchPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void setEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void clickOnSearch() {
		driver.findElement(searchBtn).click();
	}

	public int getRowsNbr() {
		item = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody"));
		rows = item.findElements(By.tagName("tr"));
		return rows.size();
	}

	public int getColNbr() {
		item = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr"));
		cols = item.findElements(By.tagName("td"));
		return cols.size();

	}

	public void setFname(String fname) {
		driver.findElement(fnameField).sendKeys(fname);
	}

	public void setLname(String lname) {
		driver.findElement(lnameField).sendKeys(lname);
	}

	public boolean getOnSearchCustomerByEmail(String email) {
		boolean status = false;
		for (int i = 1; i <= rows.size(); i++) {
			String addrEmails = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(addrEmails);
			if (addrEmails.equals(email))
				status = true;
		}
		return status;
	}

	public boolean getOnSearchCustomerByName(String name) {
		boolean status = false;
		for (int i = 1; i <= rows.size(); i++) {
			String fname = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"))
					.getText();
			String names[] = fname.split(" ");
			if (names[0].equals("James") && names[1].equals("Pan"))
				status = true;
		}
		return status;

	}
}
