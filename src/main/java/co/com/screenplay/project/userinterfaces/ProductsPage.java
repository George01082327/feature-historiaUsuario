package co.com.screenplay.project.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {
    public static final Target PAGE_TITLE = Target.the("Title of the products page")
            .locatedBy("//div[@class='product_label' and text()='Products']");
    public static final Target FIRST_ITEM_ADD_TO_CART_BUTTON = Target.the("Add to cart button for the first item")
            .locatedBy("(//button[@class='btn_primary btn_inventory'])[1]");
    public static final Target SECOND_ITEM_ADD_TO_CART_BUTTON = Target.the("Add to cart button for the second item")
            .locatedBy("(//button[@class='btn_primary btn_inventory'])[2]");
    public static final Target THIRD_ITEM_ADD_TO_CART_BUTTON = Target.the("Add to cart button for the third item")
            .locatedBy("(//button[@class='btn_primary btn_inventory'])[3]");
    public static final Target SHOPPING_CART_ICON = Target.the("Shopping cart icon")
            .locatedBy("//a[contains(@class, 'shopping_cart_link')]");
    public static final Target FIRST_NAME_FIELD = Target.the("First name field")
            .locatedBy("//input[@id='first-name']");
    public static final Target LAST_NAME_FIELD = Target.the("Last name field")
            .locatedBy("//input[@id='last-name']");
    public static final Target ZIP_CODE_FIELD = Target.the("Zip code field")
            .locatedBy("//input[@id='postal-code']");
    public static final Target CONTINUE_BUTTON = Target.the("Continue button")
            .locatedBy("//input[@class='btn_primary cart_button' and @value='CONTINUE']");
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button")
            .locatedBy("//a[@class='btn_action checkout_button']");
    public static final Target ITEM = Target.the("Item with name {0}")
            .locatedBy("//div[@class='inventory_item_name' and text()='{0}']");
}
