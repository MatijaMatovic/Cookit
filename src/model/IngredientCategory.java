package model;

import java.util.Objects;

public class IngredientCategory implements Comparable<IngredientCategory> {

    public IngredientCategory() {
    }

    public IngredientCategory(String name) {
        this.name = name;
    }
    
    

    private String name;

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

}
