package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{
        // to start selenium script we need:
        // setup webdriver(browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // In selenium everything stsrts from WebDriver interface

        // in selenium, everything starts from WebDriver interface'
        // extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com");

        Thread.sleep(3000); // waits 3 seconds

        //method that return page title
        // you can also see it as tab name, in the browser
        String title = driver.getTitle(); // returns <title> Some title</title> text
        String expectedTitle = "Google";// we provide it

        System.out.println("Title = " + title);

        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }

        // must be at the end
        driver.close(); // to close browser
        // browser cannot close itself
    }
}
