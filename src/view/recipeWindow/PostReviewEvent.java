/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.recipeWindow;

import java.util.EventObject;
import model.RegisteredUser;

/**
 *
 * @author isido
 */
public class PostReviewEvent extends EventObject {
    private String comment;
    private Integer rating;
    private String reviewerUsername;
    private Long recipeId;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public String getComment() {
        return comment;
    }

    public Integer getRating() {
        return rating;
    }

    public String getReviewerUsername() {
        return reviewerUsername;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setReviewerUsername(String reviewerUsername) {
        this.reviewerUsername = reviewerUsername;
    }

    public PostReviewEvent(Object o) {
        super(o);
    }

    public PostReviewEvent(String comment, Integer rating, String reviewer, Long id, Object source) {
        super(source);
        this.comment = comment;
        this.rating = rating;
        this.reviewerUsername = reviewer;
        this.recipeId = id;
    }

}
