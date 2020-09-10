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
public class IngredientPickerEvent extends EventObject{
    
    boolean edit;

    public IngredientPickerEvent(Object o) {
        super(o);
    }

    public IngredientPickerEvent(boolean edit, Object source) {
        super(source);
        this.edit = edit;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
