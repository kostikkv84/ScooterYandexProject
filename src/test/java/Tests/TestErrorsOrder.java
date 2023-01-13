package Tests;

import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class TestErrorsOrder extends BaseTest{
    /**
     * Проверка при вводе НЕ ВЕРНОГО имени.
     */
    @Test
    public void checkNameError(){
        Assert.assertTrue(new MainPage(BASE_URL).makeOrderButtonClick().checkErrorsMsg("Проверка имени"));
    }
    /**
     * Проверка при вводе НЕ ВЕРНОЙ фамилии.
     */
    @Test
    public void checkLastNameError(){
        Assert.assertTrue(new MainPage(BASE_URL).makeOrderButtonClick().checkErrorsMsg("Проверка фамилии"));
    }
    /**
     * Проверка при вводе НЕ ВЕРНОГО адреса.
     */
    @Test
    public void checkAddressError(){
        Assert.assertTrue(new MainPage(BASE_URL).makeOrderButtonClick().checkErrorsMsg("Проверка адреса"));
    }
    /**
     * Проверка при вводе НЕ ВЕРНОГО телефона.
     */
    @Test
    public void checkPhoneError(){
        Assert.assertTrue(new MainPage(BASE_URL).makeOrderButtonClick().checkErrorsMsg("Проверка телефона"));
    }
}
