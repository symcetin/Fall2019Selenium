package com.automation.tests.amazon;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {

    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://amazon.com");
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    public void test(){

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        driver.executeScript("window.scrollBy(0, 250)");
        WebElement iphone = driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal']//span)[2]"));

        wait.until(ExpectedConditions.elementToBeClickable(iphone)).click();

        WebElement iphoneText=  driver.findElement(By.xpath("//span[contains(text(),'Only 10')]"));
        wait.until(ExpectedConditions.visibilityOf(iphoneText));
        String actual = iphoneText.getText().trim();
        String expected = "Only 10 left in stock (more on the way).";

        Assert.assertEquals(actual, expected);
    }

}
