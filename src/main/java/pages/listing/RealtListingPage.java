package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

// Класс конкретной  page
public class RealtListingPage extends BasePage {


    public RealtListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//div[contains(@class, 'listing-item')]//div[@class='teaser-tile teaser-tile-right']");

    // Метод, проверяющий количество объявлений
    public RealtListingPage checkCountCards() {
        // Количество объектов в коллекции
        int countCard = driver.findElements(card).size();

        Assert.assertEquals(countCard, 20);

        return this;
    }
}
