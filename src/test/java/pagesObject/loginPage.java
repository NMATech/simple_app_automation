package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    // web locator
    By elemenTextSignIn = By.xpath("//section/div/h1[contains(text(), 'Sign In')]");
    By registerTextLink = By.xpath("//section/p/a[contains(text(), 'Here')]");

    public WebDriverWait driverWait(){
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        return wait;
    }

    public void userIsInThePage(){
        WebDriverWait wait = driverWait();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(elemenTextSignIn)
        );
    }

    // action function
    public void clickRegisterTextLink(){
        WebElement element = driver.findElement(registerTextLink);
        element.click();
        registerPage page = new registerPage(driver);
        page.userIsInRegisterPage();
    }
}
