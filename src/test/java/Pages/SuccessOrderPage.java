package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.bouncycastle.math.ec.custom.sec.SecT113FieldElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessOrderPage {
    private final SelenideElement successHeader = $x("//div[contains(@class,'Order_ModalHeader')]");

    public SuccessOrderPage() {
        successHeader.shouldBe(Condition.visible);
    }

    public String getOrderHeader (){
        return successHeader.getText(); // - Заказ оформлен
    }


}
