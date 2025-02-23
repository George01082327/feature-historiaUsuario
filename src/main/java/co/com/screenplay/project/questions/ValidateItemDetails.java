package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Question;

import static co.com.screenplay.project.userinterfaces.ItemDetailsPage.*;

public class ValidateItemDetails {

    public static Question<String> price() {
        return actor -> ITEM_PRICE.resolveFor(actor).getText();
    }

    public static Question<Boolean> descriptionContains(String expectedText) {
        return actor -> {
            String actualText = ITEM_DESCRIPTION.resolveFor(actor).getText();

            String cleanedActualText = actualText.replaceAll("\\s+", " ").trim();
            String cleanedExpectedText = expectedText.replaceAll("\\s+", " ").trim();

            System.out.println("Texto limpio de la descripción: " + cleanedActualText);
            System.out.println("Texto limpio esperado: " + cleanedExpectedText);

            return cleanedActualText.contains(cleanedExpectedText);
        };
    }
}