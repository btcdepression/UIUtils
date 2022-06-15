package abstractPage;

import static com.codeborne.selenide.Selenide.open;
import static driver.ConfigurationManager.getDriver;
import static driver.ConfigurationManager.hasUrl;

public class AbstractPage {

    private String pageUrl = "https://www.saucedemo.com";

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void navigate() {
        open(getPageUrl());
    }

    public boolean checkPageUrl() {
        if (!hasUrl()) {
            return false;
        }
        return getPageUrl().equals(getDriver().getCurrentUrl());
    }
}
