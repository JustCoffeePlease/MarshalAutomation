import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;


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

            WebElement element_a = driver.findElement(By.id("a"));
            WebElement element_b = driver.findElement(By.id("b"));
            WebElement element_c = driver.findElement(By.id("c"));

            element_a.click();
            Alert alert_a = wait.until(alertIsPresent());
            alert_a.accept();


            element_b.click();
            Alert promt = wait.until(alertIsPresent());
            promt.sendKeys("Super ");
            promt.accept();

            Alert alert_b = wait.until(alertIsPresent());
            Thread.sleep(5000);
            alert_b.accept();


            element_c.click();
            Alert alert_c = wait.until(alertIsPresent());
            alert_c.dismiss();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
     }
}

