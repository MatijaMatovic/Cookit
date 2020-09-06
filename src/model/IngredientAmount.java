package model;

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
    
}
