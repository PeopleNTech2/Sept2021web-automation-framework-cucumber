package stefdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStepDef {

    WebDriver driver = new ChromeDriver();

    @Given("Enter the URL {string}")
    public void enter_the_url(String url) {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\PIIT_NYA\\IdeaProjects\\Web-Automation-Framework-Cucumber\\src\\drivers\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

    }
    @When("User clicks on ACCOUNT button")
    public void user_clicks_on_account_button() {
        driver.findElement(By.xpath("")).click();
    }
    @Then("User clicks on LOG IN button")
    public void user_clicks_on_log_in_button() {

    }
    @Then("User enters valid User ID")
    public void user_enters_valid_user_id() {

    }
    @Then("User enters valid Password")
    public void user_enters_valid_password() {

    }
    @Then("User click on LOGIN button")
    public void user_click_on_login_button() {

    }
}
