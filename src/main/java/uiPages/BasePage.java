package uiPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;


public class BasePage extends WebUIPage {

  protected WebDriver  driver;
  protected final String BASE_URL = "http://shop.demoqa.com";
  protected static HeaderFooter headerFooter;

  public BasePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
    headerFooter = new HeaderFooter(driver);
  }

  @Override
  protected boolean isCurrent() {
    return headerFooter.isCurrent();
  }

  @Override
  protected boolean isValid() {
     return headerFooter.isValid();
  }
}
