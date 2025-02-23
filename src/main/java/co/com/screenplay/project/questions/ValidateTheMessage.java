package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.screenplay.project.userinterfaces.ProductsPage.PAGE_TITLE;

public class ValidateTheMessage implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return PAGE_TITLE.resolveFor(actor).getText();
    }

    public static Question<String> value() {
        return new ValidateTheMessage();
    }

}
