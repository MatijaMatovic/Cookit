/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.recipePanel;

import java.util.EventObject;

/**
 *
 * @author isido
 */
public class RecipePanelEvent extends EventObject {
    
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RecipePanelEvent(Object source) {
        super(source);
    }

    public RecipePanelEvent(long id, Object source) {
        super(source);
        this.id = id;
    }
    
}
