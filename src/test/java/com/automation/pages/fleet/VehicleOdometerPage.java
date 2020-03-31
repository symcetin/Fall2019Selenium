package com.automation.pages.fleet;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class VehicleOdometerPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Vehicle Odometer']")
    private WebElement createVehicleOdometer;


    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement odometerValue;

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    private WebElement date;


    @FindBy(css = "[id^='custom_entity_type_Driver-uid']")
    private WebElement driver;

    @FindBy(xpath = "//span[text() = 'miles']")
    private WebElement unit;

    @FindBy(xpath = "(//span[@class='select2-chosen'])[2]")
    private WebElement model;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
    private List<WebElement> dateList;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement save_close;
    @FindBy(css = "[title='Cancel")
    private WebElement cancel;


    public void clickToCreateVehicleOdometer(){
        BrowserUtils.waitForPageToLoad(25);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Create Vehicle Odometer']")));

        BrowserUtils.wait(5);
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleOdometer)).click();
        BrowserUtils.waitForPageToLoad(20);
    }

    public void fillInfo(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(odometerValue));
        odometerValue.sendKeys("2070");
        date.click();
        BrowserUtils.wait(2);
        dateList.get(5).click();
       // unit.click();
        driver.sendKeys("driver");
        save_close.click();
    }

    public Boolean clickCancel(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
        return cancel.isSelected();

    }

}
