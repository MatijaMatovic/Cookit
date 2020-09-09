/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createIngredient;

import java.util.EventObject;
import model.IngredientCategory;

/**
 *
 * @author jovandjordjic
 */
public class CreateIngredientEvent extends EventObject {

    private String ingredientString;
    private IngredientCategory ingredientCategory;

    public CreateIngredientEvent(String ingredientString, IngredientCategory ingredientCategory, Object source) {
        super(source);
        this.ingredientString = ingredientString;
        this.ingredientCategory = ingredientCategory;
    }

    public IngredientCategory getIngredientCategory() {
        return ingredientCategory;
    }

    public void setIngredientCategory(IngredientCategory ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }

    public String getIngredientString() {
        return ingredientString;
    }

    public void setIngredientString(String ingredientString) {
        this.ingredientString = ingredientString;
    }

    public CreateIngredientEvent(Object source) {
        super(source);
    }

}
