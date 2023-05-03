package g214.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import g214.tests.helpers.Attach;
import g214.tests.pages.RegistrationPage;

import java.util.Map;


public class TestBase extends TestData {
    RegistrationPage registrationPage = new RegistrationPage();

    static config.WebDriverConfig webDriverConfig = ConfigFactory.create(config.WebDriverConfig.class, System.getProperties());


    @BeforeAll
    static void beforeall() {
        Configuration.browser =  System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        Configuration.pageLoadStrategy = "eager";

        if (webDriverConfig.getRemoteUrl() != null && !webDriverConfig.getRemoteUrl().isBlank()) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }

        @BeforeEach
        void addListener() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        }

        @AfterEach
        void addAttachments() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }


    }


}