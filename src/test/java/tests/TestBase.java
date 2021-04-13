package tests;

import com.codeborne.selenide.Configuration;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static helpers.AttachmentHelper.*;

public class TestBase {
    @BeforeAll
    static void setup() {
        //Allure's listener adds screenshot and page source after every failed test by default
        addListener("AllureSelenide", new AllureSelenide());
        //Allure's environment settings
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "89.0.4389.90")
                        .put("URL", "http://aburov.local8808.net")
                        .build(), System.getProperty("user.dir")
                        + "/build/allure-results/");
        /**
         * Remote browser can be used in Jenkins for Selenoid UI
         * @param -Dremote.driver=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -Dbrowser.select=firefox
         * @see Local and Selenoid run settings
         */
        Configuration.browser = System.getProperty("browser.select", "chrome");
        Configuration.browserSize = "1024x768";
        if (System.getProperty("remote.driver") != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = System.getProperty("remote.driver");
        }
    }

    @AfterEach
    void customAttachments() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        //Video can be attached to Allure report if video.storage = true
        String videoStorage = System.getProperty("video.storage");
        if (videoStorage != null) {
            attachVideo();
        }
        closeWebDriver();
    }
}