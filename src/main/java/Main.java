import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Подключение вебдрайвера
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Алексей\\Desktop\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        Actions actions = new Actions(driver);
        WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf']"));

        searchField.sendKeys("auto", Keys.ENTER);

        WebElement resultCount = driver.findElement(By.id("result-stats"));
        String resultParameter = resultCount.getText();

        System.out.println(resultParameter);

     }

}
