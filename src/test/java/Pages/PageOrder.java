package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PageOrder {
    private final SelenideElement orderHeader = $x("//div[contains(text(),\"Для кого самокат\")]");
    private final SelenideElement nameBuyer = $x("//input[contains(@placeholder,\"* Имя\")]");
    private final SelenideElement correctNameMsg = $x("//input[contains(@placeholder,\"* Имя\")]//following-sibling::div");



    /**
     * Контейнер страницы с проверкой отображения хедера
     */
    public PageOrder() { orderHeader.shouldBe(Condition.visible); }

    public void makeOrder() {

    }


}
