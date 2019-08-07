package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uiPages.BlogPage;
import uiPages.HomePage;
import uiPages.ShopPage;

public class HomePageTest extends BaseTest {

    private HomePage homePage = null;
    private ShopPage shopPage = null;
    private BlogPage blogPage = null;

    public static final String TESTIMONIAL_FIRST_DESCRIPTION = "STEPHANIE HILTON\nSALES MANAGER";
    public static final String TESTIMONIAL_SECOND_DESCRIPTION = "DIANA ROSIE\nCREATIVE DESIGNER";
    public static final String TESTIMONIAL_THIRD_DESCRIPTION = "JOHNNY WILLIAMS\nCHIEF MARKETING OFFICER";
    public static final int EXPECTED_NO_OF_PRODUCTS = 6;
    public static final int EXPECTED_NO_OF_BLOG_ITEMS = 4;

    @BeforeMethod
    void beforeMethod(){
        homePage = new HomePage(getDriver());
        shopPage = new ShopPage(getDriver());
        blogPage = new BlogPage(getDriver());
    }
    private void openHomePage(){
        homePage.open();
        homePage.verify();
    }

    @Test(description = "Verify if the correct descriptions are shown after clicking on a picture on Testimonial section.\n" +
            "Steps: " +
            "1." +
            "2." +
            "3. ")
    public void testCheckTestimonial(){
        openHomePage();
        homePage.clickFirstPicOnTestimonial();
        Assert.assertEquals(TESTIMONIAL_FIRST_DESCRIPTION, homePage.getFirstPicDescription(), "The author decription on testimonial is not correct.");
        homePage.clickSecondPicOnTEstimonial();
        Assert.assertEquals(TESTIMONIAL_SECOND_DESCRIPTION, homePage.getSecondPicDescription(), "The second description on testimonial is not correct.");
        homePage.clickThirdPicOnTestimonial();
        Assert.assertEquals(TESTIMONIAL_THIRD_DESCRIPTION, homePage.getThirdPicDescription(), "The third description on testimonial is not correct.");
    }

    @Test(description = "Verify if the home page is displayed correctly")
    void testTopContainerUi(){
        openHomePage();
        Assert.assertTrue(homePage.isTopContainerDisplayed(), "Top container is not displayed. ");
    }

    @Test(description =  "Check whether all 6 Product items are displayed on Home Page. ")
    void testNoOfProductDisplayed(){
        openHomePage();
        Assert.assertEquals(EXPECTED_NO_OF_PRODUCTS, homePage.countProducts(), "Incorrect number of products displayed on Home Page.");
    }

    @Test(description = "Check whether all 4 Blog items are displayed on Home Page.")
    void testBlogItems(){
        openHomePage();
        Assert.assertEquals(EXPECTED_NO_OF_BLOG_ITEMS, homePage.countBlogItems(), "The number of blog items on Home Page is not correct.");
    }

    @Test(description = "Test user is correctly redirected to a blog item")
    void testClickOnBlogItem(){
        openHomePage();
        homePage.clickOnFirstBlogItem();
        Assert.assertTrue( homePage.isFirstItemBlogPageDisplayed(),"The items Blog Page is not displayed when clicking on a blog item from Home Page.");
    }

    @Test(description = "Blog page is displayed after clicking on 'VIEW ALL BLOG' button displayed on Home Page.")
    public void clickViewAllBlogBtn(){
        openHomePage();
        homePage.clickViewAllBlogBtn();
        Assert.assertTrue(blogPage.isBlogPageDisplayed(), "Blog page is not displayed when clicking on VIEW ALL BLOG button from home page.");
    }

    @Test(description = "Shop Page should be displayed after clicking on 'SHOP NOW' button displayed on Home Page.")
    public void testShopNowBtn(){
        openHomePage();
        homePage.verify();
        homePage.clickShopNowBtn();
        Assert.assertTrue(shopPage.isShopPageDisplayed(), "The user is not redirected to Shop Page when clicking on 'SHOP NOW' button displayed on Home Page.");
    }







}
