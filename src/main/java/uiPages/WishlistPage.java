package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class WishlistPage extends BasePage {


    private static final String URL_PATH = "/wishlist";



    @FindBy(css = "td.wishlist-empty")
    private WebElement msgContainer;

    @FindBy(css =  "th.product-price")
    private WebElement unitPriceElem;

    @FindBy(css = "th.product-name")
    private  WebElement productNameElem;

    @FindBy(css = "th.product-stock-status")
    private WebElement stockStatusElem;

    @FindBy(css = "#yith-wcwl-row-1497")
    private WebElement firstWishlistItem;

    @FindBy (css = "#yith-wcwl-row-1491")
    private WebElement secondWishlistItem;

    @FindBy(css = ".product-remove .remove")
    private WebElement removeItemBtn;

    @FindBy(css = "#yith-wcwl-form .woocommerce-message")
    private WebElement successfullyRemovedItem;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
       // super.isCurrent();
        return areVisible(unitPriceElem, productNameElem, stockStatusElem);
    }

    @Override
    protected boolean isValid() {
      //  super.isValid();
        return areVisible(unitPriceElem, productNameElem, stockStatusElem);
    }


    public void open(){
        openUrl(BASE_URL + URL_PATH);
    }
    public String getWishlistMessage() {
        return WebElementHelper.getElementText(msgContainer);
    }

    public boolean isWishlistItemDisplayed(){
        return firstWishlistItem.isDisplayed();

    }
    public void clickRemoveBtn(){
        removeItemBtn.click();
    }



    public String getItemRemovedMsg(){
        return WebElementHelper.getElementText(successfullyRemovedItem);
    }

    public boolean areTwoElementsDIsplayed(){
        return areVisible(firstWishlistItem,stockStatusElem);
    }


}
