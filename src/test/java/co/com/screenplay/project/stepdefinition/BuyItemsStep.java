package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.tasks.checkout.ValidateAndFinishPurchase;
import co.com.screenplay.project.tasks.products.AddToCart;
import co.com.screenplay.project.tasks.products.GoToCartAndCheckout;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

@Slf4j
public class BuyItemsStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^Jorge selecciona varios artículos y los añade al carrito$")
    public void JorgeSeleccionaArticulosYLosAñadeAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddToCart.items()
        );
    }

    @When("^va al carrito de compra a proceder al checkout con (.*) (.*) (.*)$")
    public void vaAlCarritoDeCompraAProcederAlCheckout(String firstName, String lastName, String zip) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToCartAndCheckout.withDetails(firstName, lastName, zip)
        );
    }
    @Then("^validar productos y finalizar compra$")
    public void validaLosProductosYFinalizaLaCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidateAndFinishPurchase.validateAndFinish()
        );
    }
}
