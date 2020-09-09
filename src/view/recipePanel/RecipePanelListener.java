/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.recipePanel;

import java.util.EventListener;

/**
 *
 * @author isido
 */
public interface RecipePanelListener extends EventListener{
    public void recipePanelEventEmitted(RecipePanelEvent e);
}
