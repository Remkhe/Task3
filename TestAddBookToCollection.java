package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.BookStorePage;
import pages.LoginFormPage;
import pages.MainPage;


public class TestAddBookToCollection extends BaseTest {

    private static String URL = "https://demoqa.com/login";
    private static String USERNAME = "EvgeniaRemkhe";
    private static String PASSWORD = "123QWEasdzxc!";

    private static String BOOK1 = "see-book-Git Pocket Guide";
    private static String BOOK2 = "see-book-Learning JavaScript Design Patterns";
    private static String BOOK3 = "see-book-Designing Evolvable Web APIs with ASP.NET";
    private static String BOOK4 = "see-book-Speaking JavaScript";
    private static String BOOK5 = "see-book-You Don't Know JS";
    private static String BOOK6 = "see-book-Programming JavaScript Applications";

    @Test
    @Description("Проверка добавления книг в коллекцию")
    public void testAddBookToCollection() {
        openUrl(URL);
        BookStorePage bookStorePage = new LoginFormPage(getDriver())
                .setUserName(USERNAME)
                .setPassword(PASSWORD)
                .clickAuthButton()
                .clickGoToStoreButton();
        bookStorePage.goToBookPage(BOOK1)
                .addBook()
                .goToStore();
        bookStorePage.goToBookPage(BOOK2)
                .addBook()
                .goToStore();
        bookStorePage.goToBookPage(BOOK3)
                .addBook()
                .goToStore();
        bookStorePage.goToBookPage(BOOK4)
                .addBook()
                .goToStore();
        bookStorePage.goToBookPage(BOOK5)
                .addBook()
                .goToStore();
        bookStorePage.goToBookPage(BOOK6)
                .addBook()
                .goToStore();
        MainPage mainPage = new MainPage(getDriver())
                .bookCollectionSize();
        Assert.assertEquals(6, mainPage.bookCollectionSize());
    }

}

