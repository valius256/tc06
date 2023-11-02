package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pom.TC06_CartPage;
import pom.TC06_CheckOutPage;
import pom.TC06_LoginPage;

import java.time.Duration;

public class TC06_TestALL {
    @Test
    public static void main() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");
        TC06_LoginPage loginPage = new TC06_LoginPage(driver);
        TC06_CartPage cartPage = new TC06_CartPage(driver);
        TC06_CheckOutPage checkoutPage = new TC06_CheckOutPage(driver);

        loginPage.clickOnMyAccountLink();
        loginPage.login("quangphat3@example.com", "test123");
        // 6. Go to TV menu
        WebElement tvMenu = driver.findElement(By.linkText("TV"));
        tvMenu.click();

        // 7. Add product to your wishlist (e.g., LG LCD)
        WebElement lgLcdProduct = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
        lgLcdProduct.click();
        cartPage.clickOnMyWishlistLink();
        cartPage.clickOnMyAddToCartLink();
        cartPage.enterShippingInformation("United States", "New York", "2000");
        cartPage.clickOnEstimateLink();

        String shippingCost = cartPage.getShippingCost();
        System.out.println("Shipping cost: " + shippingCost);

        cartPage.selectShippingCost();

        cartPage.updateTotalCost();
        String totalCost = cartPage.getTotalCost();
        System.out.println("Total cost: " + totalCost);

        checkoutPage.clickProceedToCheckout();

        checkoutPage.enterBillingInformation("New Address", "aaa",
                "quang", "phat", "FPT", "2000 Jump Street",
                "22 Jump Street", "Chicago", "Alabama", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.enterShippingInformation("New Address", "aaa",
                "quang", "phat", "FPT", "2000 Jump Street",
                "22 Jump Street", "Chicago", "Alabama", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.click();

        checkoutPage.selectShippingMethod();

        checkoutPage.selectPaymentMethod();

        checkoutPage.clickPaymentInfo();

        checkoutPage.clickPlaceOrder();

        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
        String actualMessage = checkoutPage.getOrderRecievedMessage();
        assert actualMessage.equals(expectedMessage) : "Order failed!";
        System.out.println("Order sent succeed");

        String orderNumber = checkoutPage.getOrderNumber();
        System.out.println(orderNumber);

        driver.quit();
    }
}
