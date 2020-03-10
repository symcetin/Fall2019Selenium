package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {
        // WebDriver driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

 //       Whether this select element support selecting multiple options at the same time?
//        This is done by checking the value of the "multiple" attribute.
        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);


        languagesSelect.selectByValue("java");
        languagesSelect.selectByValue("js");
        languagesSelect.selectByValue("python");


        //let's get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for(WebElement selectedLanguage : selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }
        BrowserUtils.wait(2);

        languagesSelect.deselectByVisibleText("Java"); // to unselect something
        BrowserUtils.wait(2);
        languagesSelect.deselectAll();


        BrowserUtils.wait(2);
        driver.quit();
    }
}
