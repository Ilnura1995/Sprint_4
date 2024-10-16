package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Базовый класс страницы, хранящий экземпляр WebDriver.
public class BasePage {
    protected WebDriver driver;


    // Конструктор класса BasePage для инициализации WebDriver.
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
