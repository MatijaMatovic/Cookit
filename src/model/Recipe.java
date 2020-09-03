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
    
        public double calculateGradeAvg() {
        Iterator<Review> it = reviews.iterator();
        double count = 0, sum = 0;
        while (it.hasNext()) {
            sum += it.next().rating;
            count++;
        }
        return sum/count;
    }
    
    /**
     * Returns all the ingredients as a string
     * @return Formatted string containing all the ingredients
     */
    public String getIngredientsString() {
        Iterator<IngredientAmount> it = ingredientAmounts.iterator();
        StringBuilder sb = new StringBuilder("Sastojci: ");
        while (it.hasNext()) {
            sb.append(it.next().getIngredient());
            sb.append(", ");
        }
        return sb.toString().substring(0, sb.length()-1); // Cuts of the final ", "
    }
    
    /**
     * Returns all the required appliances as a string
     * @return Formatted string containing all the required appliances
     */
    public String getAppliancesString() {
        Iterator<KitchenAppliance> it = requiredAppliances.iterator();
        StringBuilder sb = new StringBuilder("Aparati: ");
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        return sb.toString().substring(0, sb.length()-1);
    }

}
