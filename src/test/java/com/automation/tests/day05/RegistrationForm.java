package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(5);

        // enter first name
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");
        driver.findElement(By.name("password")).sendKeys("sendsecretpassword");
        driver.findElement(By.name("phone")).sendKeys("571-264-5926");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        // select gender
        genders.get(0).click(); // select male, for example

        driver.findElement(By.name("birthday")).sendKeys("01/03/2006");

        driver.findElement(By.id("inlineCheckbox2")).click(); // select java

        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click(); // click on submit button
        BrowserUtils.wait(3);

        if(driver.findElement(By.tagName("p")).getText().equals("You've successfully completed registration!")){
            System.out.println("Registration completed");
        }else {
            System.out.println("Registration failed");
        }
            driver.quit();
    }
}
