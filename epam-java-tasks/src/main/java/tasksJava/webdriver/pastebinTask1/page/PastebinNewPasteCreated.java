package tasksJava.webdriver.pastebinTask1.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinNewPasteCreated {
    private static final int TIMER_TO_WAIT = 10;
    private WebDriver driver;
    private String pasteName;
    private String codePattern;


    public PastebinNewPasteCreated(WebDriver driver, String codePattern, String pasteName) {
        this.driver = driver;
        this.pasteName = pasteName;
        this.codePattern = codePattern;
    }

    public boolean compareRequiredElementsOnCreatedPage() {

        boolean isPasteNamePresent = isExpectedElementPresentOnPage(By.xpath(String.format("//div[@title='%s']", pasteName)));
        boolean isTimePresent = isExpectedElementPresentOnPage(By.xpath("//img[@class='img_line t_ex']"));
        boolean isCodePatternPresent = isExpectedElementPresentOnPage(By.xpath(String.format("//textarea[normalize-space(text())='%s']", codePattern)));


        return isCodePatternPresent && isPasteNamePresent && isTimePresent;


    }

    private boolean isExpectedElementPresentOnPage(By by) {
        return new WebDriverWait(driver, TIMER_TO_WAIT)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by))
                .size() > 0;
    }

}
