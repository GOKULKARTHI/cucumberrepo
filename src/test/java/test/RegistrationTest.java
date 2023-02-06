package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountSuccessPage;
import pageobjects.LandingPage;
import pageobjects.RegistrationPage;
import resource.Base;

public class RegistrationTest extends Base {
	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void browserLaunch() throws IOException {

		log = LogManager.getLogger(RegistrationTest.class.getName());

		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test
	public void register() throws InterruptedException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		landingPage.registrationPage().click();

		RegistrationPage registrationPage = new RegistrationPage(driver);

		Assert.assertTrue(registrationPage.register().isDisplayed());
		log.info("Navigated to registration page");

		String firstName = prop.getProperty("firstName");
		String lastName = prop.getProperty("lastName");
		String email = prop.getProperty("email");
		String pssword = prop.getProperty("pssword");
		String telephone = prop.getProperty("telephone");

		registrationPage.enterFirstName().sendKeys(firstName);
		log.debug("First name got entered");
		registrationPage.enterLastName().sendKeys(lastName);
		log.debug("Last name got entered");
		registrationPage.enterEmail().sendKeys(email);
		log.debug("Email address got entered");
		registrationPage.enterTelephone().sendKeys(telephone);
		log.debug("Telephone number got entered");
		registrationPage.enterPassword().sendKeys(pssword);
		log.debug("Password got entered");
		registrationPage.enterConformPassword().sendKeys(pssword);
		log.debug("Conform Password got entered");
		registrationPage.clickYesRadioButton().click();
		log.debug("Clicked on Yes Radio button");
		registrationPage.clickNoRadioButton().click();
		log.debug("Clicked on No Radio button");
		registrationPage.clickTermAndConditionCheckBox().click();
		log.debug("Clicked on Terms&Condition checkBox");
		registrationPage.clickContinuebutton().click();
		log.debug("Clicked on register button");
		Thread.sleep(3000);

		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);

		Assert.assertEquals(accountSuccessPage.retrievePageHeading(), "Your Account Has Been Created!");
		log.info("User Account got created sucessfully");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.debug("Browser got closed");
	}

}
