package uiPages;

import helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Random;

import static helpers.WebElementHelper.areVisible;


public class CheckoutPage extends BasePage {

    public static final String CHECKOUT_TITILE = "CHECKOUT";

    @FindBy(css = ".page-title")
    private WebElement checkoutTitle;

    @FindBy(css = "#billing_first_name")
    private WebElement firstNameField;

    @FindBy(css = "#billing_last_name")
    private WebElement lastNameField;

    @FindBy(css = ".woocommerce-input-wrapper #select2-billing_country-container")
    private WebElement countryDropdownFArrow;

    @FindBy(css = "select#billing_country")
    private WebElement countryDropdown;

    @FindBy(css = "#billing_address_1")
    private WebElement addressField;

    @FindBy(css = "#billing_city")
    private WebElement cityField;

    @FindBy (css = "select#billing_state")
    private WebElement stateDropdown;

    @FindBy(css = "#billing_postcode")
    private WebElement postcodeField;

    @FindBy(css = "#billing_phone")
    private WebElement phoneField;

    @FindBy(css = "#billing_email")
    private WebElement emailField;

    @FindBy(css = "#terms")
    private WebElement termsCheckbox;

    @FindBy(css = ".woocommerce-billing-fields__field-wrapper")
    private WebElement formFieldsContainer;

    @FindBy(css = "#place_order")
    private WebElement placeOderBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCurrent() {
       // super.isCurrent();
        return areVisible(checkoutTitle);
    }

    @Override
    protected boolean isValid() {
       // super.isValid();
        return areVisible(checkoutTitle);
    }

    public void completeOrderWithValidData(){
        WebElementHelper.setFieldValue(firstNameField, "Test");
        WebElementHelper.setFieldValue(lastNameField, "Tester");
        Select countryOption = new Select(countryDropdown);
        countryOption.selectByVisibleText("Romania");
        WebElementHelper.setFieldValue(addressField, "Bucuresti");
        WebElementHelper.setFieldValue(cityField, "Cluj Napoca");
        Select cityOption = new Select(stateDropdown);
        cityOption.selectByVisibleText("Cluj");
        WebElementHelper.setFieldValue(postcodeField, "94301");
        WebElementHelper.setFieldValue(phoneField, "9898598948");
        WebElementHelper.setFieldValue(emailField, "test@email.com");
    }

    public void agreeTermsAndClickCheckbox(){
        termsCheckbox.click();
        placeOderBtn.click();
    }



}
