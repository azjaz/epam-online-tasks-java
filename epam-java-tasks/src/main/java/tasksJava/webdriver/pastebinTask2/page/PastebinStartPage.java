package tasksJava.webdriver.pastebinTask2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PastebinStartPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final int TIMER_TO_WAIT = 10;
    private WebDriver driver;

    @FindBy(id = "paste_code")
    private WebElement codePatternInput;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//input[@value='Create New Paste']")
    private WebElement createNewPaste;

    public PastebinStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinStartPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, TIMER_TO_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("new_paste_button")));
        return this;
    }

    public PastebinNewPastePage fillRequiredFieldAndCreate(String codePattern, String pasteName) {

        codePatternInput.sendKeys(codePattern);

        new Select(driver.findElement(By.xpath("//select[@name='paste_format']")))
                .selectByVisibleText("Bash");

        new Select(driver.findElement(By.xpath("//select[@name='paste_expire_date']")))
                .selectByVisibleText("10 Minutes");

        pasteNameInput.sendKeys(pasteName);

        createNewPaste.click();

        return new PastebinNewPastePage(driver);


    }


}
