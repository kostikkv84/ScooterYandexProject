package Tests;

import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class TestErrorsOrder extends BaseTest{
    /**
     * Проверка при вводе НЕ ВЕРНОГО имени.
     */
    @Test
    @DisplayName("Error - Имя")
    public void checkNameError(){
        Assert.assertTrue(new MainPage(BASE_URL).makeOrderButtonClick().checkErrorsMsg("Проверка имени"));
    }
    /**
     * Проверка при вводе НЕ ВЕРНОЙ фамилии.
     */
    @Test
    @DisplayName("Error - Фамилия")
    public void checkLastNameError(){
        Assert.assertTrue(new MainPage(BASE_URL).makeOrderButtonClick().checkErrorsMsg("Проверка фамилии"));
    }
    /**
     * Проверка при вводе НЕ ВЕРНОГО адреса.
     */
    @Test
    @DisplayName("Error - Адрес")
    public void checkAddressError(){
        Assert.assertTrue(new MainPage(BASE_URL).makeOrderButtonClick().checkErrorsMsg("Проверка адреса"));
    }
    /**
     * Проверка при вводе НЕ ВЕРНОГО телефона.
     */
    @Test
    @DisplayName("Error - Телефон")
    public void checkPhoneError(){
        Assert.assertTrue(new MainPage(BASE_URL).makeOrderButtonClick().checkErrorsMsg("Проверка телефона"));
    }
}
