package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BookPage extends LoadableComponent<BookStorePage> {
    private static final By ADD_TO_COLLECTION = By.xpath("//div[@class = 'text-right fullButton']");
    private static final By GO_TO_BOOK_STORE = By.xpath("//div[@class = 'text-left fullButton']");
    private final WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(ADD_TO_COLLECTION));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(GO_TO_BOOK_STORE));


    }

    public BookPage addBook() {
        Allure.step("Добавляем книги");
        WebElement element = driver.findElement(ADD_TO_COLLECTION);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 600);
        actions.perform();
        element.click();
        return this;
    }


    public BookStorePage goToStore() {
        Allure.step("Нажимаем кнопку перейти в магазин");
        WebElement element = driver.findElement(GO_TO_BOOK_STORE);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 600);
        actions.perform();
        element.click();

        return new BookStorePage(driver);

    }
}
