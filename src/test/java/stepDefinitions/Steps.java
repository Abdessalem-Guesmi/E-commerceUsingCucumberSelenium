package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.SearchPage;

public class Steps extends BaseTest {

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		// System.out.println("open browser");
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		System.out.println(url);
		driver.get(url);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		System.out.println(email + "  " + password);
		loginPage = new LoginPage(driver);
		loginPage.setEmail(email);
		loginPage.setPassword(password);
	}

	@When("click on Login")
	public void click_on_login() {
		loginPage.clickOnCheckRemember();
		homePage = loginPage.clickOnLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			assertTrue(false);
		} else
			assertEquals(title, driver.getTitle());
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		homePage.clickOnLogout();

	}

	@Then("Then page title should be {string}")
	public void then_page_title_should_be(String title) {
		assertEquals(title, driver.getTitle());
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	@Then("User can see Dashboard")
	public void user_can_see_dashboard() {
		String title = homePage.getTitle();
		assertTrue(title.contains("Dashboard"));
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
		homePage.clickOnCustomerMenu();

	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		homePage.clickOnCustomerItem();

	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		newCustomPage = homePage.clickOnNewCustomer();
		String title = driver.getTitle();
		assertTrue(title.contains("Add a new customer"));

	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		newCustomPage.setEmail(generateEmail());
		newCustomPage.setPassword("pass1");
		newCustomPage.setFname("abdou");
		newCustomPage.setLname("Guesmi");
		newCustomPage.setGender("Male");
		newCustomPage.setBirthday("8/5/1983");
		newCustomPage.setCompany("N/O");
		newCustomPage.clickOnTax();
		newCustomPage.setNewLetter("test");
		// newCustomPage.setNewLetter("Store");
		newCustomPage.setRoles("Vendor");
		newCustomPage.setComment("thanks");
		newCustomPage.setManagerOnVendor("1");
		Thread.sleep(5000);

	}

	@When("click on save")
	public void click_on_save() {
		newCustomPage.clickOnSave();
	}

	@Then("user can see confirmation message {string}")
	public void user_can_see_confirmation_message(String message) {
		String content = driver.getPageSource();
		assertTrue(content.contains(message));

	}

	@When("enter customer email")
	public void enter_customer_email() {
		searchPage = new SearchPage(driver);
		System.out.println(searchPage.getRowsNbr());
		System.out.println(searchPage.getColNbr());
		searchPage.setEmail("ZltQnQ@gmail.com");
	}

	@When("click on search button")
	public void click_on_search_button() {
		searchPage.clickOnSearch();

	}

	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean emailFound = searchPage.getOnSearchCustomerByEmail("ZltQnQ@gmail.com");
		assertEquals(true, emailFound);

	}

	@When("enter customer fname")
	public void enter_customer_fname() {
		searchPage = new SearchPage(driver);
		searchPage.setFname("James");

	}

	@When("enter customer lname")
	public void enter_customer_lname() {
		searchPage.setLname("Pan");
	}

	@Then("user should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		boolean searchByname = searchPage.getOnSearchCustomerByName("James");
		assertEquals(true, searchByname);

	}

}
