package co.com.screenplay.project.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutOverviewPage {
       public static final Target SAUCE_LABS_BOLT_TSHIRT = Target.the("Sauce Labs Bolt T-Shirt")
            .locatedBy("//div[@class='inventory_item_name' and text()='Sauce Labs Bolt T-Shirt']");
    public static final Target FINISH_BUTTON = Target.the("Finish button")
            .locatedBy("//a[@class='btn_action cart_button' and @href='./checkout-complete.html']");
}
