package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".products.noo-row")
    private WebElement mainContainer;
    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(mainContainer);
    }

    @Override
    protected boolean isValid() {
         super.isValid();
        return areVisible(mainContainer);
    }
    public boolean isShopPageDisplayed(){
        return WebElementHelper.areVisible(mainContainer);
    }

}
