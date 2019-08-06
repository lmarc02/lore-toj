package uiPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static helpers.WebElementHelper.areVisible;

public class ProductDetailPage extends BasePage {


    @FindBy (css = "h1.product_title")
    private WebElement productTitle;

    @FindBy (css = "p.price")
    private WebElement productPrice;

    @FindBy (css = "div.noo-woo-all-images-wrap")
    private WebElement productImg;

    @FindBy (css = ".entry-summary [class*='add-to-wishlist']")
    private WebElement detailPageWishlistBtn;


    @FindBy(css = "td.product-thumbnail")
    private WebElement wishlistProductItemDisplayed;

    @FindBy(css = ".pull-right a[href*='com/wishlist']")
    private WebElement myWishlistLink;

    @FindBy (css = "select#pa_color")
    private WebElement oprionColorBtn;

    @FindBy(css = "#pa_size")
    private WebElement optionSizeBtn;

    @FindBy (css = ".single_add_to_cart_button")
    private WebElement addToCartBtn;

    @FindBy(css = "span.cart-name-and-total")
    private WebElement noOfItemsOnCart;

    @FindBy(css = ".icon_bag_alt")
    private WebElement cartBagIcon;


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }




    @Override
    protected boolean isCurrent() {
      //  super.isCurrent();
        return areVisible(productTitle, productPrice, productImg);
    }

    @Override
    protected boolean isValid() {
     //   super.isValid();
        return areVisible(detailPageWishlistBtn);
    }

    public void clickWishlistBtn(){

        detailPageWishlistBtn.click();
    }

    public boolean isProductItemDisplayed(){
        return wishlistProductItemDisplayed.isDisplayed();
    }

    public void clickMyWishlistLink() {
        this.myWishlistLink.click();
    }

    public void selectColorFromDropdown() {
        Select colorDropdown = new Select(oprionColorBtn);
        colorDropdown.selectByVisibleText("Black");
    }

    public void selectSizeFromDropdown(){
        Select sizeDropdown = new Select(optionSizeBtn);
        List<WebElement> l = sizeDropdown.getOptions();
//        Random r = new Random();
//        int min = 1;
//        int max = l.size()-1;
//        int result =  r.ints(min, (max + 1)).findFirst().getAsInt();
//        sizeDropdown.selectByIndex(result);
        sizeDropdown.selectByIndex(getRandomNumberInRange(1, l.size()-1));
    }




    public void clickAddToCartBtn(){
        addToCartBtn.click();
    }

    public String getNoOfItemsOnCart(){
        //return WebElementHelper.getElementText(noOfItemsOnCart);
        String cart = noOfItemsOnCart.getText();
        String numberOfProducts = "0";
        for (int i = 0; i < cart.length(); i++) {
            if (Character.isDigit(cart.charAt(i))) {
                numberOfProducts = Character.toString(cart.charAt(i));
                break;
            }

        }

        return numberOfProducts;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void clickCartIcon(){
        cartBagIcon.click();
    }

}
