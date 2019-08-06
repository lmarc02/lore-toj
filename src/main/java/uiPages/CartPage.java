package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class CartPage extends BasePage{



    @FindBy (css = ".page-title")
    private WebElement pageTitle;

    @FindBy(css = ".cart-empty")
    private WebElement emptyCartMsg;

    @FindBy(css = ".button.wc-backward")
    private   WebElement returnToShopBtn;

    @FindBy(css=".woocommerce-Price-amount.amount")
    private WebElement cartItemNo;

    @FindBy(css = ".checkout-button.wc-forward")
    private WebElement proceedToCheckout;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(pageTitle);
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible(pageTitle);
    }



    public String getPageTitle(){
        return WebElementHelper.getElementText(pageTitle);
    }

    public String getEmptyCartMsg(){
        return WebElementHelper.getElementText(emptyCartMsg);
    }

    public String getCartItemNo(){
        return WebElementHelper.getElementText(cartItemNo);
    }

    public void clickProceedToCheckOut(){
        proceedToCheckout.click();
    }

    public void clickReturnToShopBtn(){
        returnToShopBtn.click();
    }
}

