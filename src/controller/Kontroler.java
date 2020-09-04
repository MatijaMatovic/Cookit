/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import model.Recipe;
import model.Review;
import view.RecipePanel;
import view.recipeWindow.RecipeFrame;
import view.recipeWindow.ReviewPanel;

/**
 *
 * @author Jovana
 */
public class Kontroler {
    
    public RecipePanel createRecipePanel(Recipe r) {
        RecipePanel rp = new RecipePanel();
        rp.setRecipeId(r.getId());
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
        rp.getAuthorLabel().setText(r.getAuthor().getAccount().getUsername());
        return rp;
    }
    
    public ReviewPanel createReviewPanel(Review r) {
        ReviewPanel rp = new ReviewPanel();
        rp.getTextLabel().setText(r.comment);
        rp.getUsernameLabel().setText(r.reviewer.getAccount().getUsername());
        rp.getRatingLabel().setText(Integer.toString(r.rating));
        return rp;
    }
    
    public RecipeFrame createRecipeFrame(Recipe r) {
        RecipeFrame rf = new RecipeFrame();
        rf.getNameLabel().setText(r.getName());
        rf.getRatingLabel().setText(Double.toString(r.calculateGradeAvg()));
        rf.getInstructionsPane().setText(r.getText());
        
        DefaultListModel ingredientsListModel = new DefaultListModel();
        ingredientsListModel.addAll(r.getIngredientAmounts()
                                     .stream()
                                     .map(i -> i.toString())
                                     .collect(Collectors.toList()));
        rf.setIngredientsList(new JList<>(ingredientsListModel));
        
        return rf;
    }
}
