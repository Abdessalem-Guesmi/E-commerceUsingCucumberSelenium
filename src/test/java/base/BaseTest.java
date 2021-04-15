package base;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LoginPage;
import pages.NewCustomPage;
import pages.SearchPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public NewCustomPage newCustomPage;
	public SearchPage searchPage;

	public String generateEmail() {
		String email = RandomStringUtils.randomAlphabetic(6) + "@gmail.com";
		return email;
	}
}
