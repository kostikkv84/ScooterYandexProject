package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WrongOrderSearchPage {
    private final SelenideElement orderNotFound = $x("//img[@alt=\"Not found\"]");

    public Boolean checkErrorOrder() {
        return orderNotFound.exists();
    }

}
