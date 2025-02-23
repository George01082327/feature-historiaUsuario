package co.com.screenplay.project.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ItemDetailsPage {
    public static final Target ITEM_PRICE = Target.the("Item price")
            .locatedBy("//div[@class='inventory_details_price']");
    public static final Target ITEM_DESCRIPTION = Target.the("Item description")
            .locatedBy("//div[@class='inventory_details_desc']");
}
