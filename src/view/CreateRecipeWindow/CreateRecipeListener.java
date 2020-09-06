/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.CreateRecipeWindow;

import java.util.EventListener;

/**
 *
 * @author matija
 */
public interface CreateRecipeListener extends EventListener {
    public void createRecipeEventEmitted(CreateRecipeEvent r);
}
