package pages;

import abstractPage.AbstractPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends AbstractPage {

    private String pageUrl = "https://www.saucedemo.com";

    public SelenideElement login = $("#user-name");
    public SelenideElement password = $("#password");
    public SelenideElement loginCTA = $("#login-button");
    public SelenideElement errorMessage = $x("//h3[@data-test='error']");

    public LoginPage enterUsername(String userName) {
        login.sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        password.sendKeys(pass);
        return this;
    }

    public LoginPage clickLoginCTA() {
        loginCTA.click();
        return this;
    }

    public String getErrorMessageText() {
        return errorMessage.getText().trim();
    }
}
