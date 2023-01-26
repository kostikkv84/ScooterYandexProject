package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StatusOrderPage {
    private final SelenideElement status1 = $x("//button[contains(text(),\"Отменить заказ\")]");

    public Boolean checkPageExist() {
        status1.scrollTo();
        return status1.exists();
    }
}
