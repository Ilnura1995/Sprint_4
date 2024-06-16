import Pages.HomePage;
import Pages.OrderPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private String name;
    private String surname;
    private String address;
    private String phoneNumber;

    // Конструктор для инициализации тестовых данных из Parameterized.Parameters
    public OrderTest(String name, String surname, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Метод, который предоставляет тестовые данные для параметризованных тестов
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Генадий", "Паровозов", "Мичурина", "+7123123123"},
                {"Анна", "Иванова", "Ленина", "+7987654321"},
        };
    }

    // Тест для проверки заказа через верхнюю кнопку
    @Test
    public void topOrderButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnTopOrderButton(); // Нажатие на кнопку заказа на главной странице
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillTheData(name, surname, address, phoneNumber); // Заполнение данных на странице заказа
        Boolean actual = orderPage.isOrdered(); // Проверка успешности заказа
        Assert.assertTrue("Не удалось заказать самокат", actual); // Утверждение: заказ должен быть успешным
    }

    // Тест для проверки заказа через нижнюю кнопку
    @Test
    public void bottomOrderButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnBottomOrderButton(); // Нажатие на кнопку заказа внизу страницы
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillTheData(name, surname, address, phoneNumber); // Заполнение данных на странице заказа
        Boolean actual = orderPage.isOrdered(); // Проверка успешности заказа
        Assert.assertTrue("Не удалось заказать самокат", actual); // Утверждение: заказ должен быть успешным
    }
}
