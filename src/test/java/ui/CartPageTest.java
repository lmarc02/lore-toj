package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uiPages.*;


public class CartPageTest extends BaseTest {
    private HomePage homePage = null;
    private CartPage cartPage = null;
    private CheckoutPage checkoutPage = null;
    private CompleteOrderPage completeOrderPage = null;
    private ProductDetailPage productDetailPage = null;
    private ShopPage shopPage = null;

    private static final String PAGE_TITLE = "CART";
    private static final String EMPTY_CART_MESSAGE = "Your cart is currently empty.";
    private static final String COMPLETE_ORDER_MSG = "Thank you. Your order has been received.";

    @BeforeMethod
    void beforeMethod() {
        this.homePage = new HomePage(getDriver());
        this.cartPage = new CartPage(getDriver());
        this.productDetailPage = new ProductDetailPage(getDriver());
        this.checkoutPage = new CheckoutPage(getDriver());
        this.completeOrderPage = new CompleteOrderPage(getDriver());
        this.shopPage = new ShopPage(getDriver());



    }

    public void openCartPage(){
        homePage.open();
        homePage.verify();
        homePage.clickHeaderCartLink();
        cartPage.verify();
    }

    public void addProductToCart(){
        homePage.open();
        homePage.verify();
        homePage.clickProduct();
        productDetailPage.verify();
        productDetailPage.selectColorFromDropdown();
        productDetailPage.selectSizeFromDropdown();
        productDetailPage.clickAddToCartBtn();
        productDetailPage.verify();
    }

    @Test(description = "Check the message and the number on Cart icon when the cart is empty.\n" +
                        "Steps:" +
                        "1. Open and verify Cart page.\n" +
                        "2. Click on header Cart icon and verify Cart Page.\n" +
                        "3. Check the Cart Page title text and the empty cart message text.'")
    public void testCartPageNoItems(){
        openCartPage();
        Assert.assertEquals(PAGE_TITLE, cartPage.getPageTitle(), "Cart Page title is not correct.");
        String getCartItemNo = cartPage.getCartItemNo();
        Assert.assertEquals("₹0.00", getCartItemNo, "Items on Cart Icon should be 0.");
        Assert.assertEquals(EMPTY_CART_MESSAGE, cartPage.getEmptyCartMsg(), "The empty Cart page message is not correct. ");
    }

    @Test(description = "Click on 'RETURN TO SHOP' button with no product in cart.\n" +
            "Steps:\n" +
            "1. Open and verify Cart page.\n" +
            "2. Click on header Cart icon and verify Cart Page.\n" +
            "3. Click on 'RETURN TO SHOP' button.\n" +
            "4. Shop Page should be displayed.")
    public void testClickReturnToShopBtn(){
        openCartPage();
        cartPage.clickReturnToShopBtn();
        shopPage.verify();
        Assert.assertTrue(shopPage.isShopPageDisplayed(), "Shop page is not displayed when clicking on 'RETURN TO SHOP' button.");
    }



    @Test(description = "After one product was added in the cart the number on Cart icon should be 1.\n")
    public void testAddProductToCart(){
        addProductToCart();
        Assert.assertEquals("1", productDetailPage.getNoOfItemsOnCart(), "The number of products from Cart should be 1.");
    }

    @Test(description = "Verify the confirmation message after an order was completed.")
    public void testOrderSubmitForProduct(){
        addProductToCart();
        productDetailPage.clickCartIcon();
        cartPage.verify();
        cartPage.clickProceedToCheckOut();
        checkoutPage.verify();
        checkoutPage.completeOrderWithValidData();
        checkoutPage.verify();
        checkoutPage.agreeTermsAndClickCheckbox();
        completeOrderPage.verify();
        Assert.assertEquals(COMPLETE_ORDER_MSG, completeOrderPage.getCompleteOrderMsg(), "Complete order message is not correct." );
    }







}
