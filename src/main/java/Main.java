import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Подключение вебдрайвера
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Алексей\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // js Необходим для выполнения команды открытия нового окна
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // Здесь работаем с окнами и вкладками
        // Selenium умеет работать только с окнами
        // Открытие новых вкладок расценивается как открытие нового окна
        try{
            driver.get("file:///C:/Users/%D0%90%D0%BB%D0%B5%D0%BA%D1%81%D0%B5%D0%B9/IdeaProjects/MarshalAutomation/src/main/java/index.html");
            Thread.sleep(5000);

            // Получаем дескриптор первого окна и записываем в переменную windowOne
            String windowOne = driver.getWindowHandle();

            // В Selenium нет возможности открыть новое окно, для этого используется js
            // Открытие нового окна
            js.executeScript("window.open()");

            // Записываем дескрипторы текущих окон, которые открыты
            Set<String> currentWindows = driver.getWindowHandles();

            String windowTwo = null;

            // Перебор списка, который получился из всех дескрипторов
            // и проверка условия на эквивалентность с первым окном
            // Если равенство не соблюдается, в windowTwo записываем текущий дескриптор по перебору
            for (String window : currentWindows) {
                if(!window.equals(windowOne)) {
                    windowTwo = window;
                    break;
                }
            };

            // Переключение на окно с hash windowTwo для того, чтобы начать с ним работать
            driver.switchTo().window(windowTwo);
            driver.get("file:///C:/Users/%D0%90%D0%BB%D0%B5%D0%BA%D1%81%D0%B5%D0%B9/IdeaProjects/MarshalAutomation/src/main/java/index.html");

            // Закрытие текущей вкладки
            driver.close();
            // Открытие(переход) окна windowOne, с которым будет дальнейшая работа
            driver.switchTo().window(windowOne);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
     }
}

