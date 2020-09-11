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
public class DeleteIngredientEvent extends EventObject{
    
    private int index;
    
    private String ingredient;
    private Double amount;
    private String unit;
    
    public DeleteIngredientEvent(Object o) {
        super(o);
    }

    public DeleteIngredientEvent(int index, Object source) {
        super(source);
        this.index = index;
    }
    
    public DeleteIngredientEvent(int index, String ingredient, Double amount, String unit, Object o) {
        super(o);
        this.index = index;
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
    
}
