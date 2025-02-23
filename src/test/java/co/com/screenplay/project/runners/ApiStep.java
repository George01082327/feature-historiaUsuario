package co.com.screenplay.project.runners;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class ApiStep {

    private static final String restApiUrl = "https://jsonplaceholder.typicode.com";

    @Test
    public void getAllPosts() {
        Actor jorge = Actor.named("Jorge the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        jorge.attemptsTo(
                Get.resource("/posts")
        );

        jorge.attemptsTo(
                Ensure.that(LastResponse.received().answeredBy(jorge).statusCode()).isEqualTo(200)
        );

        List<String> titles = LastResponse.received().answeredBy(jorge).jsonPath().getList("title");
        List<String> expectedTitles = List.of(
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "qui est esse",
                "ea molestias quasi exercitationem repellat qui ipsa sit aut",
                "eum et est occaecati"
        );

        for (String expectedTitle : expectedTitles) {
            jorge.attemptsTo(
                    Ensure.that("El título está presente en la respuesta", containsTitle(titles, expectedTitle)).isTrue()
            );
        }
    }

    @Test
    public void getPostsByUserId() {
        Actor jorge = Actor.named("Jorge the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        jorge.attemptsTo(
                Get.resource("/posts?userId=10")
        );
        jorge.attemptsTo(
                Ensure.that(LastResponse.received().answeredBy(jorge).statusCode()).isEqualTo(200)
        );
        List<String> titlesUser10 = LastResponse.received().answeredBy(jorge).jsonPath().getList("title");
        EnsureTitlesArePresent(titlesUser10, List.of("expectedTitle1", "expectedTitle2")); // Reemplaza con los títulos esperados

        jorge.attemptsTo(
                Get.resource("/posts?userId=2")
        );
        jorge.attemptsTo(
                Ensure.that(LastResponse.received().answeredBy(jorge).statusCode()).isEqualTo(200)
        );
        List<String> titlesUser2 = LastResponse.received().answeredBy(jorge).jsonPath().getList("title");
        EnsureTitlesArePresent(titlesUser2, List.of("expectedTitle3", "expectedTitle4")); // Reemplaza con los títulos esperados

        jorge.attemptsTo(
                Get.resource("/posts?userId=4")
        );
        jorge.attemptsTo(
                Ensure.that(LastResponse.received().answeredBy(jorge).statusCode()).isEqualTo(200)
        );
        List<String> titlesUser4 = LastResponse.received().answeredBy(jorge).jsonPath().getList("title");
        EnsureTitlesArePresent(titlesUser4, List.of("expectedTitle5", "expectedTitle6")); // Reemplaza con los títulos esperados
    }

    private void EnsureTitlesArePresent(List<String> titles, List<String> expectedTitles) {
        for (String expectedTitle : expectedTitles) {
            Ensure.that("El título está presente en la respuesta", containsTitle(titles, expectedTitle)).isTrue();
        }
    }

    private Question<Boolean> containsTitle(List<String> titles, String expectedTitle) {
        return actor -> titles.contains(expectedTitle);
    }
}