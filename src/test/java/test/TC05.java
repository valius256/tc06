package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pom.RegistrationPage;

public class TC05 {
    @Test
    public  static  void createAccountInEcommercAndShareWishList(){
        try {
            WebDriver driver = new ChromeDriver();
            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // 2. Click on "MY ACCOUNT" link
            WebElement AccountLink = driver.findElement(By.cssSelector("a[class='skip-link skip-account'] span[class='label']"));
            AccountLink.click();

            WebElement myAccountLink = driver.findElement(By.cssSelector("div[id='header-account'] a[title='My Account']"));
            myAccountLink.click();

            WebElement createAnAccount = driver.findElement(By.cssSelector("a[title='Create an Account'] span span"));
            createAnAccount.click();

            // Create an instance of the RegistrationPage POM
            RegistrationPage registrationPage = new RegistrationPage(driver);

            // 3. Click "Create an Account" link and fill New User information excluding the registered Email ID.
            registrationPage.fillRegistrationForm("phat", "quang", "quangphat3@example.com", "test123","test123");

            // 4. Click Register
            registrationPage.clickRegister();

            // 5. Verify Registration is done
            if (registrationPage.isRegistrationSuccessMessageDisplayed()) {
                System.out.println("Account registration successful.");
            } else {
                System.out.println("Account registration failed.");
            }


            // 6. Go to TV menu
            WebElement tvMenu = driver.findElement(By.linkText("TV"));
            tvMenu.click();

            // 7. Add product to your wishlist (e.g., LG LCD)
            WebElement lgLcdProduct = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
            lgLcdProduct.click();
            // Implement code to add the product to your wishlist as needed

            // 8. Click Update Wishlist
            WebElement shareWishlistButton = driver.findElement(By.cssSelector("textarea[placeholder='Please, enter your comments...']"));
            shareWishlistButton.clear();
            shareWishlistButton.sendKeys("Ahahahaha");
            WebElement updateBtn = driver.findElement(By.cssSelector("div[class='item-manage'] button[title='Update Wishlist'] span span"));
            updateBtn.click();

            // Close the browser
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
