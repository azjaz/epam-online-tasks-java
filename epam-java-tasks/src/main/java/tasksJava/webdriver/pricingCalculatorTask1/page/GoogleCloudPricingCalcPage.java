package tasksJava.webdriver.pricingCalculatorTask1.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoogleCloudPricingCalcPage {
    private final int DRIVER_TIMEOUT = 10;
    private WebDriver driver;

    @FindBy(xpath = "//iframe[contains(@src,'cloudpricingcalculator')]")
    private WebElement googleFrame;

    @FindBy(xpath = "//md-tab-item/div[contains(@class,'compute')]")
    private WebElement computeEngineBlock;

    @FindBy(xpath = "//input[contains(@ng-model,'.quantity')]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//input[contains(@ng-model,'computeServer.label')]")
    private WebElement purposeOfInstances;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.os')]")
    private WebElement softwareType;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.class')]")
    private WebElement vMachineClass;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.family')]")
    private WebElement vMachineType;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model, 'computeServer.addGPUs')]")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.ssd')]")
    private WebElement localSSDSize;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.location')]")
    private WebElement datacenterLocation;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.cud')]")
    private WebElement committedUsageTerm;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add') and contains(text(),'Estimate')]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding']")
    private List<WebElement> resultsSet;


    public GoogleCloudPricingCalcPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public GoogleCloudPricingCalcPage computeEngineBlockActivation() {
        driver.switchTo().frame(googleFrame);
        new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(computeEngineBlock))
        .click();
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage fillNumberOfInstancesField()  {
        driver.switchTo().frame(googleFrame);
        new WebDriverWait(driver, DRIVER_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(numberOfInstances))
                .sendKeys("4");
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage fillPurposeOfInstancesBlock() {
        driver.switchTo().frame(googleFrame);
        new WebDriverWait(driver, DRIVER_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(purposeOfInstances))
                .sendKeys("");
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseSoftwareBlock() {
        driver.switchTo().frame(googleFrame);
        fillFieldsWithDroppedList(driver, softwareType, By.xpath("//md-option[contains(@value,'free')]"));
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseVMachineClassBlock() {
        driver.switchTo().frame(googleFrame);
        fillFieldsWithDroppedList(driver, vMachineClass, By.xpath("//md-option[contains(@id,'select_option_68')]"));
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseMachineTypeBlock() {
        driver.switchTo().frame(googleFrame);
        fillFieldsWithDroppedList(driver, vMachineType, By.xpath("//md-option[contains(@value,'STANDARD-8')]"));
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseGPUTypeBlock() {
        driver.switchTo().frame(googleFrame);
        if(addGPUsCheckbox.getAttribute("aria-disabled").equals("false")) {
            if(!addGPUsCheckbox.isSelected()) {
                new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(addGPUsCheckbox));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", addGPUsCheckbox);
            }
            driver.findElement(By.xpath("//md-select[contains(@ng-model, 'computeServer.gpuCount')]"))
                    .sendKeys("1");
            new WebDriverWait(driver, DRIVER_TIMEOUT)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-select[contains(@ng-model, 'computeServer.gpuType')]")))
                    .click();
            driver.findElement(By.xpath("//md-option[contains(@value,'TESLA_V100')]"))
                    .click();
        }
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseLocalSSDBlock() {
        driver.switchTo().frame(googleFrame);
        fillFieldsWithDroppedList(driver, localSSDSize, By.xpath("//md-option[contains(@id,'select_option_173')]"));
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseDatacenterLocationBlock() {
        driver.switchTo().frame(googleFrame);
        fillFieldsWithDroppedList(driver, datacenterLocation, By.xpath("//md-option[contains(@id,'select_option_186')]"));
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseCommittedUsageBlock() {
        driver.switchTo().frame(googleFrame);
        if(driver.findElement(By.xpath("//md-select[@id='select_86']")).getAttribute("aria-disabled").equals("false")) {
            fillFieldsWithDroppedList(driver, committedUsageTerm, By.xpath("//md-option[contains(@id,'select_option_84')]"));
        }
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage pressButtonAddToEstimate() {
        driver.switchTo().frame(googleFrame);
        new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToEstimateButton);
        driver.switchTo().defaultContent();
        return this;
    }
    public List<String> checkInputtedConditions() {
        driver.switchTo().frame(googleFrame);
        List<String> stringValues = new ArrayList<>();
        for (int i = 0; i < resultsSet.size(); i++) {
            stringValues.add(resultsSet.get(i).getText());
        }
        driver.switchTo().defaultContent();
        return stringValues;
    }
    public String checkTotalCost() {
        driver.switchTo().frame(googleFrame);
        String totalCostValue = driver.findElement(By.xpath("//h2[@class='md-title']/b")).getText();
        driver.switchTo().defaultContent();
        return totalCostValue;
    }

    private void fillFieldsWithDroppedList(WebDriver driver, WebElement element, By by) {
        new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        executor.executeScript("arguments[0].click();", driver.findElement(by));
    }

}
