/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jovandjordjic
 */
public class RecipesList {

    private Set<Recipe> recipesSet; // spisak svih recepata, sortiranih po datumu kreiranja (najnoviji prvo)
    private Map<Ingredient, Set<Recipe>> recipesByIngredientMap;

    public RecipesList() {
        recipesSet = new TreeSet<>(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getCreationDate().compareTo(o1.getCreationDate());
            }

        });
        recipesByIngredientMap = new HashMap<>();

    }

    public void addRecipe(Recipe r) {
        Set<IngredientAmount> ingredientAmounts = r.getIngredientAmounts();

        for (IngredientAmount ing : ingredientAmounts) {
            Ingredient i = ing.getIngredient();
            recipesByIngredientMap.putIfAbsent(i, new TreeSet<>(new Comparator<Recipe>() {
                @Override
                public int compare(Recipe o1, Recipe o2) {
                    return o2.getCreationDate().compareTo(o1.getCreationDate());
                }
            }));
            
            recipesByIngredientMap.get(i).add(r);
        }
    }

}
