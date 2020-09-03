package model;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class RecipeCollection {

    public RecipeCollection() {
        recipeList = new TreeSet<>(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getCreationDate().compareTo(o1.getCreationDate());
            }
        });

        privateCollection = true;
    }

    private String name;

    private boolean privateCollection;

    private Set<Recipe> recipeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivateCollection() {
        return privateCollection;
    }

    public void setPrivateCollection(boolean privateCollection) {
        this.privateCollection = privateCollection;
    }

    public Set<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(Set<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

}
