import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class Tests extends BaseTest{

    @Test
    public void checkMainPage(){
        MainPage mainPage = new MainPage(BASE_URL);
        Boolean contains = mainPage.getHeader().contains("Самокат");
        Assert.assertTrue(contains);
    }

    @Test
    public void makeOrder(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.makeOrderButtonClick();
    }

}
