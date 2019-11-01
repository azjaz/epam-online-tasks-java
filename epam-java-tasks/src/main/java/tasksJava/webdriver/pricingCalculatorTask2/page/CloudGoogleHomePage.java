package tasksJava.webdriver.pricingCalculatorTask2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage {

    private final String HOMEPAGE_URL = "https://cloud.google.com/";
    private final int DRIVER_TIMEOUT = 10;
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='searchbox']/input[@name='q']")
    private WebElement searchInput;

    public CloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, DRIVER_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='searchbox']/input")));
        return this;
    }
    public SearchResultPage searchForTerm(String termToSearch) {
        searchInput.click();
        searchInput.sendKeys(termToSearch);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver, termToSearch);
    }
}
