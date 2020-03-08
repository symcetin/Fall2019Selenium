package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

       // <input type="radio" id="black" name="color">
        WebElement blackButton = driver.findElement(By.id("black"));

        // if visible and eligible to click
        if(blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackButton.click();
        }else{
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }

        // how do we verify that button clicked
        // return true, if button clicked
        if(blackButton.isSelected()){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }



        driver.quit();
    }
}
