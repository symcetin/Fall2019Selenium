package com.automation.tests.office_hour;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IframesPractice {
    // iFrame - web document inside of other web document (html inside of html doc)

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }


    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //we landed to red webdocument - default content
        driver.switchTo().frame("frame-top");
        //we are landed to blue web-doc
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. swithch to each frame
                a. get test from body
                b. switch to parent
         */

        for (int i = 0; i < frameList.size(); i++) {
            BrowserUtils.wait(2);
            driver.switchTo().frame(i);
            BrowserUtils.wait(2);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Body text: " + bodyText);
            driver.switchTo().parentFrame();
        }

    }

}
