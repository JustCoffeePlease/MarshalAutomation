package pages.realt_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class RealtHomePage extends BasePage {

    public RealtHomePage(WebDriver driver) {
        super(driver);
    }
    // Описание локаторов
    private final By countRooms = By.id("rooms");
    private final By optionTwoRooms = By.xpath("//select[@id='rooms']/option[@value='2']");
    private final By findBtn = By.xpath("//div[@id='residentialInputs']//a[text()='Найти']");

    // Описание методов действий на странице
    public RealtHomePage enterCountRooms() {
        driver.findElement(countRooms).click();
        driver.findElement(optionTwoRooms).click();

        return this;
    }

    public RealtHomePage clickToFound() {
        WebElement FindButton = driver.findElement(findBtn);
        waitElementIsVisible(FindButton).click();

        return this;
    }

}
