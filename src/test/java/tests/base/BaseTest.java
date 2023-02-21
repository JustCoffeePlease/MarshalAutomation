package tests.base;

//Здесь описана общая логика,
//которая потребуется в каждом классе

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.realt_home.RealtHomePage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected RealtHomePage realtHomePage = new RealtHomePage(driver);

    // Метод отчискти куков и памяти
    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    // метод закрытия браузера
    // alwaysRun = true чтобы метод обязательно выполнялся
    @AfterSuite (alwaysRun = true)
    public void close() {
        if(HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}