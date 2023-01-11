import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    final static String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    public void setUp(){
        /**
         * Настройки браузера и драйвера
         */
        System.setProperty("WebDriver.chrome.driver", "C:\\Users\\koskv\\ScooterYandexProject\\ChromeDriver.exe");
     //   WebDriverManager.chromedriver().setup();
        // Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1600x950";
        Configuration.headless =false;
    }

    @Before
    public void init() {setUp();}

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
