/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.CreateRecipeWindow;

import java.util.EventObject;
import java.util.Set;

/**
 *
 * @author matija
 */
public class CreateRecipeEvent extends EventObject{
    private String name;
    private String text;
    private Set<String> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }
    
    public CreateRecipeEvent(Object o){
        super(o);
    }

    public CreateRecipeEvent(String name, String text, Set<String> ingredients, Object source) {
        super(source);
        this.name = name;
        this.text = text;
        this.ingredients = ingredients;
    }
    
    
}
