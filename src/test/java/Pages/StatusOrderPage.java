package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StatusOrderPage {
    private final SelenideElement status1 = $x("//div[contains(@class,\"Track_Order\")][contains(text(),\"Самокат на складе\")]");

    public Boolean checkPageExist(){
        status1.scrollTo();
        return status1.exists();
    }
}
