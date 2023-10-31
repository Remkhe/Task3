package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.LoginFormPage;
import pages.MainPage;



public class TestLogin extends BaseTest {

    private static String URL = "https://demoqa.com/login";
    private static String USERNAME = "EvgeniaRemkhe";
    private static String PASSWORD = "123QWEasdzxc!";

    @Test
    @Description("Проверка успешной авторизации")
    public void testAuthForm (){
        openUrl(URL);
        MainPage mainPage = new LoginFormPage(getDriver())
                .setUserName(USERNAME)
                .setPassword(PASSWORD)
                .clickAuthButton();
        Assert.assertFalse(mainPage.isBookIntable());

    }

}
