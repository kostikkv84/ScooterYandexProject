package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.*;


public class BaseTest {

    public final static String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    public void setUp(String PLATFORM_AND_BROWSER) {
        switch (PLATFORM_AND_BROWSER) {
            case "win_firefox":
                WebDriverManager.firefoxdriver().setup(); // Установили настройки драйвера
                Configuration.browser = "firefox";
                break;

            case "win_chrome":
                //    Configuration.driverManagerEnabled = true;

                // При получении ошибки 500 на версию chrome - обновляем WebDriverManager в Pom.xml

                WebDriverManager.chromedriver().setup();
                Configuration.browser = "chrome";
                Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito");
                Configuration.browserCapabilities = new ChromeOptions().addArguments("--disable-notifications");
                break;

            case "Selenoid":
                WebDriverManager.chromedriver().setup();
                Configuration.remote = "http://localhost:4444/wd/hub";
                Configuration.browser = "chrome";
                Configuration.baseUrl="https://qa-scooter.praktikum-services.ru/";
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                Configuration.browserCapabilities = capabilities;
            default:
                Assert.assertTrue("Платформа не корректна", true);
        }

        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.fileDownload = FileDownloadMode.FOLDER; // настройка для загрузки файлов - download()
    //    Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.fastSetValue=true;
    }

    @Before // перед тестами вызываем метод с типом платформы для запуска
    public void init() { setUp("win_chrome");  }

    @AfterEach
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
