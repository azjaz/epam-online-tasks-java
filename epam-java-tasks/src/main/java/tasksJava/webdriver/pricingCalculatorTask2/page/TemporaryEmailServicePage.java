package tasksJava.webdriver.pricingCalculatorTask2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TemporaryEmailServicePage {
    private final String EMAIL_CREATOR_PAGE = "https://10minutemail.com";
    private final int DRIVER_TIMEOUT = 50;
    private WebDriver driver;
    List<String> openedTabs;

    @FindBy(xpath = "//iframe[contains(@src,'cloudpricingcalculator')]")
    private WebElement googleFrame;

    @FindBy(xpath = "//button[contains(@aria-label,'Send') and contains(., 'Email')]")
    WebElement sendEmailButton;

    @FindBy(xpath = "//div[@class='mail-address']/input[@id='mailAddress']")
    private WebElement emailAddress;

    @FindBy(xpath = "//h3[@id='ui-id-1']")
    WebElement messageList;

    @FindBy(xpath = "//div[@id='Email']//table[@class='table']//h2")
    private WebElement totalCostInLetter;

    public TemporaryEmailServicePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TemporaryEmailServicePage fillEmailField() {
        ((JavascriptExecutor) driver).executeScript(String.format("window.open('%s');", EMAIL_CREATOR_PAGE));
        openedTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openedTabs.get(1));
        new WebDriverWait(driver, DRIVER_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(emailAddress));
        String emailToPaste = emailAddress.getAttribute("value");

        driver.switchTo().window(openedTabs.get(0));

        driver.switchTo().frame(googleFrame);
        driver.findElement(By.xpath("//form[@name='emailForm']//input[@type='email']"))
                .sendKeys(emailToPaste);
        driver.switchTo().defaultContent();
        return this;
    }
    public TemporaryEmailServicePage pressSendEmailButton() {
        driver.switchTo().frame(googleFrame);
        new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", sendEmailButton);
        driver.switchTo().defaultContent();
        return this;

    }

    public TemporaryEmailServicePage spinMessageList() {
        driver.switchTo().window(openedTabs.get(1));
        new WebDriverWait(driver, DRIVER_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(messageList));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", messageList);
        return this;
    }

    public String[] getTotalCostFromTheLetter() {
        String costFromEmail = new WebDriverWait(driver, DRIVER_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(totalCostInLetter))
                .getText();

        return costFromEmail.split(" ");
    }
}
