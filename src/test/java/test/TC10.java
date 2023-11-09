package test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import driver.driverFactory;
import pom.TC10_Page;

import java.io.File;
import java.io.IOException;

public class TC10 {
    @Test
    public void Main() throws IOException {
        WebDriver driver = driverFactory.getChromeDriver();
        TC10_Page page = new TC10_Page(driver);

        // Step 1: Go to backend login page
        driver.get("http://live.techpanda.org/index.php/backendlogin");

        // Step 2: Login with provided credentials
        page.login("user01", "guru99com");

        // Step 3: Navigate to Sales -> Orders menu
        page.closeMsgBox();
        page.goToOrders();

        page.EnterToOrderID();
        page.EnterFindDate();
        page.SearchButtonClick();
//     Take screenshot
        TakesScreenshot mobilePage =((TakesScreenshot)driver);
        File srcFile1= mobilePage.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile1, new File("D:\\semester5\\swt\\test\\selenium-webdriver-java\\selenium-webdriver-java\\src\\test\\java\\image\\tc10\\backend.png"));


        driver.quit();
    }
}