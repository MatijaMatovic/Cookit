/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createIngredient;

import java.util.EventListener;

/**
 *
 * @author jovandjordjic
 */
public interface CreateIngredientListener extends EventListener{
    public void createIngredient(CreateIngredientEvent ev);
}
