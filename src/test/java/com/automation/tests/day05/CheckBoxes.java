package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        BrowserUtils.wait(5);
        //<input type="checkbox" checked="">
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

       // checkBoxes.get(0).click(); // click on first checkbox

        BrowserUtils.wait(2);

        // go over collection of checkboxes
        for (int x = 0; x < checkBoxes.size(); x++) {
            // if visible,                         eligible to click and            not clicked yet
            if (checkBoxes.get(x).isDisplayed() && checkBoxes.get(x).isEnabled() && !checkBoxes.get(x).isSelected()) {
                // if checkbox is not selected, click on it
                checkBoxes.get(x).click(); // click on the second checkbox
                System.out.println(x+1 + "checkbox clicked!");
            } else {
                System.out.println(x+1 + "checkbox wasn't clicked!");
            }
        }

        BrowserUtils.wait(2);
            driver.quit();


    }
}
