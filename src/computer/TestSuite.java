package computer;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestSuite extends Utility {

    @Before
    public void openingTheBrowser() {
        //Enter 1st argument as base url and 2nd argument as Chrome/Firefox/Edge
        browserSetup("https://demo.nopcommerce.com/", "Chrome");
    }

    //Test 1
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //1.1 clicking on Computers
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));

        //1.2Clicking on Desktop from dropdown menu
        clickOnElement(By.xpath("//div[@class='category-grid sub-category-grid']/div/div[1]"));

        Thread.sleep(1500);
        //1.3 Select Sort By position "Name: Z to A"
        selectByTheValueFromDropDown(By.xpath("//select[@id='products-orderby']"), "6");

        //1.4 Verify the Product will arrange in Descending order.
        verifyTextFromElements(By.xpath("//option[@value='6']"), "Name: Z to A");


    }

    //Test 2
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 clicking on Computers
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));

        //2.2 Clicking on Desktop
        clickOnElement(By.xpath("//div[@class='category-grid sub-category-grid']/div/div[1]"));

        //2.3 Selecting sort by A to Z
        selectByIndexTextFromDropDown(By.xpath("//select[@id='products-orderby']"), 1);

        //Sleep threat to allow page to load properly and implement the
        Thread.sleep(1500);
        //2.4 Clicking on Add To Cart for Build Own Computer
        clickOnElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]"));

        //2.5 Verifying the text to confirm positive page navigation to Build your own computer
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");

        //2.6 - 2.10 Selecting all the options for building computer
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");

        selectByIndexTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), 3);

        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        //clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_12"));

        //Sleep threat to allow page to load properly and implement the
        Thread.sleep(2000);
        //2.11 Verify the total amount matches our requirement
        verifyTextFromElements(By.xpath("//span[@id='price-value-1']"), "$1,475.00");

        //2.12 Clicking on Add to cart button
        clickOnElement(By.id("add-to-cart-button-1"));

        //2.13a Verifying notification with text
        verifyTextFromElements(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");

        //2.13b Closing the notification bar
        clickOnElement(By.xpath("//div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Hovering mouse on Shopping cart and click on Go TO Cart button
        hoverMousePointer(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify message "Shopping Cart"
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.16 Changing the QTY to 2 and Click on 'Update Shopping Cart' button
        clearTheText(By.xpath("//td[@class='quantity']/input"));
        sendTextToElement(By.xpath("//td[@class='quantity']/input"), "2");
        clickOnElement(By.id("updatecart"));

        //Time to load the page
        Thread.sleep(500);

        //2.17 Verify the total amount is $2950.00
        verifyTextFromElements(By.xpath("//span[@class='value-summary']//strong"), "$2,950.00");

        //2.18 Clicking on 'I agree with terms of service'
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on 'CHECKOUT'
        clickOnElement(By.name("checkout"));

        //2.20 Verify the message
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //2.21 Click on check out as guest
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        //2.22 Filling all mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Prime");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Testing");
        sendTextToElement(By.id("BillingNewAddress_Email"), "prime_testing@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.name("BillingNewAddress.City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Prime Testing Group");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "EC1 1BC");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "02084561254");

        //2.23 Click on continue button
        clickOnElement(By.name("save"));

        //2.24 Click on radio button 'Next Day Delivery'
        clickOnElement(By.id("shippingoption_1"));
        //2.25 Click on continue
        clickOnElement(By.xpath("//button[@class ='button-1 shipping-method-next-step-button']"));

        //2.26 Click on Credit card radio button
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select Master Card from drop down
        selectByIndexTextFromDropDown(By.id("CreditCardType"), 1);

        //2.28 Entering the card details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Prime Testing");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        selectByTheValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "5");
        selectByTheValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

        //2.29 Click on continue button
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify 'Payment Method is 'Credit Card'
        verifyTextFromElements(By.xpath("//li[@class='payment-method']"), "Payment Method: Credit Card");

        //2.31 Verify shipping method is Next Day Air
        verifyTextFromElements(By.xpath("//li[@class='shipping-method']"), "Shipping Method: Next Day Air");

        //2.32 Verify Total is $2,950.00
        verifyTextFromElements(By.xpath("//tr[@class='order-total']/td[2]"), "$2,950.00");

        //2.33 Click on confirm
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //2.34 Verify text 'Thank you'
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //2.35 Very text “Your order has been successfully processed!”
        verifyTextFromElements(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        //2.37 Click on Continue
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //2.38 Verify “Welcome to our store” text
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

    }

    @After
    public void closingBrowser() {
        closingTheBrowserBaseTest();
    }
}
