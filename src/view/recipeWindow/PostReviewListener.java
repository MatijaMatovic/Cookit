/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.recipeWindow;

import java.util.EventListener;

/**
 *
 * @author isido
 */
public interface PostReviewListener extends EventListener {
    public void postReviewEventEmitted(PostReviewEvent e);
}
