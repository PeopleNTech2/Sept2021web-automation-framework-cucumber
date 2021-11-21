package stefdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginStepDef {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        //add to configuration: -Dwebdriver.chrome.driver="C:\\Users\\PIIT_NYA\\IdeaProjects\\Web-Automation-Framework-Cucumber\\src\\drivers\\chromedriver.exe"
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\PIIT_NYA\\IdeaProjects\\Web-Automation-Framework-Cucumber\\src\\drivers\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Given("user enters the URL {string} and amazon page pops up with title {string}")
    public void user_enters_the_url_and_amazon_page_pops_up_with_title(String url, String expectedTitle) {
        driver.get(url);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @When("user hovers over Account Lists")
    public void user_hovers_over_account_lists() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
    }
    @When("clicks on sign in button")
    public void clicks_on_sign_in_button() {
        driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();
    }
    @Then("sign in page with title {string} pops up")
    public void sign_in_page_with_title_pops_up(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Then("user enters username {string}")
    public void user_enters_username(String username) {
        driver.findElement(By.cssSelector("#ap_email")).sendKeys(username);
    }
    @Then("clicks on continue button")
    public void clicks_on_continue_button() {
        driver.findElement(By.cssSelector("#continue")).click();
    }
    @Then("user enters password {string}")
    public void user_enters_password(String password) {
        driver.findElement(By.cssSelector("#ap_password")).sendKeys(password);
    }
    @Then("clicks on login button")
    public void clicks_on_login_button() {
        driver.findElement(By.cssSelector("#signInSubmit")).click();
    }
    @Then("user name {string} should appear on the menu")
    public void user_name_should_appear_on_the_menu(String expectedName) {
        String actualName = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1")).getText();
        System.out.println("actual name: "+actualName);
        System.out.println("expected name: "+ expectedName);
        Assert.assertEquals(actualName, "Hello, "+expectedName);
        Assert.assertTrue(actualName.contains(expectedName));
    }
    @Then("error message with {string} is displayed")
    public void error_message_with_is_displayed(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.cssSelector(".a-list-item")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

}
