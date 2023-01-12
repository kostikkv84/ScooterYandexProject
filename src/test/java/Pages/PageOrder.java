package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.getFocusedElement;

public class PageOrder {
    private final SelenideElement orderHeader = $x("//div[contains(text(),\"Для кого самокат\")]");
    private final SelenideElement nameBuyer = $x("//input[contains(@placeholder,\"* Имя\")]");
    private final SelenideElement correctNameMsg = $x("//input[contains(@placeholder,\"* Имя\")]//following-sibling::div");
    private final SelenideElement lastNameBuyer = $x("//input[contains(@placeholder,\"* Фамилия\")]");
    private final SelenideElement correctLastNameMsg = $x("//input[contains(@placeholder,\"* Фамилия\")]//following-sibling::div");
    private final SelenideElement adressBuyer = $x("//input[contains(@placeholder,\"* Адрес: куда привезти заказ\")]");
    private final SelenideElement correctAdressNameMsg = $x("//input[contains(@placeholder,\"* Адрес: куда привезти заказ\")]//following-sibling::div");
    private final SelenideElement phoneBuyer = $x("//input[contains(@placeholder,\"* Телефон: на него позвонит курьер\")]");
    private final SelenideElement correctPhoneNameMsg = $x("//input[contains(@placeholder,\"* Телефон: на него позвонит курьер\")]//following-sibling::div");
    private final SelenideElement chooseMetro = $x("//input[contains(@placeholder,\"* Станция метро\")]");
    private final SelenideElement nextButton = $x("//div[contains(@class,\"Order_NextButton\")]/button");



    /**
     * Контейнер страницы с проверкой отображения хедера
     */
    public PageOrder() { orderHeader.shouldBe(Condition.visible); }

    /**
     * Заполнение первой страницы заказа
     * @param name
     * @param lastName
     * @param adress
     * @param phone
     * @return
     */
    public AboutOrderPage makeOrder(String name, String lastName, String adress, String phone) {
        nameBuyer.sendKeys(name);
        lastNameBuyer.sendKeys(lastName);
        adressBuyer.sendKeys(adress);
        chooseMetro.sendKeys(Keys.DOWN);
        chooseMetro.sendKeys(Keys.ENTER);
        phoneBuyer.sendKeys(phone);
        nextButton.click();
        return new AboutOrderPage();
    }


}
