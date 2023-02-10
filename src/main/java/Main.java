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

        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);

            WebElement element_drag = driver.findElement(By.id("draggable"));
            WebElement element_drop = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);

//            actions.moveToElement(element_drag)
//                    .clickAndHold()
//                    .moveToElement(element_drop)
//                    .release()
//                    .perform();
            // Простой вариант
            actions.dragAndDrop(element_drag, element_drop);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(20000);
            driver.quit();
        }



//        actions
//                .pause()                // Пауза на заданное время
//                .moveToElement()        // Наведение курсора мыши
//                .keyDown()              // Нажатие на кнопку
//                .keyUp()                // Отжтмаем клик
//                .clickAndHold()         // Нажать и держать
//                .release()              // Отпускить клик
//                .build()                // Собрать все примененные действия
//                .perform();             // Применение билда



    }

}
