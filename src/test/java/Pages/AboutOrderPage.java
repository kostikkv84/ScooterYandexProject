package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AboutOrderPage {
    private final static String COURIER_COMMENT = "Привезите самокат к подъезду";
    // Элементы на странице дополнительные данные для заказа
    private final SelenideElement aboutOrderHeader = $x("//div[contains(text(),\"Про аренду\")]");
    private final SelenideElement dataDeliveryInput = $x("//input[contains(@placeholder,\"* Когда привезти самокат\")]");
    private final SelenideElement nextDayDelivery = $x("//div[@class=\"react-datepicker\"]//div[contains(@class,\"day--today\")]//following-sibling::div");
    private final SelenideElement chooseDeadLineOrder = $x("//div[@class=\"Dropdown-control\"]");
    private final SelenideElement chooseDayCountOrder = $x("//div[@class=\"Dropdown-menu\"]//div[@class=\"Dropdown-option\"][last()]");
    private final SelenideElement blackScooter = $x("//div[contains(@class,\"Order_Checkboxes\")]/label[@for=\"black\"]");
    private final SelenideElement greyScooter = $x("//div[contains(@class,\"Order_Checkboxes\")]/label[@for=\"grey\"]");
    private final SelenideElement courierMsg = $x("//input[contains(@placeholder,\"Комментарий для курьера\")]");
    private final SelenideElement successOrder = $x("//div[contains(@class,\"Order_Buttons\")]/button[contains(text(),\"Заказать\")]");

    public AboutOrderPage() {
        aboutOrderHeader.shouldBe(Condition.visible);
    }

    public ConfirmOrderPage enterDataInOrder() {
        dataDeliveryInput.click();
        nextDayDelivery.click();
        chooseDeadLineOrder.click();
        chooseDayCountOrder.click();
        blackScooter.click();
        greyScooter.click();
        courierMsg.sendKeys(COURIER_COMMENT);
        successOrder.click();
        return new ConfirmOrderPage();
    }
}
