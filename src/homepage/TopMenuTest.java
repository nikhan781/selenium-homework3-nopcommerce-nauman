package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {

    @Before
    public void openBrowser() {
        browserSetup("https://demo.nopcommerce.com/", "Edge");
    }

    public void selectMenu(String menu) {

        switch (menu) {
            case "Computers":
                clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));
                break;
            case "Electronics":
                clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
                break;
            default:
                System.out.println("Wrong selection");
                break;
        }
    }

    @Test
    public void verifyPageNavigation() {
        //invoking selectMenu method to selecte the topbar element
        selectMenu("Computers");
        // Verify the common text to verify navigation
        verifyTextFromElements(By.xpath("//div[@class ='block block-category-navigation']/div[1]"), "Categories");

    }

    @After
    public void closeTheBrowser() {
        closingTheBrowserBaseTest();
    }


}
