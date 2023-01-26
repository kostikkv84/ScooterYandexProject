package Tests.step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("Открываем сайт Yandex самокат {string}")
    public void openWebSite(String url) {
        Selenide.open(url);
    }
}
