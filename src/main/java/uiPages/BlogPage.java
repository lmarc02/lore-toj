package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;


public class BlogPage extends BasePage {

    public static final String BLOG_URL = "/blog/";

    @FindBy(css = ".noo-main ")
    private WebElement mainBlogContainer;

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
        super.isCurrent();
        return areVisible(mainBlogContainer);
    }

    @Override
    protected boolean isValid() {
        super.isValid();
        return areVisible(mainBlogContainer);
    }

    public boolean isBlogPageDisplayed(){
        return WebElementHelper.areVisible(mainBlogContainer);
    }

    public String getBlogPageUrl(){
        return BASE_URL + BLOG_URL;
    }
}
