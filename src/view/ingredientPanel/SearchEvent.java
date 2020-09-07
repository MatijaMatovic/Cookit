/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ingredientPanel;

import java.util.EventObject;
import java.util.Set;

/**
 *
 * @author Jovana
 */
public class SearchEvent extends EventObject {
    
    private Set<String> ingredients;
    private Set<String> appliances;
    
    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> i) {
        this.ingredients = i;
    }
    
    public Set<String> getAppliances() {
        return appliances;
    }

    public void setAppliances(Set<String> a) {
        this.appliances = a;
    }
    
     public SearchEvent(Object o) {
        super(o);
    }

    public SearchEvent(Set<String> i,Set<String> a, Object o) {
        super(o);
        this.ingredients = i;
        this.appliances = a;
    }
}
