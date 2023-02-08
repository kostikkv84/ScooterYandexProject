package Tests;

import Pages.MainPage;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


/**
 * тесты вопросов с ответами
 */
public class TestQuestions extends BaseTest{

    @Test
    @DisplayName("Проверка ответа 1")
    public void testQuestion1 () {
        MainPage mainPage = new MainPage(BASE_URL);
        Boolean result = mainPage.setQuestions("Вопрос-1:");
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!", result);
        delay(1000);
    }

    @Test
    @DisplayName("Проверка ответа 2")
    public void testQuestion2 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-2:"));
    }
    @Test
    @DisplayName("Проверка ответа 3")
    public void testQuestion3 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-3:"));
    }
    @Test
    @DisplayName("Проверка ответа 4")
    public void testQuestion4 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-4:"));
    }
    @Test
    @DisplayName("Проверка ответа 5")
    public void testQuestion5 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-5:"));
    }
    @Test
    @DisplayName("Проверка ответа 6")
    public void testQuestion6 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-6:"));
    }
    @Test
    @DisplayName("Проверка ответа 7")
    public void testQuestion7 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-7:"));
    }
    @Test
    @DisplayName("Проверка ответа 8")
    public void testQuestion8 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-8:"));
    }
}
