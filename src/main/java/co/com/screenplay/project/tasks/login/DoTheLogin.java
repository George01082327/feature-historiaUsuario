package co.com.screenplay.project.tasks.login;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
public class DoTheLogin  implements Task {
    private String user;
    private String password;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(TXT_USER),
                Enter.theValue(password).into(TXT_PASSWORD),
                JavaScriptClick.on(BTN_LOGIN)
        );
    }


    public static DoTheLogin onTheSite() {
        return Instrumented.instanceOf(DoTheLogin.class).withProperties();
    }

    public DoTheLogin withThisUser(String user) {
        this.user = user;
        return this;
    }

    public DoTheLogin andThisPassword(String password) {
        this.password = password;
        return this;
    }
}


