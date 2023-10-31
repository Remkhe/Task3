package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BookStorePage extends LoadableComponent<BookStorePage> {

    private final WebDriver driver;

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(By.id("see-book-Git Pocket Guide")));
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(By.id("see-book-Learning JavaScript Design Patterns")));
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(By.id("see-book-Designing Evolvable Web APIs with ASP.NET")));
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(By.id("see-book-Speaking JavaScript")));
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(By.id("see-book-You Don't Know JS")));
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(By.id("see-book-Programming JavaScript Applications")));
    }
   public BookPage goToBookPage(String bookid){
       Allure.step("Добавляем книги в коллекцию");
       driver.findElement(By.id(bookid)).click();
              return  new BookPage(driver);
    }

}
