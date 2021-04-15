package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class HomePage {
	private WebDriver driver;
	private By logoutbtn = By.xpath("//a[@href='/logout']");
	private By customerMenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	private By customerItem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	private By newCustomerbtn = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPage clickOnLogout() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(logoutbtn);
			}
		});

		element.click();

		return new LoginPage(driver);
	}

	public NewCustomPage clickOnNewCustomer() {

		driver.findElement(newCustomerbtn).click();

		return new NewCustomPage(driver);
	}

	public void clickOnCustomerMenu() {
		driver.findElement(customerMenu).click();

	}

	public void clickOnCustomerItem() {
		driver.findElement(customerItem).click();
	}

	public void clickOnLink(String link) {
		driver.findElement(By.partialLinkText(link));
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
