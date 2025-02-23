package co.com.screenplay.project.tasks.products;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.userinterfaces.ProductsPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart  implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FIRST_ITEM_ADD_TO_CART_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(FIRST_ITEM_ADD_TO_CART_BUTTON),
                WaitUntil.the(SECOND_ITEM_ADD_TO_CART_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SECOND_ITEM_ADD_TO_CART_BUTTON),
                WaitUntil.the(THIRD_ITEM_ADD_TO_CART_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(THIRD_ITEM_ADD_TO_CART_BUTTON)
        );
    }

    public static AddToCart items() {
        return new AddToCart();
    }
}
