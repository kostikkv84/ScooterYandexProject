package Tests;

import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class TestQuestions extends BaseTest{

    @Test
    public void testQuestion1 () {
        MainPage mainPage = new MainPage(BASE_URL);
        Boolean result = mainPage.setQuestions("Вопрос-1:");
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!", result);
        delay(1000);
    }

    @Test
    public void testQuestion2 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-2:"));
    }
    @Test
    public void testQuestion3 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-3:"));
    }
    @Test
    public void testQuestion4 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-4:"));
    }
    @Test
    public void testQuestion5 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-5:"));
    }
    @Test
    public void testQuestion6 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-6:"));
    }
    @Test
    public void testQuestion7 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-7:"));
    }
    @Test
    public void testQuestion8 (){
        Assert.assertTrue("Ответ совпадает с ожидаемым результатом!" ,new MainPage(BASE_URL).setQuestions("Вопрос-8:"));
    }
}
