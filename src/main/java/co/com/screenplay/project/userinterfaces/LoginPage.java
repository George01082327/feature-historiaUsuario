package co.com.screenplay.project.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target TXT_USER = Target.the("Text field for user")
            .locatedBy("//input[@name='user-name']");
    public static final Target TXT_PASSWORD = Target.the("Text field for password")
            .locatedBy("//input[@name='password']");
    public static final Target BTN_LOGIN = Target.the("button to log in")
            .locatedBy("#login-button");
}

