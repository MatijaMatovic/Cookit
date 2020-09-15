package model;

import java.util.Objects;

public class Ingredient implements Comparable<Ingredient> {

    protected String name;

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
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
        if (getClass() != obj.getClass() && IngredientAmount.class != obj.getClass() ) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Ingredient other = (Ingredient) obj;
            return this.name.equals(other.getName());
        }
        else {
            IngredientAmount other = (IngredientAmount) obj;
            return this.name.equals(other.getIngredient().getName());
        }
    }

    @Override
    public int compareTo(Ingredient o) {
        return this.name.compareTo(o.name);
    }

}
