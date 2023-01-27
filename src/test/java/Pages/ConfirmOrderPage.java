package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class ConfirmOrderPage {
    private final SelenideElement confirmOrderPageHeader = $x("//div[contains(@class,\"Order_ModalHeader\")]");
    private final SelenideElement confirmOrder = $x("//div[contains(@class,\"Order_Buttons\")]/button[contains(text(),\"Заказать\")]");
    private final SelenideElement cancellationOrder = $x("//div[contains(@class,\"Order_Buttons\")]/button[contains(text(),\"Назад\")]");

    /**
     * Конструктор класса проверяющий при загрузке наличие хедера на странице
     */
    public ConfirmOrderPage() {
        confirmOrderPageHeader.shouldBe(Condition.visible);
    }

    public SuccessOrderPage confirm() {
        confirmOrder.shouldBe(Condition.visible).sendKeys(Keys.ENTER);
        return new SuccessOrderPage();
    }

    public AboutOrderPage cancellation() {
        cancellationOrder.click();
        return new AboutOrderPage();
    }


    public Boolean orderHeaderPresent() {
        return confirmOrderPageHeader.isDisplayed();
    }
}
