package tests.searchApartment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class SearchApartmentTest extends BaseTest {

    // Метод, отвечающий за сценарий выполнения теста
    @Test
    public void checkInRedirectToListing() {
        basePage.open("REALT_HOME_PAGE");

        realtHomePage
                .enterCountRooms()
                .clickToFound();

        realtListingPage.checkCountCards();
    }
}
