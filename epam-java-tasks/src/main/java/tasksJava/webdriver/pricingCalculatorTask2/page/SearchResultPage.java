package tasksJava.webdriver.pricingCalculatorTask2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    private final int DRIVER_TIMEOUT = 10;
    private WebDriver driver;
    private String termToSearch;

    @FindBy(xpath = "//div[@class='gs-title']//a[@href='https://cloud.google.com/products/calculator/']/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchResult;


    public SearchResultPage(WebDriver driver, String termToSearch) {
        this.driver = driver;
        this.termToSearch = termToSearch;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalcPage clickOnRequiredLink() {
        WebDriverWait wait = new WebDriverWait(driver, DRIVER_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(searchResult))
                .click();
        return new GoogleCloudPricingCalcPage(driver);
    }
}
