package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.tasks.products.SelectItem;
import co.com.screenplay.project.questions.ValidateItemDetails;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Slf4j
public class ValidateItemsStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("^selecciona un artículo y ve su página de detalles$")
    public void seleccionaUnArticuloYVeSuPaginaDeDetalles() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectItem.withName("Sauce Labs Backpack")
        );
    }

    @Then("^debería ver el precio del artículo como (.*)$")
    public void deberiaVerElPrecioDelArticuloComo(String precio) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El precio del artículo", ValidateItemDetails.price(), equalTo(precio))
        );
    }

    @And("^debería ver la descripción del artículo como (.*)$")
    public void deberiaVerLaDescripcionDelArticuloComo(String descripcion) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La descripción del artículo contiene", ValidateItemDetails.descriptionContains(descripcion), is(true))
        );
    }
}
