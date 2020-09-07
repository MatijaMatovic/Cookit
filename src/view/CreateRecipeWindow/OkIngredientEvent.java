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
    
    public OkIngredientEvent(Object o) {
        super(o);
    }

    public OkIngredientEvent(String ingredient, Double amount, String unit, Object o) {
        super(o);
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }
    
}
