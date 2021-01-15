package pages;

import config.AutomationProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountHomePage {

    private WebDriver webDriver;

    @FindBy(how = How.CSS, using = "div[data-control-name=identity_welcome_message]")
    private WebElement userProfile;

    @FindBy(how = How.XPATH, using = "/html/body/div[7]/aside/div[1]/header/section[2]/button[1]")
    private WebElement createNewMessage;

    @FindBy(how = How.CLASS_NAME, using = "msg-connections-typeahead__top-fixed-section")
    private WebElement newMessageWindow;

    @FindBy(how = How.CSS, using = ".msg-connections-typeahead__top-fixed-section>div>input")
    private WebElement searchContact;

    @FindBy(how = How.CLASS_NAME, using = "list-style-none")
    private WebElement searchResultList;

    @FindBy(how = How.XPATH, using = "/html/body/div[7]/aside/div[2]/div[1]/div[1]/div/ul/li/div/button")
    private WebElement searchResultSelectionValue;

    @FindBy(how = How.CLASS_NAME, using = "artdeco-pill__text")
    private WebElement selectedSearchResult;

    @FindBy(how = How.CSS, using = "a[data-control-name=view_profile]")
    private WebElement selectedContact;

    @FindBy(how = How.CSS, using = "div.msg-form__contenteditable > p")
    private WebElement messagebox;

    @FindBy(how = How.CSS, using = "button[type=submit]")
    private WebElement sendMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"primary-navigation\"]/ul/li[6]")
    private WebElement profileSettings;

    @FindBy(how = How.XPATH, using = "//*[text()='Sign Out']")
    private WebElement signOut;

    public AccountHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void verifyUserProfile(String user) throws Exception {
        userProfile.getText().equals(user);
    }

    public void clickCreateNewMessage() throws Exception {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationProperties.getWaitTimeOut());
        createNewMessage.click();
        wait.until(ExpectedConditions.visibilityOf(newMessageWindow));
    }

    public void searchForContact(String contactName) throws Exception {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationProperties.getWaitTimeOut());
        searchContact.sendKeys(contactName);
        wait.until(ExpectedConditions.visibilityOf(searchResultSelectionValue));
    }

    public void selectContact() throws Exception {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationProperties.getWaitTimeOut());
        wait.until(ExpectedConditions.elementToBeClickable(searchResultSelectionValue));
        searchResultSelectionValue.click();
        wait.until(ExpectedConditions.visibilityOf(selectedContact));

    }

    public void verifyContactInChat(String contactName) throws Exception {
        ((JavascriptExecutor) this.webDriver).executeScript("arguments[0].scrollIntoView(true);", selectedContact);
        Thread.sleep(500);
        selectedContact.getText().equals(contactName);
    }

    public void composeMessage(String message) throws Exception {
        messagebox.sendKeys(message);
    }

    public void sendMessage() throws Exception {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationProperties.getWaitTimeOut());
        wait.until(ExpectedConditions.elementToBeClickable(sendMessage));
        sendMessage.click();
    }

    public LoginPage signOut() throws Exception {
        WebDriverWait wait = new WebDriverWait(webDriver, AutomationProperties.getWaitTimeOut());
        profileSettings.click();
        wait.until(ExpectedConditions.visibilityOf(signOut));
        signOut.click();
        return new LoginPage(webDriver);

    }
}
