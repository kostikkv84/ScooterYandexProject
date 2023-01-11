package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement header = $x("//div[contains(text(),\"Самокат \")]");
    private final SelenideElement orderButtonHeader = $x("//div[contains(@class,\"Header_Nav\")]/button[contains(text(),\"Заказать\")]");
    private final SelenideElement orderStatus = $x("//button[contains(text(),\"Статус заказа\")]");

    public MainPage(String url) {
        Selenide.open(url);
        header.shouldBe(Condition.visible);
    }

    public String getHeader(){
        return header.getText();
    }

    public PageOrder makeOrderButtonClick () {
        orderButtonHeader.click();
        return new PageOrder();
    }

}
