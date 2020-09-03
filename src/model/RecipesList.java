/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jovandjordjic
 */
public class RecipesList {

    private Set<Recipe> recipesSet; // spisak svih recepata, sortiranih po datumu kreiranja (najnoviji prvo)

    private Map<Set<Ingredient>, Set<Recipe>> recipeByIngredientsMap;

    public RecipesList() {
        recipesSet = new TreeSet<>(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getCreationDate().compareTo(o1.getCreationDate());
            }

        });
        recipeByIngredientsMap = new HashMap<>();

    }

    public void addRecipe(Recipe r) {
        Set<IngredientAmount> ingredientAmounts = r.getIngredientAmounts();

        Set<Ingredient> ingredientsSet = new HashSet<>();

        ingredientAmounts.stream().map(ing -> ing.getIngredient()).forEachOrdered(i -> {
            ingredientsSet.add(i);
        });

        recipeByIngredientsMap.putIfAbsent(ingredientsSet, new TreeSet<>());
        recipeByIngredientsMap.get(ingredientsSet).add(r);

    }

    public Set<Recipe> getRecipes() {
        return recipesSet;
    }

    public Set<Recipe> getRecipes(Set<Ingredient> ingredientsSet) {
        Set<Recipe> returnRecipes = new TreeSet<>(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getCreationDate().compareTo(o1.getCreationDate());
            }

        });

        Set<Set<Ingredient>> combinationsSet = PowerSet.powerSet(ingredientsSet);

        for (Set<Ingredient> ingSet : combinationsSet) {
            returnRecipes.addAll(recipeByIngredientsMap.get(ingSet));
        }

        return returnRecipes;
    }

}

class PowerSet {

    static <T> Set<Set<T>> powerSet(Set<T> set) {
        T[] element = (T[]) set.toArray();
        final int SET_LENGTH = 1 << element.length;
        Set<Set<T>> powerSet = new HashSet<>();
        for (int binarySet = 0; binarySet < SET_LENGTH; binarySet++) {
            Set<T> subset = new HashSet<>();
            for (int bit = 0; bit < element.length; bit++) {
                int mask = 1 << bit;
                if ((binarySet & mask) != 0) {
                    subset.add(element[bit]);
                }
            }
            powerSet.add(subset);
        }
        return powerSet;
    }
}
