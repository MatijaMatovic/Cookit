/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.CreateRecipeWindow;

import java.util.EventListener;

/**
 *
 * @author isido
 */
public interface DeleteIngredientListener extends EventListener {
    public void deleteIngredientEventEmitted(DeleteIngredientEvent e);
}
