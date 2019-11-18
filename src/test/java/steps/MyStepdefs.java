package steps;

import Variables.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class MyStepdefs {

    private FirefoxDriver driver = new FirefoxDriver();
    private Id id = new Id();
    private URLs url = new URLs();
    private Xpaths xpath = new Xpaths();


    @Before
    public void before() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverManager.firefoxdriver().setup();
        driver.get(url.urlBase);
    }
@After
public void after(Scenario scenario){
    System.out.println("Scenario: " + scenario.getName() + "was tested") ;
        driver.quit();
}

    @Given("I enter log in page of Trello")
    public void iEnterLogInPageOfTrello() {
        driver.findElementByXPath(xpath.loginButton).click();
    }

    @And("I fill in login text box with registered login")
    public void iFillInLoginTextBoxWithRegisteredLogin() {
        driver.findElementByXPath(xpath.emailTextBox).sendKeys(Vars.eMail);
    }

    @And("I fill in password with registered password")
    public void iFillInPasswordWithRegisteredPassword() {
        driver.findElementById(id.passwordTextBox).sendKeys(Vars.password);
    }

    @When("I click on log in button")
    public void iClickOnLogInButton() {
        driver.findElementById(id.logInButton).click();
    }

    @Then("I am logged into Trello")
    public void iAmLoggedIntoTrello() {
        WebElement element = null;
        try {
            element = driver.findElementByXPath(xpath.addButton);
        } catch (Exception ignored) {
        }
        Assert.assertNotNull(element);
    }

    @And("I fill in password with incorrect password")
    public void iFillInPasswordWithIncorrectPassword() {
        driver.findElementById(id.passwordTextBox).sendKeys(Vars.invalidPassword);
    }


    @Then("I can see invalid password notification")
    public void iCanSeeInvalidPasswordNotification() {
        WebElement element = null;
        try {
            element = driver.findElementByXPath(xpath.errorMessage);
        } catch (NoSuchElementException ignored) {
        }
        Assert.assertNotNull(element);
    }
}
