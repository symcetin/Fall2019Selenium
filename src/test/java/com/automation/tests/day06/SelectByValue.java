package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByValue("DC");

        String expected = "District Of Columbia";
        String actual = stateSelect.getFirstSelectedOption().getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }



        BrowserUtils.wait(3);
        driver.quit();
    }
}
