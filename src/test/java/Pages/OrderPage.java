package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {
    private final static String WRONG_DATA = "abc";
    // покупатель 1
    private final static String NAME_BUYER1 = "Иван";
    private final static String LAST_NAME_BUYER1 = "Вострецов";
    private final static String ADRESS_BUYER1 = "Москва, Белореченская, д.98";
    private final static String PHONE_BUYER1 = "+79785547896";
    // покупатель 2
    private final static String NAME_BUYER2 = "Ivan";
    private final static String LAST_NAME_BUYER2 = "Vostrecov";
    private final static String ADRESS_BUYER2 = "Moscow";
    private final static String PHONE_BUYER2 = "Number";
    private final SelenideElement orderHeader = $x("//div[contains(text(),\"Для кого самокат\")]");
    private final SelenideElement nameBuyer = $x("//input[contains(@placeholder,\"* Имя\")]");
    private final SelenideElement correctNameMsg = $x("//input[contains(@placeholder,\"* Имя\")]//following-sibling::div");
    private final String errorMessage1 = "Введите корректное имя";
    private final SelenideElement lastNameBuyer = $x("//input[contains(@placeholder,\"* Фамилия\")]");
    private final SelenideElement correctLastNameMsg = $x("//input[contains(@placeholder,\"* Фамилия\")]//following-sibling::div");
    private final String errorMessage2 = "Введите корректную фамилию";
    private final SelenideElement addressBuyer = $x("//input[contains(@placeholder,\"* Адрес: куда привезти заказ\")]");
    private final SelenideElement correctAddressMsg = $x("//input[contains(@placeholder,\"* Адрес: куда привезти заказ\")]//following-sibling::div");
    private final String errorMessage3 = "Введите корректный адрес";
    private final SelenideElement phoneBuyer = $x("//input[contains(@placeholder,\"* Телефон: на него позвонит курьер\")]");
    private final SelenideElement correctPhoneMsg = $x("//input[contains(@placeholder,\"* Телефон: на него позвонит курьер\")]//following-sibling::div");
    private final String errorMessage4 = "Введите корректный номер";
    private final SelenideElement chooseMetro = $x("//input[contains(@placeholder,\"* Станция метро\")]");
    private final SelenideElement nextButton = $x("//div[contains(@class,\"Order_NextButton\")]/button");


    /**
     * Контейнер страницы с проверкой отображения хедера
     */
    public OrderPage() {
        orderHeader.shouldBe(Condition.visible);
    }

    /**
     * Заполнение первой страницы заказа
     *
     * @param name
     * @param lastName
     * @param address
     * @param phone
     * @return
     */
    public AboutOrderPage makeOrder(String name, String lastName, String address, String phone) {
        nameBuyer.shouldBe(Condition.visible).sendKeys(name);
        lastNameBuyer.shouldBe(Condition.visible).sendKeys(lastName);
        addressBuyer.shouldBe(Condition.visible).sendKeys(address);
        chooseMetro.shouldBe(Condition.visible).sendKeys(Keys.DOWN);
        chooseMetro.shouldBe(Condition.visible).sendKeys(Keys.ENTER);
        phoneBuyer.shouldBe(Condition.visible).sendKeys(phone);
        nextButton.shouldBe(Condition.visible).click();
        return new AboutOrderPage();
    }

    public void makeOrderCustomers(String customer) {
        if ("Покупатель 1".equals(customer)) {
            makeOrder(NAME_BUYER1, LAST_NAME_BUYER1, ADRESS_BUYER1, PHONE_BUYER1);
        }
    }

    public boolean checkErrors(SelenideElement bayerData, String errorMessage, SelenideElement errorInputDataMsg) {
        bayerData.shouldBe(Condition.visible).sendKeys(WRONG_DATA);
        bayerData.shouldBe(Condition.visible).sendKeys(Keys.TAB);// вписываем в поле ошибочные данные для получения ошибки
        //errorInputDataMsg.should(Condition.exist).shouldBe(Condition.visible); // проверяем наличие элемента сообщения с ошибкой.
        //Проверяем: наличие элемента ответа, достаем текст, сравниваем его текст с ожидаемым текстом.
        return errorInputDataMsg.should(Condition.exist).shouldBe(Condition.visible).getText().contains(errorMessage);
    }

    public boolean checkErrorsMsg(String field) {
        switch (field) {
            case "Проверка имени":
                return checkErrors(nameBuyer, errorMessage1, correctNameMsg);
            case "Проверка фамилии":
                return checkErrors(lastNameBuyer, errorMessage2, correctLastNameMsg);
            case "Проверка адреса":
                return checkErrors(addressBuyer, errorMessage3, correctAddressMsg);
            case "Проверка телефона":
                return checkErrors(phoneBuyer, errorMessage4, correctPhoneMsg);
            default:
                return false;
        }
    }
}
