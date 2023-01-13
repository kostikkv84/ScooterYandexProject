package Tests;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import java.util.stream.Stream;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;


public class BaseTest {

    final static String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    public void setUp() {
       // WebDriverManager.chromedriver().setup(); // Установили настройки драйвера
       // Configuration.browser = "chrome";
        WebDriverManager.firefoxdriver().setup(); // Установили настройки драйвера
        Configuration.browser = "firefox";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
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
