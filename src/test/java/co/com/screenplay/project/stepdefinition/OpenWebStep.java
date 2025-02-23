package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.models.LoginData;
import co.com.screenplay.project.questions.ValidateTheMessage;
import co.com.screenplay.project.tasks.login.DoTheLogin;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;


@Slf4j
public class OpenWebStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^Jorge ingresa las credenciales validas y oprime el boton login$")
    public void JorgeTypesTheFollowingData(DataTable loginDataList) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DoTheLogin.onTheSite()
                        .withThisUser(LoginData.setData(loginDataList).get(0).getUser())
                        .andThisPassword(LoginData.setData(loginDataList).get(0).getPass())
        );
    }

    @Then("^debería ver la página de (.*)$")
    public void shouldSeeTheProductsPage(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheMessage.value(), containsString(text)));
    }
}