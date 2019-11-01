package tasksJava.webdriver.pricingCalculatorTask2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleCloudPricingCalcPage {

    private final int DRIVER_TIMEOUT = 10;
    private WebDriver driver;


    @FindBy(xpath = "//iframe[contains(@src,'cloudpricingcalculator')]")
    private WebElement googleFrame;

    @FindBy(xpath = "//md-tab-item/div[contains(@class,'compute')]")
    private WebElement computeEngineBlock;

    @FindBy(xpath = "//input[@id='input_53']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//input[@id='input_54']")
    private WebElement purposeOfInstances;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_46']")
    private WebElement softwareType;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_47']")
    private WebElement vMachineClass;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_49']")
    private WebElement vMachineType;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model, 'computeServer.addGPUs')]")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_50']")
    private WebElement localSSDSize;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_51']")
    private WebElement datacenterLocation;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_52']")
    private WebElement committedUsageTerm;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add') and contains(text(),'Estimate')]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//button[contains(@aria-label,'Email') and contains(., 'Estimate')]")
    private WebElement emailEstimateButton;


    public GoogleCloudPricingCalcPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public GoogleCloudPricingCalcPage activateComputeEngineBlock() {
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
        fillFieldsWithDroppedList(driver, vMachineClass, By.xpath("//md-option[contains(@id,'select_option_67')]"));
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
                new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(addGPUsCheckbox))
                .click();
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
        fillFieldsWithDroppedList(driver, localSSDSize, By.xpath("//md-option[contains(@id,'select_option_172')]"));
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseDatacenterLocationBlock() {
        driver.switchTo().frame(googleFrame);
        fillFieldsWithDroppedList(driver, datacenterLocation, By.xpath("//md-option[contains(@id,'select_option_185')]"));
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage chooseCommittedUsageBlock() {
        driver.switchTo().frame(googleFrame);
        if(driver.findElement(By.xpath("//md-select[@id='select_85']")).getAttribute("aria-disabled").equals("false")) {
            fillFieldsWithDroppedList(driver, committedUsageTerm, By.xpath("//md-option[contains(@id,'select_option_83')]"));
        }
        driver.switchTo().defaultContent();
        return this;
    }
    public GoogleCloudPricingCalcPage pressAddToEstimateButton() {
        driver.switchTo().frame(googleFrame);
        new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToEstimateButton);
        driver.switchTo().defaultContent();
        return this;
    }

    public String[] getTotalCostFromCalculator() {
        driver.switchTo().frame(googleFrame);
        String totalCostValue = driver.findElement(By.xpath("//h2[@class='md-title']/b")).getText();
        driver.switchTo().defaultContent();
        return totalCostValue.split(" ");
    }

    public TemporaryEmailServicePage pressEmailEstimateButton() {
        driver.switchTo().frame(googleFrame);
        new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", emailEstimateButton);
        driver.switchTo().defaultContent();
        return new TemporaryEmailServicePage(driver);
    }


    private void fillFieldsWithDroppedList(WebDriver driver, WebElement element, By by) {
        new WebDriverWait(driver, DRIVER_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        executor.executeScript("arguments[0].click();", driver.findElement(by));
    }

}
