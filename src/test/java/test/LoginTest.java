package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resource.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Logger log;
	@BeforeMethod
	public void browserLaunch() throws IOException {
		
       log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test(dataProvider="getLoginData")
	public void login(String username,String password,String expectedResult){


		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		log.debug("Clicked on DropDown option");
		landingPage.loginPage().click();
		log.debug("Clicked on Login option");
		

		/*String username = prop.getProperty("username");
		String password = prop.getProperty("password");*/

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(username);
		log.debug("Username got entered");
		loginPage.passwordfield().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login button");

		AccountPage accountPage = new AccountPage(driver);
		
		String actualResult = null;
		try {
			  
			if (accountPage.editAccontInformation().isDisplayed() ) {
				
				actualResult = "Success";
				log.debug("User got logged in");
			}
			
		} catch (Exception e) {
			
			actualResult = "Failure";
			log.debug("User didn't logged in");
		
		}
		Assert.assertEquals(actualResult,expectedResult);
		log.info("Login Test got Passed");

	}

	@AfterMethod
	public void closure() {
		driver.quit();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"gokulkarthickmech1994@gmail.com","gokul@123","Success"},{"arun.selenium@gmail.com","arun@12334","Failure"}};
		return data;
	}
}
