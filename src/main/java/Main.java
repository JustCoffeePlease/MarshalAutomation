import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        // Подключение вебдрайвера
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Алексей\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Настройка драйвера
        // Установка времени неявного ожидания перед поиском
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        // Установка времени явного ожидания, пока не появится прописанный элемент
//        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));
//        driver.get("https://google.com");

        driver.get("https://www.avito.ru/");
        // Применение поиска элемента и запись его свойства 'Properties'(Вкладка на панели DOM)
        WebElement element = driver.findElement(By.xpath("(//a[text()='Транспорт'])[2]"));
        String parameter = element.getAttribute("baseURI");

        System.out.println(parameter);
    }

}
