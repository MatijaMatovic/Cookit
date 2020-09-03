package model;

import java.util.Objects;

public class KitchenAppliance implements Comparable<KitchenAppliance>{

    public KitchenAppliance() {
    }

    public String name;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.name);
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
        final KitchenAppliance other = (KitchenAppliance) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(KitchenAppliance o) {
       return name.compareTo(o.name);
    }
    
    
    
    

}
