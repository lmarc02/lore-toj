package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uiPages.HomePage;
import uiPages.ProductDetailPage;
import uiPages.WishlistPage;

public class WishlistTest extends BaseTest {

    private WishlistPage wishlistPage = null;
    private ProductDetailPage productDetailPage = null;
    private HomePage homePage = null;
    private static final String NO_PRODUCT_TO_WISHLIST_MSG = "NO PRODUCTS WERE ADDED TO THE WISHLIST";
    private static final String ELEMENT_REMOVED_MESSAGE = "Product successfully removed.";

    @BeforeMethod
    void beforeMethod() {
        this.homePage = new HomePage(getDriver());
        this.wishlistPage = new WishlistPage(getDriver());
        this.productDetailPage = new ProductDetailPage(getDriver());
    }
    public void addOneItemToWishlist(){
        homePage.open();
        homePage.verify();
        homePage.clickWishlistBtnOnFirstProduct();
        homePage.verify();
    }

    public void openWishlist(){
        this.wishlistPage.open();
        this.wishlistPage.verify();
    }



    @Test
    public void testNoItemsOnWishlist(){
        openWishlist();
        Assert.assertEquals(NO_PRODUCT_TO_WISHLIST_MSG, this.wishlistPage.getWishlistMessage(), "NO PRODUCTS WERE ADDED TO THE WISHLIST message is not displayed correctly. ");
    }


    @Test
    public void addItemsToWishlist(){
        addOneItemToWishlist();
        openWishlist();
        Assert.assertTrue(wishlistPage.isWishlistItemDisplayed(),  "The wishList element is not displayed.");
    }

    @Test
    public void addTwoItemsToWishlist(){
        addOneItemToWishlist();
        homePage.clickWishlistBtnOnSecondProduct();
        openWishlist();
        Assert.assertTrue(wishlistPage.areTwoElementsDIsplayed(), "The two items on Wishlist are not displayed.");
    }

    @Test
    public void removeItemFromWishlist(){
        addOneItemToWishlist();
        openWishlist();
        wishlistPage.clickRemoveBtn();
        wishlistPage.verify();
        Assert.assertEquals(ELEMENT_REMOVED_MESSAGE, wishlistPage.getItemRemovedMsg(), "The successfully removed item message from Wishlist page is not correct");
    }





}
