package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehicleOdometerPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.vytrack.AbstractTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleOdometerTests extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    VehicleOdometerPage vehiclesPage = new VehicleOdometerPage();

    @Test
    public void test(){
        loginPage.login();
        vehiclesPage.navigateTo("Fleet","Vehicle Odometer");

        vehiclesPage.clickToCreateVehicleOdometer();
        vehiclesPage.fillInfo();
    }

    @Test
    public void verifyCancelButton(){
        loginPage.login();
        vehiclesPage.navigateTo("Fleet","Vehicle Odometer");
        vehiclesPage.clickToCreateVehicleOdometer();

        //Assert.assertTrue(vehiclesPage.clickCancel());

    }
}
