package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class YandexMainPage {
    private final SelenideElement dzenLogo = $x("//span[@aria-label=\"Логотип Дзен\"]");

    public Boolean zdenLogoExist(){
        return dzenLogo.exists();
    }

}
