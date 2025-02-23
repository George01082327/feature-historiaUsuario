package co.com.screenplay.project.tasks.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPosts implements Task {

    private final String resource;

    public GetPosts(String resource) {
        this.resource = resource;
    }

    public static GetPosts from(String resource) {
        return instrumented(GetPosts.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource),
                Ensure.that(LastResponse.received().answeredBy(actor).statusCode()).isEqualTo(200)
        );
    }
}
