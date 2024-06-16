package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage extends BasePage {

    // Конструктор класса OrderPage, который вызывает конструктор суперкласса BasePage
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    // Находим элементы страницы с помощью аннотации @FindBy и XPath-локаторов
    @FindBy(xpath = ".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']")
    private WebElement nameInput;
    @FindBy(xpath = ".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']")
    private WebElement surnameInput;
    @FindBy(xpath = ".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']")
    private WebElement addressInput;
    @FindBy(xpath = ".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']")
    private WebElement phoneNumberInput;
    @FindBy(className = "select-search__input")
    private WebElement dropDownOfStations;
    @FindBy(xpath = ".//div[text()='Черкизовская']")
    private WebElement station;
    @FindBy(xpath = ".//div[@class='Order_NextButton__1_rCA']/button")
    private WebElement nextButton;
    @FindBy(xpath = ".//input[@placeholder='* Когда привезти самокат']")
    private WebElement whenToBringTheScooter;
    @FindBy(xpath = ".//div[@aria-label='Choose воскресенье, 16-е июня 2024 г.']")
    private WebElement datePopUp;
    @FindBy(xpath = ".//div[@aria-haspopup='listbox']/div[1]")
    private WebElement rentTimeDropDown;
    @FindBy(xpath = ".//div[@class='Dropdown-option' and text()='трое суток']")
    private WebElement rentTime;
    @FindBy(xpath = ".//input[@id='black']")
    private WebElement choseBlack;
    @FindBy(xpath = ".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")
    private WebElement orderButton;
    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']")
    private WebElement yesConfirmation;
    @FindBy(xpath = ".//*[text()='Заказ оформлен']")
    private WebElement finalOrderText;

    // Метод для заполнения данных на странице заказа
    public void fillTheData(String name, String surname, String address, String phoneNumber) {
        nameInput.sendKeys(name); // Ввод имени
        surnameInput.sendKeys(surname); // Ввод фамилии
        addressInput.sendKeys(address); // Ввод адреса
        dropDownOfStations.click(); // Клик на выпадающем списке станций
        station.click(); // Выбор станции
        phoneNumberInput.sendKeys(phoneNumber); // Ввод номера телефона
        nextButton.click(); // Клик на кнопке "Далее"
        whenToBringTheScooter.click(); // Выбор даты доставки самоката
        datePopUp.click(); // Выбор конкретной даты
        rentTimeDropDown.click(); // Клик на выпадающем списке срока аренды
        rentTime.click(); // Выбор срока аренды
        choseBlack.click(); // Выбор черного цвета
        orderButton.click(); // Клик на кнопке "Заказать"
        yesConfirmation.click(); // Подтверждение заказа
    }

    // Метод для проверки успешности заказа на основе текста на странице
    public Boolean isOrdered() {
        // Явное ожидание в течение 30 секунд
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Ожидание появления текста "Заказ оформлен" в элементе finalOrderText
        wait.until(ExpectedConditions.textToBePresentInElement(finalOrderText, "Заказ оформлен"));
        // Проверяем, содержит ли текст элемент finalOrderText фразу "Заказ оформлен"
        return finalOrderText.getText().contains("Заказ оформлен");
    }
}
