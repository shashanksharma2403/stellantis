package StepDef;
import Utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class validateTestSteps {
    private TestBase testBase;
    private WebDriver driver;
    @Given("user launches the browser")
    public void user_launches_the_browser() throws InterruptedException, IOException {
        // Write code here that turns the phrase above into concrete actions
        driver = TestBase.setUp();
        driver.get(TestBase.prop.getProperty("baseurl"));
        Thread.sleep(5000);
        driver.findElement(By.id("acceptCookieButton")).click();
    }
    @Given("user Fill in From city")
    public void user_fill_in_from_city() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Given("user Fill in To city")
    public void user_fill_in_to_city() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user Select the departure and return date")
    public void user_select_the_departure_and_return_date() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user Select the travellers")
    public void user_select_the_travellers() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("user should see flight information")
    public void user_should_see_flight_information() {
        // Write code here that turns the phrase above into concrete actions
    }

}
