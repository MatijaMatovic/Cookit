/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author jovandjordjic
 */
public class RecipesList {
/*
    private Set<Recipe> recipesSet; // spisak svih recepata, sortiranih po datumu kreiranja (najnoviji prvo)

    private Map<Set<Ingredient>, Set<Recipe>> recipeByIngredientsMap; // Set<Ingredient> skup sastojaka neophodnih za recept
    private TreeMap<String, Set<Recipe>> recipeStringMap;
    private TreeMap<TreeSet<Ingredient>, Set<Recipe>> newIngredientRecipeMap;

    public RecipesList() {
        recipesSet = new TreeSet<>(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getCreationDateParsed().compareTo(o1.getCreationDateParsed());
            }

        });
        recipeByIngredientsMap = new HashMap<>();
        recipeStringMap = new TreeMap<>(String::compareTo);
        

///                                                "leksikografski" komparator
        newIngredientRecipeMap = new TreeMap<>(new Comparator<TreeSet<Ingredient>>() { 
            @Override
            public int compare(TreeSet<Ingredient> o1, TreeSet<Ingredient> o2) {
                int len1 = o1.size();
                int len2 = o2.size();

                int lim = Math.min(len1, len2);

                int k = 0;

                Ingredient i1 = o1.first();
                Ingredient i2 = o2.first();

                if (!(i1.equals(i2))) {
                    return i1.compareTo(i2);
                }

                while (k < lim) {
                    i1 = o1.higher(i1);
                    i2 = o2.higher(i2);

                    if (!(i1.equals(i2))) {
                        return i1.compareTo(i2);
                    }
                    k++;
                }

                return len1 - len2;

            }

        });

    }

    public void addRecipe(Recipe r) {
        Set<IngredientAmount> ingredientAmounts = r.getIngredientAmounts();
        List<IngredientAmount> sortedIngredentsList = new ArrayList(ingredientAmounts);
        sortedIngredentsList.sort(Ingredient::compareTo);

        String ingredientsString = String.join("", "", sortedIngredentsList.toString());

        recipeStringMap.putIfAbsent(ingredientsString, new TreeSet<>(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getCreationDateParsed().compareTo(o1.getCreationDateParsed());
            }

        }));

        recipeStringMap.get(ingredientsString).add(r);

    }

    public Set<Recipe> getRecipes() {
        return recipesSet;
    }

    public Set<Recipe> getRecipes(Set<Ingredient> ingredientsSet) {
        Set<Recipe> returnRecipes = new TreeSet<>(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getCreationDateParsed().compareTo(o1.getCreationDateParsed());
            }

        });

        Set<Set<Ingredient>> combinationsSet = PowerSet.powerSet(ingredientsSet);

        for (Set<Ingredient> ingSet : combinationsSet) {
            returnRecipes.addAll(recipeByIngredientsMap.get(ingSet));
        }

        return returnRecipes;
    }

    public Set<Recipe> getRecipes2(TreeSet<Ingredient> ingredientsSet) {
        Set<Recipe> returnRecipes = new TreeSet<>(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getCreationDateParsed().compareTo(o1.getCreationDateParsed());
            }

        });

        String ingredientsString = String.join("", "", ingredientsSet.toString());
        String firstIngredientString = ingredientsSet.first().toString();

        Collection<Set<Recipe>> coll1 = recipeStringMap.subMap(firstIngredientString, ingredientsString).values();
        coll1.forEach((Set<Recipe> rs) -> {
            returnRecipes.addAll(rs);
        });

        return returnRecipes;

    }
*/

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
