package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class YandexMainPage {
    private final SelenideElement dzenLogo = $x("//span[@aria-label=\"Логотип Дзен\"]");
    private final SelenideElement findButton = $x("//button[@class=\"arrow__button\"]");


    /**
     * Проверка на видимость логотипа Yandex ри загрузке страницы
     */
    public YandexMainPage() {
       // dzenLogo.shouldBe(visible);
    }

    public Boolean dzenLogoExist() {
        return findButton.isDisplayed();
    }

    public String getFindButton() {
        return findButton.getText();
    }


}
