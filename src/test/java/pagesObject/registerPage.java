package pagesObject;

import config.env;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class registerPage {
    WebDriver driver;

    public registerPage(WebDriver driver){
        this.driver = driver;
    }

    // web locator
    By elemenTextSignUp = By.xpath("//section/div/h1[contains(text(), 'Sign Up')]");
    By inputName = By.id("name");
    By inputAge = By.id("age");
    By inputEmail = By.id("email");
    By inputPhone = By.id("phone");
    By inputPass = By.id("password");
    By registerButton = By.id("btnRegister");
    By successRegisterPopup = By.xpath("//section/section/h1[contains(text(), 'Register Success!')]");
    By errorMessage = By.xpath("//*[@id=\"message\"]");
    By buttonSuccessRegist = By.xpath("//*[@id=\"btnContinue\"]");

    public WebDriverWait driverWait(){
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        return wait;
    }

    public void userIsInRegisterPage(){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(elemenTextSignUp)
        );
    }

    // action function
    public void userFillName(String name){
        WebElement element = driver.findElement(inputName);
        element.sendKeys(name);
    }
    public void userFillAge(String age){
        WebElement element = driver.findElement(inputAge);
        element.sendKeys(age);
    }
    public void userFillEmail(String email){
        WebElement element = driver.findElement(inputEmail);
        element.sendKeys(email);
    }
    public void userFillPhone(String phone){
        WebElement element = driver.findElement(inputPhone);
        element.sendKeys(phone);
    }
    public void userFillPass(String pass){
        WebElement element = driver.findElement(inputPass);
        element.sendKeys(pass);
    }
    public void userClickRegistButton(){
        WebElement element = driver.findElement(registerButton);
        element.click();
    }
    public void userGotErrorMessage(String result, String email){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.textToBe(errorMessage, result)
        );
    }
    public void errorDefaultInputElement(String test){
        WebDriverWait wait = driverWait();
        if(test == "Format email"){
            WebElement emailInput = driver.findElement(inputEmail);
            String errorMessage = emailInput.getAttribute("validationMessage");
            wait.until(driver -> !emailInput.getAttribute("validationMessage").isEmpty());
        } else if(test == "Empty field"){
            WebElement nameInput = driver.findElement(inputName);
            wait.until(driver -> !nameInput.getAttribute("validationMessage").isEmpty());
        }
    }

    public void userGotSuccessMessage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(successRegisterPopup)
        );

        WebElement element = driver.findElement(buttonSuccessRegist);
        element.click();
    }
}
