package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateCheckoutOverview implements Question<String> {
    private final Target target;

    public ValidateCheckoutOverview(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }

    public static Question<String> valueOf(Target target) {
        return new ValidateCheckoutOverview(target);
    }
}
