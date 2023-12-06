package folder1;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Arrays;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");
        //String departureCity = testData.get("departure");
      // WebDriverManager.chromedriver().setup();

        WebDriverManager.firefoxdriver().setup();
       // ChromeOptions options =new ChromeOptions();
//        options.addArguments("profile.default_content_setting_values.cookies=1"); // 1: allow, 2: block
//        options.addArguments("profile.block_third_party_cookies=false");
        //options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        //ChromeOptions userProfile = new ChromeOptions();
//        userProfile.addArguments("profile.default_content_setting_values.cookies=1");
//        userProfile.addArguments("profile.block_third_party_cookies=false");
//        options.addArguments("user-data-dir=/path/to/profile");
        //options.setCapability("chrome.switches", Arrays.asList("--user-data-dir=/path/to/profile"));
//        options.setCapability("goog:chromeOptions", "{ \"args\": [\"--start-maximized\"] }");
//        options.setCapability("goog:chromeOptions", "{ \"args\": [\"--disable-popup-blocking\"] }");

        //WebDriver driver = new ChromeDriver();
        //driver.manage().deleteAllCookies();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //driver.manage().deleteAllCookies();
        // allow all cookies

//
        driver.get("https://www.skyscanner.co.in/");
        Thread.sleep(5000);
        //driver.findElement(By.id("acceptCookieButton")).click();
        driver.findElement(By.id("originInput-input")).clear();
        driver.findElement(By.id("originInput-input")).sendKeys("Krakow");
        WebElement element = driver.findElement(By.id("destinationInput-input"));
        element.sendKeys("India");

        element.sendKeys(Keys.RETURN);
         //driver.findElement(By.xpath("//*[contains(@value,'India')]")).click();



        WebElement date = driver.findElement(By.xpath("//*[contains(text(),'Depart')]"));
        String dateVal = "20-12-2023";
        selectDateBYJS(driver,date,dateVal);
        driver.close();
    }

    public static void selectDateBYJS(WebDriver driver,WebElement element, String dateVal){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
    }
}
