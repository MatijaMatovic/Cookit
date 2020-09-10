/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.CreateRecipeWindow;

import java.util.EventObject;

/**
 *
 * @author isido
 */
public class OkIngredientEvent extends EventObject{
    
    private String ingredient;
    private Double amount;
    private String unit;
    boolean edit;
    
    public OkIngredientEvent(Object o) {
        super(o);
    }

    public OkIngredientEvent(String ingredient, Double amount, String unit, boolean edit, Object o) {
        super(o);
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
        this.edit = edit;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
