package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    // Конструктор класса HomePage, который вызывает конструктор суперкласса BasePage
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // XPath-локаторы для элементов выпадающего списка
    private String dropDownItems = ".//div[@id='accordion__heading-%d']";
    private String dropDownText = ".//div[@id='accordion__panel-%d']";

    // Находим элементы страницы с помощью аннотации @FindBy и XPath-локаторов
    @FindBy(xpath = ".//button[@class='Button_Button__ra12g']")
    private WebElement topOrderButton;

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement bottomOrderButton;

    // Метод для клика на элемент выпадающего списка по его индексу
    public void clickOnDropDownItems(int itemIndex) {
        // Явное ожидание в течение 30 секунд
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Ожидание появления элемента dropDownItems
        WebElement dropDownItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dropDownItems, itemIndex))));
        // Прокрутка к элементу, если он находится за пределами видимости
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropDownItem);
        // Клик по элементу
        dropDownItem.click();
    }

    // Метод для получения текста из элемента выпадающего списка по его индексу
    public String getCorrectTextFromDropItems(int itemIndex) {
        return driver.findElement(By.xpath(String.format(dropDownText, itemIndex))).getText();
    }

    // Метод для клика на кнопку "Заказать" вверху страницы
    public OrderPage clickOnTopOrderButton() {
        topOrderButton.click();
        return new OrderPage(driver); // Возвращает новый экземпляр страницы OrderPage
    }

    // Метод для клика на кнопку "Заказать" внизу страницы
    public OrderPage clickOnBottomOrderButton() {
        scrollToElement(bottomOrderButton); // Прокрутка к кнопке "Заказать" внизу страницы
        bottomOrderButton.click(); // Клик по кнопке "Заказать"
        return new OrderPage(driver); // Возвращает новый экземпляр страницы OrderPage
    }

    // Прокрутка к указанному элементу на странице
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
