package Tests;

import Pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


public class Tests extends BaseTest{
    private final static String NAME_BUYER = "Иван";
    private final static String LAST_NAME_BUYER = "Вострецов";
    private final static String ADRESS_BUYER = "Москва, Белореченская, д.98";
   // private final static String METRO_BUYER = "Курская";
    private final static String PHONE_BUYER = "+79785547896";
    private final static String EXPECTED_PRICE_AND_PAY = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";


    @Test
    @EnabledOnOs({ OS.WINDOWS }) // тест запустится только на WIndows
    public void checkMainPage(){

        MainPage mainPage = new MainPage(BASE_URL);
        Boolean contains = mainPage.getHeader().contains("Самокат");
        Assert.assertTrue(contains);
    }

    /**
     * Проверка перехода по логотипу на главную страницу
     */
    @Test
    public void checkSamokatLogo(){
        MainPage mainPage = new MainPage(BASE_URL);

    }

    /**
     * Проверка формирования заказа. Ошибка на сайте, кнопка подтверждения заказа не кликабельна.
     */
    @Test
    public void makeOrder(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.makeOrderButtonClick();
        PageOrder pageOrder = new PageOrder();
        pageOrder.makeOrder(NAME_BUYER,LAST_NAME_BUYER,ADRESS_BUYER,PHONE_BUYER);
        AboutOrderPage aboutOrderPage = new AboutOrderPage();
        aboutOrderPage.enterDataInOrder("Привезите самокат к подъезду");
        ConfirmOrderPage confirmOrder = new ConfirmOrderPage();
        confirmOrder.confirm();
        SuccessOrderPage successOrderPage = new SuccessOrderPage();
        System.out.println(successOrderPage.getOrderHeader());
        //проверка на то, что окно подтверждения заказа, при нажатии на копку "Да" закрыто.
        Assert.assertTrue("Заказ сформирован успешно", successOrderPage.getOrderHeader().contains("Заказ оформлен"));
        delay(1000);
    }

}
