/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ingredientPanel;

import java.util.EventListener;

/**
 *
 * @author Jovana
 */
public interface SearchListener extends EventListener{
    public void searchEventEmitted(SearchEvent e);
}
