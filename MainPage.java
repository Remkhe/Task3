package pages;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends LoadableComponent<MainPage> {

    private static final By USER_NAME = By.id("userName-value");

    private static final By GO_TO_STORE_BUTTON = By.xpath("//div[@class='text-left button']");
    private static final By ANY_BOOK = By.xpath("//a[contains(@href,'profile?book')]");
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(USER_NAME));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(TABLE_ELEMENT));


    }

    private WebDriver getWebDriver() {
        return driver;
    }

    public String getUserName() {
        return driver.findElement(USER_NAME).getText();
    }



    public BookStorePage clickGoToStoreButton() {
        Allure.step("Нажимаем кнопку ");
        WebElement element = driver.findElement(GO_TO_STORE_BUTTON);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,600);
        actions.perform();
        element.click();
        return new BookStorePage(driver);



    }
    public  MainPage bookCollectionSize(){
        Allure.step("Проверяем, список книг в таблице");
        int bookCollectionSize = driver.findElements(GO_TO_STORE_BUTTON).size();
        return this;

    }

    public boolean isBookIntable() {
        Allure.step("Проверяем, есть ли книги в таблице");
        try {
            driver.findElement(ANY_BOOK);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

