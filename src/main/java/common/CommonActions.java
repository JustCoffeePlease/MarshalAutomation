package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.TimeOutVariable.IMPLICIT_WAIT;

public class CommonActions {

    /*С помощью этого метода создаем экземпляр WebDriver, с которым будут
    работать тестовые классы*/
    public static WebDriver createDriver(){
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Incorrect platform or browser name " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize(); //Открытие окна на весь экран
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS); //Установка неявного ожидания
        return driver;
    }
}
