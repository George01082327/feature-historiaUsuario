package co.com.screenplay.project.tasks.checkout;

import co.com.screenplay.project.questions.ValidateCheckoutOverview;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.userinterfaces.CheckoutOverviewPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidateAndFinishPurchase implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SAUCE_LABS_BOLT_TSHIRT, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(FINISH_BUTTON),
                Click.on(FINISH_BUTTON)
        );
    }

    public static ValidateAndFinishPurchase validateAndFinish() {
        return new ValidateAndFinishPurchase();
    }
}
