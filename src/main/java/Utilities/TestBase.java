package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static Properties prop;

    public static WebDriver setUp() throws IOException {
        prop = new Properties();
        FileInputStream fs = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//java//resources//config.properties");
        prop.load(fs);
        WebDriver driver = null;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        switch (prop.getProperty("browser")) {
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            default:
                options.addArguments("incognito");
                //options.setHeadless(false);
                driver = new ChromeDriver(options);
                //driver = new ChromeDriver();
                break;
        }
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static void waitElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void waitForIframe(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void clickIfElementPresent(WebDriver driver, WebElement element) {
        if (isElementPresent(driver, element)) {
            waitElement(driver, element);
            element.click();
        }
    }

    public boolean isElementPresent(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

    public void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

}