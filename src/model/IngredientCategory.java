package model;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class IngredientCategory implements Comparable<IngredientCategory> {

    public IngredientCategory() {
    }

    public IngredientCategory(String name) {
        this.name = name;
        this.ingredientsSet = new TreeSet<>();
    }

    private String name;
    private Set<Ingredient> ingredientsSet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IngredientCategory other = (IngredientCategory) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(IngredientCategory o) {
        return this.name.compareTo(o.name);
    }
    
    public void addIngredient(Ingredient i){
        ingredientsSet.add(i);
    }

    public Set<Ingredient> getIngredientsSet() {
        return ingredientsSet;
    }

    public void setIngredientsSet(Set<Ingredient> ingredientsSet) {
        this.ingredientsSet = ingredientsSet;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
}
