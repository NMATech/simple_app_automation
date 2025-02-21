package stepdef;

import config.env;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;
import pagesObject.loginPage;
import pagesObject.registerPage;

public class stepdef extends env {
    @Given("^when user is in the page$")
    public void whenUserIsInThePage(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(website_url);

        loginPage page = new loginPage(driver);
        page.userIsInThePage();
    }

    @When("^user click register link$")
    public void userClickRegisterLink(){
        loginPage page = new loginPage(driver);
        page.clickRegisterTextLink();
    }

    @And("^user fill name (.*)$")
    public void userFillName(String name){
        registerPage page = new registerPage(driver);
        page.userFillName(name);
    }

    @And("^user fill age (.*)$")
    public void userFillAge(String age){
        registerPage page = new registerPage(driver);
        page.userFillAge(age);
    }

    @And("^user fill email (.*)$")
    public void userFillEmail(String email){
        registerPage page = new registerPage(driver);
        page.userFillEmail(email);
    }
    @And("^user fill phone (.*)$")
    public void userFillPhone(String phone){
        registerPage page = new registerPage(driver);
        page.userFillPhone(phone);
    }

    @And("^user fill pass (.*)$")
    public void userFillPass(String pass){
        registerPage page = new registerPage(driver);
        page.userFillPass(pass);
    }

    @Then("^user got message (.*)$")
    public void userGotMessage(String result){
        registerPage page = new registerPage(driver);
        if(result.equals("Register Success!")){
            page.userGotSuccessMessage();
        } else if(result.equals("Please include '@' in email address!")){
            page.errorDefaultInputElement("Format email");
        } else if(result.equals("Please fill out this field.")){
          page.errorDefaultInputElement("Empty field");
        } else {
            page.userGotErrorMessage(result, null);
        }
    }

    @And("user click register button")
    public void userClickRegisterButton() {
        registerPage page = new registerPage(driver);
        page.userClickRegistButton();
    }
}
