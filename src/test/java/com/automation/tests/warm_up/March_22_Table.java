package com.automation.tests.warm_up;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class March_22_Table {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to tru to make it work
        chromeOptions.setHeadless(true);//to run browser without GUI. Makes browser invisible.
        driver = new ChromeDriver(chromeOptions);

        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    /*
    Go to http://practice.cybertekschool.com/tables
    Click on “Last name” column name
    Verfiy that table is sorted by last name in alphabetic order.
     */
    @Test
    public void verifyOrder(){

        driver.findElement(By.xpath("//table[@id='table1']//span")).click();
        BrowserUtils.wait(2);
        List<WebElement> lst=driver.findElements(By.xpath("//table[1]//tr//td[1]"));

        List<String> lastNameList=BrowserUtils.getTextFromWebElements(lst);
        List<String> listCopy = lastNameList;

        Collections.sort(listCopy);

        driver.findElement(By.xpath("//table[1]//span[text()='Last Name']")).click();
        Assert.assertEquals(lastNameList,listCopy);

    }
}
