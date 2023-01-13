package Tests;

import Pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


public class Tests extends BaseTest{

    @Test
    @EnabledOnOs({ OS.WINDOWS }) // тест запустится только на Windows
    public void checkMainPage(){
        Assert.assertTrue(new MainPage(BASE_URL).getHeader().contains("Самокат"));
    }
    /**
     * Проверка перехода по Самокат Logo на главную страницу
     */
    @Test
    public void checkSamokatLogoHref(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.checkLogoHref();
        System.out.println(mainPage.getHeaderPresents());
        Assert.assertTrue("Открылась стратовая страница",mainPage.getHeaderPresents());
    }
    /**
     * Проверка перехода по Yandex logo на сайт Yandex Dzen
     */
    @Test
    public void checkYandexLogoHref(){
        Assert.assertTrue("Открылся Yandex Dzen",new MainPage(BASE_URL).yandexLogoClick().zdenLogoExist());
    }

    /**
     * Проверка поиска НЕ ВЕРНОГО номера заказа
     */
    @Test
    public void checkSearchWrongOrderError(){
        Assert.assertTrue(new MainPage(BASE_URL).statusErrorOrderClick().checkErrorOrder());
    }

    /**
     * Проверка поиска ВЕРНОГО номера заказа
     */
    @Test
    public void checkSearchOrder(){
        Assert.assertTrue(new MainPage(BASE_URL).statusOrderClick().checkPageExist());
    }

    /**
     * Проверка формирования заказа. Ошибка на сайте, кнопка подтверждения заказа не кликабельна в Chrome
     */
    @Test
    public void makeOrderCustomer1(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.makeOrderButtonClick();
        OrderPage pageOrder = new OrderPage();
        pageOrder.makeOrderCustomers("Покупатель 1");
       // pageOrder.makeOrder(NAME_BUYER,LAST_NAME_BUYER,ADRESS_BUYER,PHONE_BUYER);
        AboutOrderPage aboutOrderPage = new AboutOrderPage();
        aboutOrderPage.enterDataInOrder();
        ConfirmOrderPage confirmOrder = new ConfirmOrderPage();
        confirmOrder.confirm();
        SuccessOrderPage successOrderPage = new SuccessOrderPage();
        System.out.println(successOrderPage.getOrderHeader());
        //проверка на то, что окно подтверждения заказа, при нажатии на копку "Да" закрыто.
        Assert.assertTrue("Заказ сформирован успешно", successOrderPage.getOrderHeader().contains("Заказ оформлен"));
        delay(1000);
    }


}
