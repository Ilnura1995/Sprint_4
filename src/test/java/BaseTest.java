import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    // Метод, выполняемый перед каждым тестом для настройки WebDriver.
    @Before
    public void setUp() {
        // Получаем значение свойства "browser" (если оно указано), по умолчанию используем Chrome
        String browserName = System.getProperty("browser", "firefox");

        // Инициализация WebDriver в зависимости от выбранного браузера
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser specified: " + browserName);
        }

        // Открываем указанный URL
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().deleteAllCookies();
    }

//     Метод, выполняемый после каждого теста для закрытия WebDriver.
    @After
    public void cleanUp() {
        // Закрываем браузер и выходим из WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}

