package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) {
        // to start selenium script we need:
        // setup webdriver(browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // In selenium everything stsrts from WebDriver interface
    }
}
