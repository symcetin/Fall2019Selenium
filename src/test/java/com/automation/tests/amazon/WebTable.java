package com.automation.tests.amazon;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {
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
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    public void verifyFabric(){
        List<WebElement> list = driver.findElements(By.xpath("//table[@class='navFooterMoreOnAmazon']//td[3]"));
        for(WebElement each : list){
            System.out.println(each.getText());
        }

        Assert.assertTrue(list.get(2).isDisplayed());
    }
}
