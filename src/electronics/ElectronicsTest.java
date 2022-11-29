package electronics;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ElectronicsTest extends Utility {

    @Before
    public void openingTheBrowser() {
        //Enter 1st argument as base url and 2nd argument as Chrome/Fireforx/Edge
        browserSetup("https://demo.nopcommerce.com/", "Chrome");
    }

    //Test 1
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Hover mouse over Electronics
        hoverMousePointer(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //1.2 Hover mouse over cell phone and click
        hoverMousePointer(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //Verify Text 'Cell phones'
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

    }

    //Test 2
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //2.1 - 2.3 Calling Test method 1 to invoke its statements
        verifyUserShouldNavigateToCellPhonesPageSuccessfully();

        //2.4 Click on list view tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //Using sleep() to allow page to load fully
        Thread.sleep(1000);

        //2.5 Click on Nokia Lumia 1020 link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify text 'Nokia Lumia 1020'
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");

        //2.7 Verify the price “$349.00”
        verifyTextFromElements(By.id("price-value-20"), "$349.00");

        //2.8 Change quantity to 2
        clearTheText(By.id("product_enteredQuantity_20"));
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");

        Thread.sleep(500);

        //2.9 Click on 'ADD TO CART' tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the message 'The product has been added to your shopping cart'
        verifyTextFromElements(By.xpath("//div[@class='bar-notification success']"), "The product has been added to your shopping cart");

        //2.13b Closing the notification bar
        clickOnElement(By.xpath("//div[@id='bar-notification']/div[1]/span[1]"));

        //2.11 Hover mouse over 'Shopping cart' and click go to cart
        hoverMousePointer(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify message "Shopping Cart"
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.13 Verify quantity is 2
        verifyTextFromElements(By.xpath("//span[contains(text(),'(2)')]"), "(2)");


        //2.14 Verify the total amount is $$698.00
        verifyTextFromElements(By.xpath("//span[@class='value-summary']//strong"), "$698.00");

        //2.15 Clicking on 'I agree with terms of service'
        clickOnElement(By.id("termsofservice"));

        //2.16 Click on 'CHECKOUT'
        clickOnElement(By.name("checkout"));

        //2.17 Verify the message “Welcome, Please Sign In!”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        //2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.id("FirstName"), "Human");
        sendTextToElement(By.id("LastName"), "Being");
        selectByTheValueFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "10");
        selectByTheValueFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "5");
        selectByTheValueFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1990");
        sendTextToElement(By.id("Email"), "Imonlyhuman5@gmail.com");
        sendTextToElement(By.id("Password"), "human123");
        sendTextToElement(By.id("ConfirmPassword"), "human123");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        verifyTextFromElements(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping card”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.name("checkout"));
        //2.27 Fill the Mandatory fields
        selectByTheValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Earth");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1 Northern Pole");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "E1 2RTH");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "012540000");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='buttons']/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class ='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByIndexTextFromDropDown(By.id("CreditCardType"), 1);

        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Human Being");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        selectByTheValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "4");
        selectByTheValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "345");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyTextFromElements(By.xpath("//li[@class='payment-method']"), "Payment Method: Credit Card");

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyTextFromElements(By.xpath("//li[@class='shipping-method']"), "Shipping Method: 2nd Day Air");

        //2.37 Verify Total is “$698.00”
        verifyTextFromElements(By.xpath("//tr[@class='order-total']/td[2]"), "$698.00");

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //2.39 Verify the Text “Thank You”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyTextFromElements(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //2.42 Verify the text “Welcome to our store”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://demo.nopcommerce.com/");


    }

    @After
    public void closingBrowser() {
        closingTheBrowserBaseTest();
    }
}
