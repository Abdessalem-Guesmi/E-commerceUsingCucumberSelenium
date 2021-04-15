package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By emailFiled = By.id("Email");
	private By passwordField = By.id("Password");
	private By loginButton = By.xpath("//button[@type='submit']");
	private By remeberCheck = By.id("RememberMe");

	public void setEmail(String email) {
		driver.findElement(emailFiled).clear();
		driver.findElement(emailFiled).sendKeys(email);
	}

	public void setPassword(String password) {

		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
		;
	}

	public void clickOnCheckRemember() {
		driver.findElement(remeberCheck).click();
	}

	public HomePage clickOnLogin() {
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}

}
