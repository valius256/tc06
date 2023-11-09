package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pom.TC06_LoginPage;

import java.time.Duration;

public class TC07 {

    @Test
    public static void save_previously_placed_order(){
        try {
            WebDriver driver = driverFactory.getChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("http://live.techpanda.org/");
            TC06_LoginPage loginPage = new TC06_LoginPage(driver);
            loginPage.clickOnMyAccountLink();
            loginPage.login("quangphat3@example.com", "test123");

            WebElement myOrder = driver.findElement(By.xpath("//a[normalize-space()='My Orders']"));
            myOrder.click();

            WebElement viewOrder = driver.findElement(By.xpath("//a[normalize-space()='View Order']"));
            viewOrder.click();

            WebElement printOrder = driver.findElement(By.xpath("//a[@class='link-print']"));
            printOrder.click();


            driver.quit();
        }catch (Exception e){
            e.getMessage();
        }
    }
}
