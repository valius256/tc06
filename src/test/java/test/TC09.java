package test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.TC09_Page;

public class TC09 {
    @Test
    public void TC9() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        TC09_Page page = new TC09_Page(driver);

        page.clickOnMobileMenu();
        page.addToCartIphone();
        page.enterCouponCode("GURU50");
        page.clickApplyCouponButton();

        // Verify the discount and print old/new grand totals
        page.verifyDiscountAndPrintGrandTotals();

        driver.quit();
    }


}