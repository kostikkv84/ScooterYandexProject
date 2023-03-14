package Tests;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


public class BaseTest {

    public final static String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    public void setUp() {
        WebDriverManager.firefoxdriver().setup(); // Установили настройки драйвера
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.driverManagerEnabled = true;
        Configuration.headless = true;
        Configuration.fastSetValue=true;
    }

    @Before
    public void init() { setUp();  }

    @After
    public void tearDown (){
        Selenide.closeWebDriver();
    }

    public void delay(Integer timeToDelay){
        try {
            Thread.sleep(timeToDelay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
