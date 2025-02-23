package co.com.screenplay.project.tasks.products;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.userinterfaces.ProductsPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToCartAndCheckout implements Task {
    private final String firstName;
    private final String lastName;
    private final String zip;

    public GoToCartAndCheckout(String firstName, String lastName, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zip = zip;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SHOPPING_CART_ICON),
                WaitUntil.the(SHOPPING_CART_ICON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SHOPPING_CART_ICON),
                Scroll.to(CHECKOUT_BUTTON),
                WaitUntil.the(CHECKOUT_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CHECKOUT_BUTTON),
                WaitUntil.the(FIRST_NAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(firstName).into(FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(LAST_NAME_FIELD),
                Enter.theValue(zip).into(ZIP_CODE_FIELD),
                Click.on(CONTINUE_BUTTON)
        );
    }

    public static GoToCartAndCheckout withDetails(String firstName, String lastName, String zip) {
        return new GoToCartAndCheckout(firstName, lastName, zip);
    }
}
