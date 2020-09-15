package model;

import java.util.Objects;

public class IngredientAmount {
    private Ingredient ingredient;
    
    private Double amount;

    private String unit;

    public IngredientAmount() {
    }

    public IngredientAmount(String name, Double amount, String unit) {
        this.ingredient = new Ingredient(name);
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return this.ingredient.getName() + " " + Double.toString(this.amount) + this.unit;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.ingredient.getName());
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
        if (getClass() != obj.getClass() && Ingredient.class != obj.getClass() ) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            IngredientAmount other = (IngredientAmount) obj;
            return this.ingredient.getName().equals(other.getIngredient().getName());
        }
        else {
            Ingredient other = (Ingredient) obj;
            return this.ingredient.getName().equals(other.getName());
        }
           
    }
    
    
}
