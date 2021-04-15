package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewCustomPage {
	private WebDriver driver;
	WebElement item;
	JavascriptExecutor js;
	private By emailField = By.id("Email");
	private By passwordField = By.id("Password");
	private By fnameField = By.id("FirstName");
	private By lnameField = By.id("LastName");
	private By genderM = By.id("Gender_Male");
	private By genderF = By.id("Gender_Female");
	private By dob = By.id("DateOfBirth");
	private By companyField = By.id("Company");
	private By isTaxEmpt = By.id("IsTaxExempt");
	private By newLetterItem = By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable']");
	private By newsLetterMyStor = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	private By newsLetterTest = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	private By listCustomerRolesReg = By.xpath("//li[contains (text(), 'Registered')]");
	private By listCustomerRolesModer = By.xpath("//li[contains (text(), 'Forum Moderators')]");
	private By listCustomerRolesA = By.xpath("//li[contains (text(), 'Administrators')]");
	private By listCustomerRolesG = By.xpath("//li[contains (text(), 'Guestes')]");
	private By listCustomerRolesV = By.xpath("//li[contains (text(), 'Vendors')]");
	private By vendorItems = By.xpath("//*[@id='VendorId']");

	private By commentField = By.id("AdminComment");
	private By savebtn = By.name("save");

	public NewCustomPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void setEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void setFname(String fname) {
		driver.findElement(fnameField).sendKeys(fname);

	}

	public void setLname(String lname) {
		driver.findElement(lnameField).sendKeys(lname);

	}

	public void setGender(String gndr) {
		if (gndr.equals("Male"))
			driver.findElement(genderM).click();

		else if (gndr.equals("Female"))
			driver.findElement(genderF).click();
		else
			driver.findElement(genderM).click();
	}

	public void setBirthday(String dob_) {
		driver.findElement(dob).sendKeys(dob_);

	}

	public void setCompany(String comp) {
		driver.findElement(companyField).sendKeys(comp);
	}

	public void clickOnTax() {
		driver.findElement(isTaxEmpt).click();
	}

	public void setNewLetter(String letter) {
		driver.findElement(newLetterItem).click();

		if (letter.equals("test"))
			item = driver.findElement(newsLetterMyStor);
		else if (letter.equals("Store"))
			item = driver.findElement(newsLetterTest);
		// else
		// driver.findElement(newsLetterMyStor).click();
		// item.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", item);
		js.executeScript("window.scrollBy(700,document.body.scrollHeight)");

	}

	public void setRoles(String role) {
		// driver.findElement(listCustomer).click();
		// driver.findElement(listCustomerRoles).clear();
		if (role.equals("Administrator"))
			item = driver.findElement(listCustomerRolesA);
		else if (role.equals("Guestes"))
			item = driver.findElement(listCustomerRolesG);
		else if (role.equals("Vendor"))
			item = driver.findElement(listCustomerRolesV);
		else if (role.equals("Moderato"))
			item = driver.findElement(listCustomerRolesModer);
		else if (role.equals("Registered"))
			item = driver.findElement(listCustomerRolesReg);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", item);

	}

	public void setManagerOnVendor(String value) {
		item = driver.findElement(vendorItems);
		Select select = new Select(item);
		select.selectByValue(value);

	}

	public void setComment(String comment) {
		driver.findElement(commentField).sendKeys(comment);
	}

	public void clickOnSave() {
		driver.findElement(savebtn).click();
	}
}
