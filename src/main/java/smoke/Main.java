package smoke;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Подключение вебдрайвера
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Алексей\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        try{
            driver.get("file:///C:/Users/%D0%90%D0%BB%D0%B5%D0%BA%D1%81%D0%B5%D0%B9/IdeaProjects/MarshalAutomation/src/main/java/index.html");
            Thread.sleep(5000);

            LoginPage loginPage = new LoginPage();

            loginPage.login("admin", "admin");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
     }
}

