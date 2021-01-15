package pages;

import config.AutomationProperties;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver webDriver;

	private static String linkedInUrl = "https://www.linkedin.com/login";

	@FindBy(how = How.CLASS_NAME, using = "profile-rail-card__actor-link t-16 t-black t-bold")
	private WebElement profileName;

	@FindBy(how = How.ID, using = "username")
	private WebElement userName;

	@FindBy(how = How.ID, using = "password")
	private WebElement password;

	@FindBy(how = How.CSS, using = "button[type=submit]")
	private WebElement signInButton;

	public LoginPage(WebDriver webDriver){
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void visitLinkedInPage() throws Exception{
		this.webDriver.navigate().to(linkedInUrl);
	}

	public void enterUsername(String usernameVal) throws Exception{
		userName.sendKeys(usernameVal);
	}

	public void enterPassword(String passwordVal) throws Exception{
		password.sendKeys(passwordVal);
	}

	public AccountHomePage clickSignInButton() throws Exception{
		WebDriverWait wait = new WebDriverWait(webDriver, AutomationProperties.getWaitTimeOut());
		signInButton.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[data-control-name=identity_welcome_message]")));
		return new AccountHomePage(webDriver);
	}

	public void verifyLoginButton() throws Exception{
		WebDriverWait wait = new WebDriverWait(webDriver, AutomationProperties.getWaitTimeOut());
		wait.until(ExpectedConditions.visibilityOf(signInButton));
		signInButton.isEnabled();
	}



}
