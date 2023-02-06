package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	 WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Register")
	private WebElement register;
	public WebElement register() {
		return register;
	}
	@FindBy(id="input-firstname")
	private WebElement enterFirstName;
	
	@FindBy(id="input-lastname")
	private WebElement enterLastName;
	
	@FindBy(id="input-email")
	private WebElement enterEmail;
	
	@FindBy(id="input-telephone")
	private WebElement enterTelephone;
	
	@FindBy(id="input-password")
	private WebElement enterPassword;
	
	@FindBy(id="input-confirm")
	private WebElement enterConformPassword;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	private WebElement clickYesRadioButton;
	
	@FindBy(xpath="//label[normalize-space()='No']")
	private WebElement clickNoRadioButton;
	
	@FindBy(name="agree")
	private WebElement clickTermAndConditionCheckBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement clickContinuebutton;
	
	public WebElement enterFirstName() {
		return enterFirstName;
	}
	public WebElement enterLastName() {
		return enterLastName;
	}
	public WebElement enterEmail() {
		return enterEmail;
	}
	public WebElement enterTelephone() {
		return enterTelephone;
	}
	public WebElement enterPassword() {
	   return enterPassword;
	}
	public WebElement enterConformPassword() {
		return enterConformPassword;
	}
	public WebElement clickYesRadioButton() {
       return clickYesRadioButton;
	}
	public WebElement clickNoRadioButton() {
		return clickNoRadioButton;
	}
	public WebElement clickTermAndConditionCheckBox() {
		return clickTermAndConditionCheckBox;
	}
	public WebElement clickContinuebutton() {
		return clickContinuebutton;
	}
	
	
	
	
	
	
	
	

}
