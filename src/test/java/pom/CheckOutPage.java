package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    WebElement Elem = null;
    Select Dropdown = null;
    private WebDriver driver;
    public  CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By proceedToCheckoutSelector = By.cssSelector("li[class='method-checkout-cart-methods-onepage-bottom'] button[title='Proceed to Checkout'] span span");
    private final By newBillingAddressBox = By.id("billing-address-select");
    private final By newShippingAddressBox = By.id("shipping-address-select");
    private final By BfisrtNameBox = By.id("billing:firstname");
    private final By BmiddleNameBox = By.id("billing:middlename");
    private final By BlastNameBox = By.id("billing:lastname");
    private final By BcompanyBox = By.id("billing:company");
    private final By BaddressBox = By.id("billing:street1");
    private final By BstreetAddress2Box = By.id("billing:street2");
    private final By BcityBox = By.id("billing:city");
    private final By BstateBox = By.id("billing:region_id");
    private final By BzipBox = By.id("billing:postcode");
    private final By BcountryBox = By.id("billing:country_id");
    private final By BtelephoneBox = By.id("billing:telephone");
    private final By BfaxBox = By.id("billing:fax");
    private final By SfisrtNameBox = By.id("shipping:firstname");
    private final By SmiddleNameBox = By.id("shipping:middlename");
    private final By SlastNameBox = By.id("shipping:lastname");
    private final By ScompanyBox = By.id("shipping:company");
    private final By SaddressBox = By.id("shipping:street1");
    private final By SstreetAddress2Box = By.id("shipping:street2");
    private final By ScityBox = By.id("shipping:city");
    private final By SstateBox = By.id("shipping:region_id");
    private final By SzipBox = By.id("shipping:postcode");
    private final By ScountryBox = By.id("shipping:country_id");
    private final By StelephoneBox = By.id("shipping:telephone");
    private final By SfaxBox = By.id("shipping:fax");
    private final By ShipToThisAddressSelector = By.cssSelector("label[for='billing:use_for_shipping_yes']");
    private final By ShipToDifAddressSelector = By.cssSelector("label[for='billing:use_for_shipping_no']");

    private final By ContinueBilingSelector = By.cssSelector("button[onclick='billing.save()']");
    private final By ContinueShippingSelector = By.cssSelector("button[onclick='shipping.save()'] span span");
    private final By ContinueShippingMethodSelector = By.xpath("//button[@onclick='shippingMethod.save()']");
    private final By ChkMoSelector = By.xpath("//label[@for='p_method_checkmo']");
    private final By ContinuePaymentSelector = By.cssSelector("button[onclick='payment.save()'] span span");
    private final By PlaceOrderSelector = By.xpath("//button[@title='Place Order']");
    private final By OrderRecievedMessage = By.cssSelector(".sub-title");
    private final By orderNumberMessage = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(3)");


    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutSelector).click();
    }

    public void enterBillingInformation(String newAddress, String firstName, String middleName, String lastName,
                                        String company, String address, String streetAddress2, String city,
                                        String state, String zip, String country, String telephone, String fax) {
        Dropdown = new Select(driver.findElement(newBillingAddressBox));
        Dropdown.selectByVisibleText(newAddress);

        Elem = driver.findElement(BfisrtNameBox);
        Elem.clear();
        Elem.sendKeys(firstName);

        Elem = driver.findElement(BmiddleNameBox);
        Elem.clear();
        Elem.sendKeys(middleName);

        Elem = driver.findElement(BlastNameBox);
        Elem.clear();
        Elem.sendKeys(lastName);

        Elem = driver.findElement(BcompanyBox);
        Elem.clear();
        Elem.sendKeys(company);

        Elem = driver.findElement(BaddressBox);
        Elem.clear();
        Elem.sendKeys(address);

        Elem = driver.findElement(BstreetAddress2Box);
        Elem.clear();
        Elem.sendKeys(streetAddress2);

        Elem = driver.findElement(BcityBox);
        Elem.clear();
        Elem.sendKeys(city);

        Dropdown = new Select(driver.findElement(BstateBox));
        Dropdown.selectByVisibleText(state);

        Elem = driver.findElement(BzipBox);
        Elem.clear();
        Elem.sendKeys(zip);

        Dropdown = new Select(driver.findElement(BcountryBox));
        Dropdown.selectByVisibleText(country);


        Elem = driver.findElement(BtelephoneBox);
        Elem.clear();
        Elem.sendKeys(telephone);

        Elem = driver.findElement(BfaxBox);
        Elem.clear();
        Elem.sendKeys(fax);

        driver.findElement(ShipToDifAddressSelector).click();
        driver.findElement(ContinueBilingSelector).click();
    }
    public void enterShippingInformation(String newAddress, String firstName, String middleName, String lastName,
                                         String company, String address, String streetAddress2, String city,
                                         String state, String zip, String country, String telephone, String fax) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for the shipping address dropdown to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(newShippingAddressBox));

            // Select the shipping address from the dropdown
            Dropdown = new Select(driver.findElement(newShippingAddressBox));
            Dropdown.selectByVisibleText(newAddress);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            // Handle the exception by waiting for the element to be visible again or take appropriate action
            wait.until(ExpectedConditions.visibilityOfElementLocated(newShippingAddressBox));
            Dropdown = new Select(driver.findElement(newShippingAddressBox));
            Dropdown.selectByVisibleText(newAddress);
        }

        Elem = driver.findElement(SfisrtNameBox);
        Elem.clear();
        Elem.sendKeys(firstName);

        Elem = driver.findElement(SmiddleNameBox);
        Elem.clear();
        Elem.sendKeys(middleName);

        Elem = driver.findElement(SlastNameBox);
        Elem.clear();
        Elem.sendKeys(lastName);

        Elem = driver.findElement(ScompanyBox);
        Elem.clear();
        Elem.sendKeys(company);

        Elem = driver.findElement(SaddressBox);
        Elem.clear();
        Elem.sendKeys(address);

        Elem = driver.findElement(SstreetAddress2Box);
        Elem.clear();
        Elem.sendKeys(streetAddress2);

        Elem = driver.findElement(ScityBox);
        Elem.clear();
        Elem.sendKeys(city);

        Dropdown = new Select(driver.findElement(SstateBox));
        Dropdown.selectByVisibleText(state);

        Elem = driver.findElement(SzipBox);
        Elem.clear();
        Elem.sendKeys(zip);

        Dropdown = new Select(driver.findElement(ScountryBox));
        Dropdown.selectByVisibleText(country);


        Elem = driver.findElement(StelephoneBox);
        Elem.clear();
        Elem.sendKeys(telephone);

        Elem = driver.findElement(SfaxBox);
        Elem.clear();
        Elem.sendKeys(fax);

        driver.findElement(ContinueShippingSelector).click();
    }


    public void click() {
        driver.findElement(ContinueShippingSelector).click();
    }
    public void selectShippingMethod() {
        driver.findElement(ContinueShippingMethodSelector).click();
    }
    public void selectPaymentMethod() {
        driver.findElement(ChkMoSelector).click();
    }
    public void clickPaymentInfo() {
        driver.findElement(ContinuePaymentSelector).click();
    }
    public void clickPlaceOrder() {
        driver.findElement(PlaceOrderSelector).click();
    }
    public String getOrderRecievedMessage() {
        return driver.findElement(OrderRecievedMessage).getText();
    }

    public String getOrderNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberMessage)).getText();
    }
}
