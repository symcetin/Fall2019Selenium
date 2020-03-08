package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

       // WebDriver driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        BrowserUtils.wait(3);

        //create a web element object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide web element object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        BrowserUtils.wait(3);
        // select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        // and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        // select DOB
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("September");
        selectYear.selectByVisibleText("2009");

        // select all months one by one
        // .getOptions(); -->returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement month : months){
            // get the month name and select based on that
            String monthName = month.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }


        BrowserUtils.wait(2);
        driver.quit();

        //<select id="dropdown">

    }
}
