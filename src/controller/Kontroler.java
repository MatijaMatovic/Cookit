/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.format.DateTimeFormatter;
import model.Recipe;
import view.RecipePanel;

/**
 *
 * @author Jovana
 */
public class Kontroler {
    
    public RecipePanel createRecipePanel(Recipe r) {
        RecipePanel rp = new RecipePanel();
        rp.getDateLabel().setText(r.getCreationDate()
                .format(DateTimeFormatter
                .ofPattern("dd.MM.yyyy. HH:mm")));
        rp.getNameLabel().setText(r.getName());
        /* If instructions are longer than 280 chars, it chopps it off */
        /* <html> tags enable the formatting of text in the label      */
        rp.getInstructionsLabel().setText("<html>" + r.getText().substring(0, 
                Math.min(r.getText().length(), 280)) + "...</html>");
        rp.getReviewsLabel().setText(Double.toString(r.calculateGradeAvg()));
        rp.getIngredientsLabel().setText(r.getIngredientsString());
        rp.getAppliancesLabel().setText(r.getAppliancesString());
    }
}
