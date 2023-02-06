package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resource.Base;

public class Login extends Base{
	LoginPage loginPage;
	LandingPage landingPage;
	AccountPage accountPage;
	WebDriver driver;
	@Given("^Open any Browser$")
	public void open_any_browser() throws IOException {
		
		driver = initializeDriver();
	}
	

	@And("^Navigate to Login page$")
	public void navigate_to_login_page(){
		
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		landingPage.loginPage().click();
		
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String username,
			String password) {
		loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(username);
		loginPage.passwordfield().sendKeys(password);
	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() {
		loginPage.loginButton().click();
	}

	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.editAccontInformation().isDisplayed());
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
