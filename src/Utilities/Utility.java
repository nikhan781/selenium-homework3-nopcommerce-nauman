package Utilities;

import browserbase.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    //1. This method will click on element
    public void clickOnElement(By by) {
        WebElement clickElement = driver.findElement(by);
        clickElement.click();
    }

    //2. This method will send text to elements
    public void sendTextToElement(By by, String text) {
        WebElement elementText = driver.findElement(by);
        elementText.sendKeys(text);
    }

    // CLear the text
    public void clearTheText(By by) {
        WebElement clearText = driver.findElement(by);
        clearText.clear();
    }

    //3. This method will verify elements
    public void verifyTextFromElements(By by, String expectedText) {
        WebElement actualText = driver.findElement(by);
        String actual = actualText.getText();
        Assert.assertEquals(expectedText, actual);
    }

    //4. This method will hover the mouse pointer
    public void hoverMousePointer(By by) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(by);
        actions.moveToElement(hover).build().perform();
    }

    //5. This method will select the element form drop box via value
    public void selectByTheValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);

        Select select = new Select(dropDown);

        select.selectByValue(value);

    }

    public void selectByVisibleTextFromDropDown(By by, String visibleText) {
        WebElement dropDown = driver.findElement(by);

        //Creating the object of Select class
        Select select = new Select(dropDown);
        //Selecting by Value attribute
        select.selectByVisibleText(visibleText);
    }

    public void selectByIndexTextFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);

        //Creating the object of Select class
        Select select = new Select(dropDown);
        //Selecting by Value attribute
        select.selectByIndex(index);
    }

    //This method create object of Alert
    public void switchToAlert() {

        Alert alert = driver.switchTo().alert();
    }

    public void dismissAlert() {

        Alert alter = driver.switchTo().alert();
        alter.dismiss();
    }

    public void acceptAlert() {
        //driver.switchTo().window().close();
    }

    public void mouseRightClickExample(By by) {
        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(by);

        actions.contextClick(button).build().perform();

    }
}
