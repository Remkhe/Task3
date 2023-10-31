package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;
    @BeforeAll
    public static void setUpAll(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setup (){ driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown (){
        if (driver != null){
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void openUrl (String url){
        driver.get(url);
    }
}

