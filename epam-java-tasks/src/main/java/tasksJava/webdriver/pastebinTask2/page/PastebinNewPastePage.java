package tasksJava.webdriver.pastebinTask2.page;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PastebinNewPastePage {
    private static final int TIMER_TO_WAIT = 10;
    private WebDriver driver;

    public PastebinNewPastePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getPasteNameFromHeader(String pasteName) {
        return getElementsOnPage(By.xpath(String.format("//title[contains(normalize-space(text()), '%s')]", pasteName)));
    }

    public List<WebElement> getSyntaxHighlightType(String syntaxHighlightType) {
        return getElementsOnPage(By.xpath(String.format("//a[contains(@class,'buttonsm') and contains(text(), '%s')]", syntaxHighlightType)));
    }

    public boolean getCodePattern(String codePattern) {
        String textOfPattern = getElementsOnPage(By.xpath("//textarea[@id='paste_code']"))
                .get(0)
                .getText();
        return codePattern.equals(textOfPattern);
    }

    private List<WebElement> getElementsOnPage(By by) {
        return new WebDriverWait(driver, TIMER_TO_WAIT)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

}
