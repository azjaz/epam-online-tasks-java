package tasksJava.webdriver.pricingCalculatorTask1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tasksJava.webdriver.pricingCalculatorTask1.page.CloudGoogleHomePage;
import tasksJava.webdriver.pricingCalculatorTask1.page.GoogleCloudPricingCalcPage;

import java.util.List;

public class GooglePriceCalculatorTest {
    private String termToSearch = "Google Cloud Platform Pricing Calculator";
    private String vmClassValue = "Regular";
    private String instanceType = "n1-standard-8";
    private String regionName = "Frankfurt";
    private String localSSDSize = "3x375 Gb";
    private String commitmentTerm = "1 Year";
    private String checkedTotalCost = "1,174.27";
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void correspondenceUserInputFieldsTest() {
        GoogleCloudPricingCalcPage testPage = new CloudGoogleHomePage(driver)
                .openHomePage()
                .searchForTerm(termToSearch)
                .clickOnRequiredLink()
                .computeEngineBlockActivation()
                .fillNumberOfInstancesField()
                .fillPurposeOfInstancesBlock()
                .chooseSoftwareBlock()
                .chooseVMachineClassBlock()
                .chooseMachineTypeBlock()
                .chooseGPUTypeBlock()
                .chooseLocalSSDBlock()
                .chooseDatacenterLocationBlock()
                .chooseCommittedUsageBlock()
                .pressButtonAddToEstimate();

                List<String> checkedValues = testPage.checkInputtedConditions();

                boolean vmClassCheck = checkedValues.get(1).toLowerCase().contains(vmClassValue.toLowerCase());
                Assert.assertTrue(vmClassCheck, "Virtual Machine class is not correspond");

                boolean instanceCheck = checkedValues.get(2).toLowerCase().contains(instanceType.toLowerCase());
                Assert.assertTrue(instanceCheck, "Instance type is not correspond");

                boolean regionCheck = checkedValues.get(3).toLowerCase().contains(regionName.toLowerCase());
                Assert.assertTrue(regionCheck, "Region is not correspond");

                boolean ssdSizeCheck = checkedValues.get(4).toLowerCase().contains(localSSDSize.toLowerCase());
                Assert.assertTrue(ssdSizeCheck, "SSD size is not correspond");

                boolean termCheck = checkedValues.get(5).toLowerCase().contains(commitmentTerm.toLowerCase());
                Assert.assertTrue(termCheck, "Term is not correspond");

                boolean totalSumCheck = testPage.checkTotalCost().toLowerCase().contains(checkedTotalCost.toLowerCase());
                Assert.assertTrue(totalSumCheck, "Estimated sum is not correspond");


    }

    @AfterMethod(alwaysRun = true)
    public void browserTermination() {
        driver.quit();
        driver = null;
    }
}
