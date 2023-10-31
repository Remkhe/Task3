package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginFormPage extends LoadableComponent<LoginFormPage> {

    private static final By FIELD_USERNAME = By.id("userName");
    private static final By FIELD_PASSWORD = By.id("password");
    private static final By AUTH_BUTTON = By.id("login");
    private final WebDriver driver;

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(visibilityOfElementLocated(FIELD_USERNAME));
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(visibilityOfElementLocated(FIELD_PASSWORD));
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(visibilityOfElementLocated(AUTH_BUTTON));

    }

    public LoginFormPage setUserName (String userName){
        Allure.step("Вводим логин");
        driver.findElement(FIELD_USERNAME).sendKeys(userName);
        return this;

    }

    public LoginFormPage setPassword(String password){
        Allure.step("Вводим пароль");
        driver.findElement(FIELD_PASSWORD).sendKeys(password);
        return this;
    }

    public MainPage clickAuthButton (){
        Allure.step("Нажимаем на авторизации");
        Allure.addAttachment("1",new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.findElement(AUTH_BUTTON).click();
        return new MainPage(driver);
    }
}
