package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static helpers.WebElementHelper.areVisible;

public class HomePage extends BasePage {



    @FindBy(css= "div.vc_column-inner.vc_custom_1465550709194")
    private WebElement firstForLadiesContainer;

    @FindBy(css = "div.tp-bgimg.defaultimg")
    private WebElement topContainer;

    @FindBy(xpath = "//a[contains(text(),'pink drop shoulder oversized t shirt')]")
    private WebElement firstWishlisElement;

    @FindBy(css = "div.yith-wcwl-add-to-wishlist.add-to-wishlist-1497")
    private WebElement firstWishlistBtn;

    @FindBy(css = ".yith-wcwl-add-to-wishlist.add-to-wishlist-1491")
    private WebElement secondWishlistBtn;

    @FindBy(css = ".cart-name-and-total")
    public WebElement cartLink;

    @FindBy(css = ".not_featured.post-1485")
    public WebElement homePageProduct;

    @FindBy(css = "[alt='0001937-100x100']")
    private WebElement firsPicOnTestimonial;

    @FindBy (css= "[alt='girl_meditation_pose_sea_wallpaper-100x100']")
    private WebElement secondPicOnTEstimonial;

    @FindBy (css = "[alt = 'team7-100x100']")
    private WebElement thirdPicOnTestimonial;

    @FindBy(css = ".testimonial-author")
    private List<WebElement> picDescriptionList;

    @FindBy(css = ".noo-product-thumbnail")
    List<WebElement> productList;

    @FindBy (css = ".noo-shblog-item.style_5")
    List<WebElement> listOfBlogItems;

    @FindBy (css = "#post-505")
    private WebElement blogItemContainer;



    @FindBy(css = ".custom_link")
    private WebElement viewAllBlogBtn;

    @FindBy(css = ".products")
    private WebElement mainShopContainer;

    @FindBy(css = "#slide-6-layer-9")
    private WebElement shopNowBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(topContainer);
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible(firstForLadiesContainer, firstWishlisElement);
    }

    public void open(){
        openUrl(BASE_URL);
    }

    public void clickWishlistBtnOnFirstProduct(){

        firstWishlistBtn.click();
    }

    public void clickWishlistBtnOnSecondProduct(){
        secondWishlistBtn.click();
    }
    public void clickCartLink(){
        cartLink.click();
    }

    public void clickProduct(){
        homePageProduct.click();
    }

    public void clickFirstPicOnTestimonial(){
        firsPicOnTestimonial.click();
    }

     public void clickSecondPicOnTEstimonial(){
        secondPicOnTEstimonial.click();
     }

     public void clickThirdPicOnTestimonial(){
        thirdPicOnTestimonial.click();
     }


    public String getFirstPicDescription(){
        WebElement first = picDescriptionList.get(0);
        return WebElementHelper.getElementText(first);
    }

    public String getSecondPicDescription(){
        WebElement second = picDescriptionList.get(1);
        return WebElementHelper.getElementText(second);
    }

    public String getThirdPicDescription(){
        WebElement third = picDescriptionList.get(2);
        return WebElementHelper.getElementText(third);
    }

    public int countProducts(){
        return productList.size();
    }

    public int countBlogItems(){
        return listOfBlogItems.size();
    }

    public void clickOnFirstBlogItem(){
        listOfBlogItems.get(0).click();
    }

    public boolean isFirstItemBlogPageDisplayed(){
        return WebElementHelper.areVisible(blogItemContainer);
    }



    public void clickShopNowBtn() {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn));
            element.click();
    }

    public void clickViewAllBlogBtn(){
        viewAllBlogBtn.click();
    }

    public boolean isTopContainerDisplayed(){
        return WebElementHelper.areVisible(topContainer);
    }


}
