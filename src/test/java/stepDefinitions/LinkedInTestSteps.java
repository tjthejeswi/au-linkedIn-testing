package stepDefinitions;

import config.AutomationProperties;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AccountHomePage;
import pages.LoginPage;

import java.util.logging.Level;
import java.util.logging.Logger;


public class LinkedInTestSteps {

	// profileName is the Full Name of the person that has logged In
	private String profileName;
	// contactName is the Full Name of the person that the message is being sent to
	private String contactName;

	private WebDriver webDriver;

	private LoginPage loginPage;
	private AccountHomePage accountHomePage;
	private AutomationProperties automationProperties;

	private static Logger logger = Logger.getLogger(LinkedInTestSteps.class.getName());

	@Given("^the user is on linkedin login page$")
	public void visitLinkedIn() throws Exception {
		webDriver = null;
		System.setProperty("Webdriver.chrome.driver", AutomationProperties.getDriverLocation());
		ChromeOptions options = new ChromeOptions();
		webDriver = new ChromeDriver(options);
		logger.log(Level.INFO, "Chrome driver is created");

		webDriver.manage().window().maximize();
		loginPage = new LoginPage(webDriver);
		loginPage.visitLinkedInPage();
	}
	
	@When("^the user logs in with valid credentials$")
	public void userLogin()  throws Exception {
	loginPage.enterUsername(AutomationProperties.getLinkedInUsername());
	loginPage.enterPassword(AutomationProperties.getLinkedInPassword());
	accountHomePage = loginPage.clickSignInButton();
	}

	@Then("^the linkedIn user lands on their account home page$")
	public void verifyLoginStatus()  throws Exception {
		profileName = AutomationProperties.getLinkedInProfileFullName();
		accountHomePage.verifyUserProfile(profileName);
	}

	@When("^the user creates a new message$")
	public void createNewMessage() throws Exception {
		accountHomePage.clickCreateNewMessage();
	}
	
	@And("^the user selects the contact \"([^\"]*)\" to send message to$")
	public void selectContact(String contact)  throws Exception {

		accountHomePage.searchForContact(contact);
		accountHomePage.selectContact();
		accountHomePage.verifyContactInChat(contact);
	}
	
	@And("^the user sends the message \"([^\"]*)\"$")
	public void sendMessage(String message)  throws Exception {
		accountHomePage.composeMessage(message.replace("{profile name}", AutomationProperties.getLinkedInProfileFullName()));
		accountHomePage.sendMessage();
		accountHomePage.verifyContactInChat(profileName);
	}

	@Then("^the user logs out$")
	public void logOut() throws Exception {
		Thread.sleep(3000);
		accountHomePage.signOut();
	}

}
