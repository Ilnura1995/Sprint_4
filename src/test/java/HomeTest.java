import Pages.HomePage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

// Класс для тестирования домашней страницы, параметризованный для использования различных тестовых данных.
@RunWith(Parameterized.class)
public class HomeTest extends BaseTest {

    // Переменные для хранения индекса элемента и ожидаемого текста для параметризованных тестов.
    int itemIndex;
    String expectedText;

    // Конструктор класса, инициализирующий переменные itemIndex и expectedText.
    public HomeTest(int itemIndex, String expectedText) {
        this.itemIndex = itemIndex;
        this.expectedText = expectedText;
    }

    // Метод, возвращающий массив с тестовыми данными для параметризации теста.
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    // Тест для проверки текста элементов на домашней странице.
    @Test
    public void testItemsText() {
        HomePage homePage = new HomePage(driver);

        // Шаг 1: Нажать на элемент выпадающего списка с заданным индексом.
        homePage.clickOnDropDownItems(itemIndex);

        // Шаг 2: Получить текст элемента и сравнить его с ожидаемым результатом.
        String actualText = homePage.getCorrectTextFromDropItems(itemIndex);
        Assert.assertEquals("Text does not match for item " + itemIndex, expectedText, actualText);
    }
}
