package co.com.screenplay.project.tasks.products;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.screenplay.project.userinterfaces.ProductsPage.*;

public class SelectItem implements Task {
    private final String itemName;

    public SelectItem(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ITEM.of(itemName))
        );
    }

    public static SelectItem withName(String itemName) {
        return new SelectItem(itemName);
    }
}