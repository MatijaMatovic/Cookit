package model;

import java.time.LocalDateTime;
import java.util.*;

public class Recipe {

    public Recipe() {
    }

    public String name;

    public Map<String, Double> sastojci;

    public String text;

    public LocalDateTime creationDate;
    public Long id;

    public boolean active = true;

    public RegisteredUser author;



    public Set<KitchenAppliance> requiredAppliances;

    public Set<Ingredient> ingredientAmounts;

    public Set<Review> reviews;

}