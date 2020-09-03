package model;

import java.time.LocalDateTime;
import java.util.*;

public class Recipe {

    public Recipe() {
    }

    private String name;

    private String text;

    private LocalDateTime creationDate;
    private Long id;

    private boolean active = true;

    private RegisteredUser author;

    private Set<KitchenAppliance> requiredAppliances;

    private Set<IngredientAmount> ingredientAmounts;

    private Set<Review> reviews;

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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public RegisteredUser getAuthor() {
        return author;
    }

    public void setAuthor(RegisteredUser author) {
        this.author = author;
    }

    public Set<KitchenAppliance> getRequiredAppliances() {
        return requiredAppliances;
    }

    public void setRequiredAppliances(Set<KitchenAppliance> requiredAppliances) {
        this.requiredAppliances = requiredAppliances;
    }

    public Set<IngredientAmount> getIngredientAmounts() {
        return ingredientAmounts;
    }

    public void setIngredientAmounts(Set<IngredientAmount> ingredientAmounts) {
        this.ingredientAmounts = ingredientAmounts;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
    
    

}
