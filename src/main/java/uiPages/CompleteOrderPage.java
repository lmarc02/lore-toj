package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class CompleteOrderPage extends BasePage {

    @FindBy(css = ".woocommerce-thankyou-order-received")
    private WebElement completeOrderMsg;

    public CompleteOrderPage(WebDriver driver) {
        super(driver);
    }

    public String getCompleteOrderMsg(){
        return WebElementHelper.getElementText(completeOrderMsg);
    }
    @Override
    protected boolean isCurrent() {
     //   super.isCurrent();
        return areVisible(completeOrderMsg);
    }

    @Override
    protected boolean isValid() {
      //  super.isValid();
        return areVisible(completeOrderMsg);
    }
}
