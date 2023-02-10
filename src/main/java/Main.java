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
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Подключение вебдрайвера
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Алексей\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
            driver.get("https://pagination.js.org/");
            Thread.sleep(2000);

            List<WebElement> elementList = (List<WebElement>) driver.findElements(By.xpath("//div[@class = 'data-container']/ul/li"));
            List<WebElement> pagesList = (List<WebElement>) driver.findElements(By.xpath("//div[@class = 'paginationjs-pages']/ul/li"));
            String text = elementList.get(5).getText();

            System.out.println(text);


            pagesList.get(2).click();
            wait.until(ExpectedConditions.stalenessOf(elementList.get(5)));
            // stalenessOf - ожидание, пока пропадет указанный элемент

            elementList = (List<WebElement>) driver.findElements(By.xpath("//div[@class = 'data-container']/ul/li"));
            text = elementList.get(5).getText();

            System.out.println(text);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
     }
}
/*
Созданы два листа:
    elementList - информация объектов со страницы
    pagesList - информация о страницах
Таким образом, в начале информация об объектах первой страницы передается в elementList.
После этого вызывается вторая страница. После вызова в elementList собирается информация со второй страницы.
Чтобы вторая страница гарантированно успела подгрузиться, используется wait.until(ExpectedConditions.stalenessOf(elementList.get(5)));
Перед переключем страницы и после переключения переменной text присваивается 5 элемент страницы. Переменная text выводится на экран
*/
