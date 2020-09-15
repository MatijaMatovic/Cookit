package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Recipe {

    private String name;

    private String text;

    private String creationDate;
    
    private int id;

    private boolean active = true;

    private String authorUsername;

    private Set<KitchenAppliance> requiredAppliances;

    private Set<IngredientAmount> ingredientAmounts;

    private Set<Review> reviews;
    
    
    public Recipe() {
        creationDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        requiredAppliances = new HashSet<>();
        ingredientAmounts = new HashSet<>();
        reviews = new HashSet<>();
    }

    public Recipe(int id, String name, String text, String authorUsername, Set<IngredientAmount> ingredientAmounts) {
        this();
        this.id = id;
        this.name = name;
        this.text = text;
        this.authorUsername = authorUsername;
        this.ingredientAmounts = ingredientAmounts;
    }
    

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

    public LocalDateTime getCreationDateParsed() {
        return LocalDateTime.parse(creationDate, DateTimeFormatter.ISO_DATE_TIME);
    }
    
    public String getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void changeCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
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
        if (reviews.isEmpty())
            return 0.0d;
        
        Iterator<Review> it = reviews.iterator();
        double count = 0, sum = 0;
        while (it.hasNext()) {
            sum += it.next().rating;
            count++;
        }
        return sum / count;
    }

    /**
     * Returns all the ingredients as a string
     *
     * @return Formatted string containing all the ingredients
     */
    public String getIngredientsString() {
        Iterator<IngredientAmount> it = ingredientAmounts.iterator();
        StringBuilder sb = new StringBuilder("Sastojci: ");
        while (it.hasNext()) {
            sb.append(it.next().getIngredient().getName());
            sb.append(", ");
        }
        return sb.toString().substring(0, sb.length() - 1); // Cuts of the final ", "
    }

    /**
     * Returns all the required appliances as a string
     *
     * @return Formatted string containing all the required appliances
     */
    public String getAppliancesString() {
        Iterator<KitchenAppliance> it = requiredAppliances.iterator();
        StringBuilder sb = new StringBuilder("Aparati: ");
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

}
