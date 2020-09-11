package model;

import java.util.Objects;

public class IngredientAmount extends Ingredient{

    private Double amount;

    private String unit;

    public IngredientAmount() {
    }

    public IngredientAmount(String name, Double amount, String unit) {
        super(name);
        this.amount = amount;
        this.unit = unit;
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
        return this.name + " " + Double.toString(this.amount) + this.unit;
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
        final Ingredient other = (Ingredient) obj;
        if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    
}
